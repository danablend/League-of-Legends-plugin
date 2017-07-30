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

    private final ItemStack one = iu.nameItem(new ItemStack(Material.GOLD_INGOT), "§e§lItem One");
    private final ItemStack two = iu.nameItem(new ItemStack(Material.WOOD), "§c§lItem Two");
    private final ItemStack three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack ten = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack eleven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twelve = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fourteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack sixteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack seventeen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack eighteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack nineteen = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack twenty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack thirty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_five = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_six = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_seven = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_eight = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack forty_nine = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifty = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifty_one = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifty_two = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifty_three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");
    private final ItemStack fifty_four = iu.nameItem(new ItemStack(Material.GRASS), "§d§lItem Three");

    private String name = "§6§lPick a Champion";
    private Inventory inventory = Bukkit.createInventory(null, 54, name);


    public void open(Player player){

        inventory.setItem(0, one);
        inventory.setItem(1, two);
        inventory.setItem(2, three);
        inventory.setItem(3, four);
        inventory.setItem(4, five);
        inventory.setItem(5, six);
        inventory.setItem(6, seven);
        inventory.setItem(7, eight);
        inventory.setItem(8, nine);
        inventory.setItem(9, ten);
        inventory.setItem(10, eleven);
        inventory.setItem(11, twelve);
        inventory.setItem(12, thirteen);
        inventory.setItem(13, fourteen);
        inventory.setItem(14, fifteen);
        inventory.setItem(15, sixteen);
        inventory.setItem(16, seventeen);
        inventory.setItem(17, eighteen);
        inventory.setItem(18, nineteen);
        inventory.setItem(19, twenty);
        inventory.setItem(20, twenty_one);
        inventory.setItem(21, twenty_two);
        inventory.setItem(22, twenty_three);
        inventory.setItem(23, twenty_four);
        inventory.setItem(24, twenty_five);
        inventory.setItem(25, twenty_six);
        inventory.setItem(26, twenty_seven);
        inventory.setItem(27, twenty_eight);
        inventory.setItem(28, twenty_nine);
        inventory.setItem(29, thirty);
        inventory.setItem(30, thirty_one);
        inventory.setItem(31, thirty_two);
        inventory.setItem(32, thirty_three);
        inventory.setItem(33, thirty_four);
        inventory.setItem(34, thirty_five);
        inventory.setItem(35, thirty_six);
        inventory.setItem(36, thirty_seven);
        inventory.setItem(37, thirty_eight);
        inventory.setItem(38, thirty_nine);
        inventory.setItem(39, forty);
        inventory.setItem(40, forty_one);
        inventory.setItem(41, forty_two);
        inventory.setItem(42, forty_three);
        inventory.setItem(43, forty_four);
        inventory.setItem(44, forty_five);
        inventory.setItem(45, forty_six);
        inventory.setItem(46, forty_seven);
        inventory.setItem(47, forty_eight);
        inventory.setItem(48, forty_nine);
        inventory.setItem(49, fifty);
        inventory.setItem(50, fifty_one);
        inventory.setItem(51, fifty_two);
        inventory.setItem(52, fifty_three);
        inventory.setItem(53, fifty_four);


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
