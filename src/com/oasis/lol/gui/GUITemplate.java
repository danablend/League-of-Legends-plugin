package com.oasis.lol.gui;


import com.oasis.lol.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUITemplate{

    private static GUITemplate instance = new GUITemplate();
    private ItemUtils iu = ItemUtils.getInstance();

    public static GUITemplate getInstance() {
        return instance;
    }

    private GUITemplate(){}

    private ItemStack one = iu.nameItem(new ItemStack(Material.GOLD_INGOT), "§e§lItem One");
    private ItemStack two = iu.nameItem(new ItemStack(Material.WOOD), "§c§lItem Two");
    private ItemStack three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private String name = "§6§lName";
    private Inventory inventory = Bukkit.createInventory(null, 27, name);


    public void open(Player player){

        inventory.setItem(10, one);
        inventory.setItem(14, two);
        inventory.setItem(17, three);

        player.openInventory(inventory);

    }

    @EventHandler
    public void click(InventoryClickEvent event){

        if(event.getClickedInventory().getName().equals(name)){

            if(!(event.getWhoClicked() instanceof Player)) return;

            Player p = (Player) event.getWhoClicked();

            event.setCancelled(true);

            if(event.getCurrentItem().equals(one)){



            }

            if(event.getCurrentItem().equals(two)){




            }

            if(event.getCurrentItem().equals(three)){




            }

        }

    }

}
