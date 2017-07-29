package com.oasis.lol.gui;

import com.oasis.lol.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 29/07/2017 at 18:09.
 */
public class ChampionSelectorGui implements Listener {

    private static ChampionSelectorGui instance = new ChampionSelectorGui();
    private ItemUtils iu = ItemUtils.getInstance();

    public static ChampionSelectorGui getInstance() {
        return instance;
    }

    private ChampionSelectorGui(){}

    private ItemStack one = iu.nameItem(new ItemStack(Material.GOLD_INGOT), "§e§lItem One");
    private ItemStack two = iu.nameItem(new ItemStack(Material.WOOD), "§c§lItem Two");
    private ItemStack three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack ten = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack eleven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twelve = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fourteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack sixteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack seventeen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack eighteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack nineteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack twenty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack thirty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack forty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private ItemStack fifty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");

    private String name = "§6§lPick a Champion";
    private Inventory inventory = Bukkit.createInventory(null, 54, name);


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
