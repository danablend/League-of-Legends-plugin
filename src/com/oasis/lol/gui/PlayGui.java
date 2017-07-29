package com.oasis.lol.gui;

import com.oasis.lol.GameType;
import com.oasis.lol.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Enderqura on 29/07/2017 at 17:52.
 */
public class PlayGui implements Listener{

    private static Map<UUID, GameType> chosen = new HashMap<>();

    private static PlayGui instance = new PlayGui();
    private ItemUtils iu = ItemUtils.getInstance();

    public static PlayGui getInstance() {
        return instance;
    }

    private PlayGui(){}

    private ItemStack one = iu.nameItem(new ItemStack(Material.IRON_INGOT), "§e§lRanked");
    private ItemStack two = iu.nameItem(new ItemStack(Material.DIAMOND), "§c§lCasual");
    private ItemStack three = iu.nameItem(new ItemStack(Material.DIRT), "§d§lComing Soon");
    private String name = "§6§lPlay";
    private Inventory inventory = Bukkit.createInventory(null, 27, name);

    public GameType getChosenType(UUID uuid){

        if(!chosen.containsKey(uuid)) return null;

        GameType t = chosen.get(uuid);

        return t;
    }


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
