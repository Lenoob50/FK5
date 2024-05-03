package fr.lenoob.fk.listeners;

import fr.lenoob.fk.main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class OnRodUse implements Listener {

	@EventHandler
	public void onInterract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack it = p.getInventory().getItemInHand();
		Action act = e.getAction();
		if (main.getInstance().scenario.contains("Rodless")) {
			if (it.getType() == Material.FISHING_ROD) {
				if (act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) {
					e.setCancelled(true);
				}
			}
		} else {
			return;
		}
	}
}
