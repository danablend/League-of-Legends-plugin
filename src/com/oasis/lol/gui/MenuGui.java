package com.oasis.lol.gui;

import com.oasis.lol.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Enderqura on 28/07/2017 at 19:07.
 */
public class MenuGui implements Listener {

    private static MenuGui instance = new MenuGui();
    private ItemUtils iu = ItemUtils.getInstance();

    public static MenuGui getInstance() {
        return instance;
    }

    private MenuGui(){}

    private ItemStack one = iu.nameItem(new ItemStack(Material.GOLD_INGOT), "§e§lShop");
    private ItemStack two = iu.nameItem(new ItemStack(Material.WOOD), "§c§lPlay");
    private ItemStack three = iu.nameItem(new ItemStack(Material.GRASS), "§d§lOptions");
    private String name = "§6§lMenu";
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

            event.setCancelled(true);

            if(!(event.getWhoClicked() instanceof Player)) return;

            Player p = (Player) event.getWhoClicked();

            if(event.getCurrentItem().equals(one)){



            }

            if(event.getCurrentItem().equals(two)){

                PlayGui.getInstance().open(p);

                p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(2, Note.Tone.E));

                return;


            }

            if(event.getCurrentItem().equals(three)){




            }

        }

    }

}
