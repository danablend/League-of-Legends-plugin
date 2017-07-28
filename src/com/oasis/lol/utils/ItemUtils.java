package com.oasis.lol.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enderqura on 28/07/2017 at 19:16.
 */
public class ItemUtils {

    private static ItemUtils instance = new ItemUtils();

    private ItemUtils(){}

    public static ItemUtils getInstance() {
        return instance;
    }

    public ItemStack nameItem(ItemStack item, String name){

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createItem(Material mat, int amount, short data, String displayName) {
        ItemStack item = new ItemStack(mat, amount, data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.color(displayName));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(Material mat, int amount, short data, String displayName, String... lore) {
        ItemStack item = new ItemStack(mat, amount, data);
        ItemMeta meta = item.getItemMeta();
        List<String> loreList = new ArrayList<>();
        for(String str : lore) {
            loreList.add(Utils.color(str));
        }
        meta.setLore(loreList);
        meta.setDisplayName(Utils.color(displayName));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(Material mat, int amount, short data, String displayName, List<String> lore) {
        ItemStack item = new ItemStack(mat, amount, data);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(Utils.color(displayName));
        item.setItemMeta(meta);
        return item;
    }

    public static void addLoreToItem(ItemStack item, String... lore) {
        List<String> lorelist = null;
        lorelist = (item.hasItemMeta() && item.getItemMeta().hasLore()) ? item.getItemMeta().getLore() : new ArrayList<>();
        for(String str : lore) {
            lorelist.add(Utils.color(str));
        }
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lorelist);
        item.setItemMeta(meta);
    }

    public static String getLoreLine(ItemStack item, int index) {
        if(item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore()) {
            return null;
        }
        List<String> lore = item.getItemMeta().getLore();
        return lore.get(index);
    }

    public static int getLoreAmount(ItemStack item) {
        if(item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore()) {
            return 0;
        }
        return item.getItemMeta().getLore().size();
    }

    public static boolean isHelmet(Material type) {
        if (type.name().endsWith("HELMET")) {
            return true;
        }

        return false;
    }

    public static boolean isChestplate(Material type) {
        if (type.name().endsWith("CHESTPLATE")) {
            return true;
        }

        return false;
    }

    public static boolean isLeggings(Material type) {
        if (type.name().endsWith("LEGGINGS")) {
            return true;
        }

        return false;
    }

    public static boolean isBoots(Material type) {
        if (type.name().endsWith("BOOTS")) {
            return true;
        }

        return false;
    }

    public static boolean isArmor(Material type) {
        if(isHelmet(type)
                || isChestplate(type)
                || isLeggings(type)
                || isBoots(type)) {
            return true;
        }
        return false;
    }

    public static boolean isSword(Material type) {
        if (type.name().endsWith("SWORD")) {
            return true;
        }

        return false;
    }

    public static boolean isAxe(Material type) {
        if (type.name().endsWith("AXE")) {
            return true;
        }
        return false;
    }

    public static boolean isBow(Material type) {
        if (type.name().endsWith("BOW")) {
            return true;
        }
        return false;
    }

    public static boolean isWeapon(Material type) {
        if(isSword(type)
                || isAxe(type)) {
            return true;
        }
        return false;
    }

    public static boolean isPickaxe(Material type) {
        if (type.name().endsWith("PICKAXE")) {
            return true;
        }

        return false;
    }

    public static boolean isShovel(Material type) {
        if (type.name().endsWith("SHOVEL")) {
            return true;
        }

        return false;
    }

    public static boolean isHoe(Material type) {
        if (type.name().endsWith("HOE")) {
            return true;
        }

        return false;
    }

    public static boolean isTool(Material type) {
        if(isPickaxe(type)
                || isShovel(type)
                || isHoe(type)
                || isAxe(type)) {
            return true;
        }
        return false;
    }

    public static boolean isGear(Material type) {
        if (	   isHelmet(type)
                || isChestplate(type)
                || isLeggings(type)
                || isBoots(type)
                || isSword(type)
                || isAxe(type)
                || isBow(type)
                || isPickaxe(type)
                || isShovel(type)
                || isHoe(type)) {
            return true;
        }

        return false;
    }

}
