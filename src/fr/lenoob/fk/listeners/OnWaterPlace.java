package fr.lenoob.fk.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnWaterPlace implements Listener {
	
	@EventHandler
	public void onWaterPlace(BlockPlaceEvent e) {
		Block placeBlock = e.getBlockPlaced();
		if(placeBlock.getType() == Material.WATER) {
			e.setBuild(true);
		}
		if(placeBlock.getType() == Material.WATER_BUCKET ) {
			e.setBuild(true);
		if(placeBlock.getType() == Material.LAVA) {
			e.setBuild(false);
		}
		if(placeBlock.getType() == Material.LAVA_BUCKET ) {
			e.setBuild(false);
		}
	}

	}
}
