package fr.lenoob.fk.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class OnTorchPlace implements Listener {
	
	@EventHandler
	public void onTorchPlaced(BlockPlaceEvent e) {
		Block placeBlock = e.getBlockPlaced();
		if(placeBlock.getType() == Material.TORCH ) {
			e.setBuild(true);
		}
		else if(placeBlock.getType() == Material.REDSTONE_TORCH_ON ) {
			e.setBuild(true);
		}
		else if(placeBlock.getType() == Material.FIRE ) {
			e.setBuild(true);
		}
		else if(placeBlock.getType() == Material.PORTAL ) {
			e.setBuild(true);
		}else if(placeBlock.getType() == Material.EYE_OF_ENDER) {
			e.setBuild(true);
		}
	}

}
