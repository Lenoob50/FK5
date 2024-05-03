package fr.lenoob.fk.listeners;

import fr.lenoob.fk.main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnPearlUseE implements Listener {

    @EventHandler
    public void onPearlUse(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack it = p.getInventory().getItemInHand();
        Action act = e.getAction();
        if(main.getInstance().scenario.contains("EnderPearl")){
            if(it.getType() == Material.ENDER_PEARL) {
                if(act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                }
            }
        }else {
            return;
        }
    }

}
