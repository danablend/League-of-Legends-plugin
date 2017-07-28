package com.oasis.lol;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Enderqura on 28/07/2017 at 19:34.
 */
public class GlobalXP {

    private static GlobalXP instance = new GlobalXP();
    private GlobalXP(){}
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

    public long getPlayerXp(Player player){

        try {
            PreparedStatement statement = plugin.getConnection()
                    .prepareStatement("SELECT * FROM player_data WHERE UUID=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet results = statement.executeQuery();
            results.next();

            return results.getLong("XP");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public long getUUIDXp(UUID uuid){

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




}
