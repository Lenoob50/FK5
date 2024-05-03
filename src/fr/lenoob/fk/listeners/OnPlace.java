package fr.lenoob.fk.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class OnPlace implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Block placeBlock = e.getBlockPlaced();
		Player p = e.getPlayer();
		Location placeLoc = placeBlock.getLocation();
		if(p.getGameMode().equals(GameMode.CREATIVE)) {
			e.setBuild(true);
		}
		if(placeBlock.getType() == Material.TORCH) {
			e.setBuild(true);
		}
		if(placeBlock.getType() == Material.REDSTONE_TORCH_ON) {
			e.setBuild(true);
		}
		if(placeBlock.getType() == Material.WORKBENCH) {
			e.setBuild(true);
		}
		if(e.getPlayer().getWorld().getName().equals("world") && !e.getPlayer().isOp()) {
			e.setBuild(true);
		}
		if(main.getInstance().Rouge.getEntries().contains(e.getPlayer().getDisplayName())) {
			int plocx = placeLoc.getBlockX();
			int plocz = placeLoc.getBlockZ();
			if(-148<plocx && plocx<-118 && -362<plocz && plocz<-332) {
				e.setBuild(true);
				if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
					e.setBuild(false);
					p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
				}
		}else if(main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
			e.setBuild(true);
		}else if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
			e.setBuild(false);
			p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
		}else {
			e.setBuild(false);
		}
		}
		if(main.getInstance().Orange.getEntries().contains(e.getPlayer().getDisplayName())) {
			int plocx = placeLoc.getBlockX();
			int plocz = placeLoc.getBlockZ();
			if(171<plocx && plocx<203 && 47<plocz && plocz<79) {
				e.setBuild(true);
				if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
					e.setBuild(false);
					p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
				}
			}
				else if(main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
					e.setBuild(true);
				}else if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
					e.setBuild(false);
					p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
				}else {
					e.setBuild(false);
				}
		}
		if(main.getInstance().Vert.getEntries().contains(e.getPlayer().getDisplayName())) {
			int plocx = placeLoc.getBlockX();
			int plocz = placeLoc.getBlockZ();
			if(153<plocx && plocx<183 && 319<plocz && plocz<349){
				e.setBuild(true);
				if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
					e.setBuild(false);
					p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
				}
		}else if(main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
			e.setBuild(true);
		}else if(!main.getInstance().isState(FKState.ASSAULTS) && placeBlock.getType() == Material.TNT) {
			e.setBuild(false);
			p.sendMessage("§6[§3FK§6] Vous ne pouvez pas poser de TNT les assauts ne sont pas activés");
		}else {
			e.setBuild(false);
		}

	}

	}
}
