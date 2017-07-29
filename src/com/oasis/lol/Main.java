package com.oasis.lol;

import com.oasis.lol.gui.MenuGui;
import com.oasis.lol.gui.PlayGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;
import java.util.UUID;

/**
 * Created by Enderqura on 16/07/2017 at 09:28.
 */
public class Main extends JavaPlugin implements Listener{

    private static Main instance;
    public static final Main getInstance() { return instance; }

    private Connection connection;
    private String host, database, username, password;
    private int port;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(MenuGui.getInstance(), this);
        getServer().getPluginManager().registerEvents(GlobalXP.getInstance(), this);
        getServer().getPluginManager().registerEvents(PlayGui.getInstance(), this);

        mysqlSetup();
    }

    @Override
    public void onDisable() {

    }

    public void mysqlSetup() {
        host = "localhost";
        port = 4;
        database = "lol_data";
        username = "root";
        password = "";

        try {

            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(
                        DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database,
                                this.username, this.password));

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean playerExists(UUID uuid) {
        try {
            PreparedStatement statement = this.getConnection()
                    .prepareStatement("SELECT * FROM player_data WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet results = statement.executeQuery();
            if (results.next()) {
                getServer().broadcastMessage(ChatColor.YELLOW + "Player Found");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        if(playerExists(event.getPlayer().getUniqueId())){

            return;

        }

        createPlayer(event.getPlayer().getUniqueId());

    }

    public void createPlayer(final UUID uuid) {
        try {
            PreparedStatement insert = getConnection()
                    .prepareStatement("INSERT INTO player_data (UUID,XP,COINS,LEVEL) VALUES (?,?,?)");
            insert.setString(1, uuid.toString());
            insert.setInt(2, 0);
            insert.setInt(3, 100);
            insert.setInt(4, 1);
            insert.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
