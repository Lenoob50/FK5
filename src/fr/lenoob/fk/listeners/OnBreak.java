package fr.lenoob.fk.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.lenoob.fk.main;

public class OnBreak implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Location breakloc = e.getBlock().getLocation();
		if(!main.getInstance().Rouge.getEntries().contains(p.getDisplayName())) {
			int plocx = breakloc.getBlockX();
			int plocz = breakloc.getBlockZ();
			if(-148<plocx && plocx<-118 && -362<plocz && plocz<-332) {
				e.setCancelled(true);
			}
		}
		/*if(!main.getInstance().Orange.getEntries().contains(e.getPlayer().getDisplayName())) {
			int plocx = breakloc.getBlockX();
			int plocz = breakloc.getBlockZ();
			if(171<plocx && plocx<203 && 47<plocz && plocz<79) {
				e.setCancelled(true);
			}	
		}*/
		if(!main.getInstance().Vert.getEntries().contains(e.getPlayer().getDisplayName())) {
			int plocx = breakloc.getBlockX();
			int plocz = breakloc.getBlockZ();
			if(153<plocx && plocx<183 && 319<plocz && plocz<349) {
				e.setCancelled(true);
			}
		}
	}

}
