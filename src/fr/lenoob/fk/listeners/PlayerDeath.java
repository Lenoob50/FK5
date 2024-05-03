package fr.lenoob.fk.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.lenoob.fk.main;

public class PlayerDeath implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage("");
		if(main.getInstance().scenario.contains("Kaboum")) {
			e.getDrops().add(new ItemStack(Material.TNT));
		}
	}

}
