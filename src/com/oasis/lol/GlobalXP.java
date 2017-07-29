package com.oasis.lol;

import com.oasis.lol.events.ExpGainEvent;
import com.oasis.lol.events.LevelUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Enderqura on 28/07/2017 at 19:34.
 */
public class GlobalXP implements Listener{

    public static GlobalXP getInstance(){return instance; }
    private Main plugin = Main.getPlugin(Main.class);


    //From LoL wiki
    // XP needed to level up etc.
    public final int togetlevel2 = 88;
    public final int togetlevel3 = 92;
    public final int togetlevel4 = 99;
    public final int togetlevel5 = 118;
    public final int togetlevel6 = 327;
    public final int togetlevel7 = 312;
    public final int togetlevel8 = 322;
    public final int togetlevel9 = 344;
    public final int togetlevel10 = 372;
    public final int togetlevel11 = 637;
    public final int togetlevel12 = 636;
    public final int togetlevel13 = 646;
    public final int togetlevel14 = 663;
    public final int togetlevel15 = 684;
    public final int togetlevel16 = 709;
    public final int togetlevel17 = 735;
    public final int togetlevel18 = 763;
    public final int togetlevel19 = 793;
    public final int togetlevel20 = 823;
    public final int togetlevel21 = 1136;
    public final int togetlevel22 = 1147;
    public final int togetlevel23 = 1162;
    public final int togetlevel24 = 1180;
    public final int togetlevel25 = 1201;
    public final int togetlevel26 = 1224;
    public final int togetlevel27 = 1250;
    public final int togetlevel28 = 1278;
    public final int togetlevel29 = 1308;
    public final int togetlevel30 = 1340;

    private static GlobalXP instance = new GlobalXP();

    private GlobalXP(){

    }

    public long getPlayerXp(Player player){
        return getExpByUUID(player.getUniqueId());
    }

    public long getExpByUUID(UUID uuid){

        ResultSet results;

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("SELECT * FROM player_data WHERE UUID=?");
            statement.setString(1, uuid.toString());
            results = statement.executeQuery();
            results.next();
            return results.getLong("XP");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getPlayerLevel(Player player){

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("SELECT * FROM player_data WHERE UUID=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet results = statement.executeQuery();
            results.next();

            return results.getInt("LEVEL");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public int getUUIDLevel(UUID uuid){

        ResultSet results;

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("SELECT * FROM player_data WHERE UUID=?");
            statement.setString(1, uuid.toString());
            results = statement.executeQuery();
            results.next();
            return results.getInt("LEVEL");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public void addXpForPlayer(Player player, long amount){

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("UPDATE player_data SET XP=? WHERE UUID=?");
            statement.setLong(1, getPlayerXp(player) + amount);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addXpForUUID(UUID uuid, long amount){

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("UPDATE player_data SET XP=? WHERE UUID=?");
            statement.setLong(1, getExpByUUID(uuid) + amount);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setExpForPlayer(Player player, long amount){

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("UPDATE player_data SET XP=? WHERE UUID=?");
            statement.setLong(1, amount);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setPlayerLevel(Player player, int level){


        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("UPDATE player_data SET XP=? WHERE UUID=?");
            statement.setLong(1, level);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void levelUpPlayer(Player player){


        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("UPDATE player_data SET XP=? WHERE UUID=?");
            statement.setLong(1, getPlayerLevel(player) + 1);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getXpForNextLevel(UUID uuid){


        int level = getUUIDLevel(uuid);

        switch(level){
            case 1: return togetlevel2;
            case 2: return togetlevel3;
            case 3: return togetlevel4;
            case 4: return togetlevel5;
            case 5: return togetlevel6;
            case 6: return togetlevel7;
            case 7: return togetlevel8;
            case 8: return togetlevel9;
            case 9: return togetlevel10;
            case 10: return togetlevel11;
            case 11: return togetlevel12;
            case 12: return togetlevel13;
            case 13: return togetlevel14;
            case 14: return togetlevel15;
            case 15: return togetlevel16;
            case 16: return togetlevel17;
            case 17: return togetlevel18;
            case 18: return togetlevel19;
            case 19: return togetlevel20;
            case 20: return togetlevel21;
            case 21: return togetlevel22;
            case 22: return togetlevel23;
            case 23: return togetlevel24;
            case 24: return togetlevel25;
            case 25: return togetlevel26;
            case 26: return togetlevel27;
            case 27: return togetlevel28;
            case 28: return togetlevel29;
            case 29: return togetlevel30;
        }

        return Integer.MAX_VALUE;

    }

    @EventHandler
    public void onExpGain(ExpGainEvent event){

        long before = getExpByUUID(event.getPlayer().getUniqueId());

        addXpForPlayer(event.getPlayer(), event.getAmount());

        if(getPlayerXp(event.getPlayer()) >= getXpForNextLevel(event.getPlayer().getUniqueId())){

            long l = getPlayerXp(event.getPlayer()) - getXpForNextLevel(event.getPlayer().getUniqueId());

            Bukkit.getServer().getPluginManager().callEvent(new LevelUpEvent(getPlayerLevel(event.getPlayer()), getPlayerLevel(event.getPlayer()) +1, event.getPlayer()));

            setExpForPlayer(event.getPlayer(), l);

            return;
        }

        Bukkit.getServer().getLogger().info(event.getPlayer().getName() + " earned " + event.getAmount() + " xp (Previously: " + before + ")");

    }

    @EventHandler
    public void onLevelUp(LevelUpEvent event){

        levelUpPlayer(event.getPlayer());

    }




}
