package com.oasis.lol.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

}
