package fr.lenoob.fk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class OnDimChange implements Listener {
	
	@EventHandler
	public void onDimChangeEvent(PlayerPortalEvent e) {
		Player p = e.getPlayer();
		if(e.getTo().getWorld().getName().equals("world_nether")&& !main.getInstance().isState(FKState.NETHER)) {
			e.setCancelled(true);
			p.sendMessage(main.getInstance().getPrefix()+ ChatColor.GOLD+"Tu ne peux pas aller dans le nether");
			World w = Bukkit.getWorld("world");
			Location loc = w.getSpawnLocation();
			p.teleport(loc);
		}else {
			e.setCancelled(false);
		}
		if(e.getTo().getWorld().getName().equals("world_the_end")&& !main.getInstance().isState(FKState.END)) {
			p.sendMessage(main.getInstance().getPrefix()+ ChatColor.GOLD+"Tu ne peux pas aller dans l'end");
			e.setCancelled(true);
			World w = Bukkit.getWorld("world");
			Location loc = w.getSpawnLocation();
			p.teleport(loc);
		}else {
			e.setCancelled(false);
		}
	}

}
