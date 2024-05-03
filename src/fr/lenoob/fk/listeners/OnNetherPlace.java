package fr.lenoob.fk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnNetherPlace implements Listener {
	
	@EventHandler
	public void onPlaceInNether(BlockPlaceEvent e) {
		Block b = e.getBlock();
		Location bloc = b.getLocation();
		World wbloc = bloc.getWorld();
		if(wbloc == Bukkit.getWorld("world_nether")) {
			e.setBuild(true);
		}
		if(wbloc == Bukkit.getWorld("world_the_end")) {
			e.setBuild(true);
		}
	}

}
