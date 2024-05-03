package fr.lenoob.fk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.ActionBar;
import fr.lenoob.fk.utils.ArrowTargetUtils;

public class OnMoove implements Listener {
	
	@EventHandler
	public void onMoove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		int plocx = p.getLocation().getBlockX();
		int plocz = p.getLocation().getBlockZ();
		
		
		if(p.getWorld().getName().equals("world")){
			if(main.getInstance().Rouge.getEntries().contains(p.getDisplayName())) {

				if(-148<plocx && plocx<-118 && -362<plocz && plocz<-332) {
					ActionBar.sendActionBar(p, ChatColor.DARK_GREEN+"Vous êtes dans votre base");
				}else {
					ActionBar.sendActionBar(p, ChatColor.GOLD+"Votre base est à "+ChatColor.AQUA+""+(int)p.getLocation().distance(main.getInstance().getRedCenter(p))+ChatColor.GOLD+" blocks "+ChatColor.AQUA+""+ArrowTargetUtils.calculateArrow(p, main.getInstance().getRedCenter(p)));
				}
			}
			if(main.getInstance().Vert.getEntries().contains(p.getDisplayName())) {
				if(153<plocx && plocx<183 && 319<plocz && plocz<349) {
					ActionBar.sendActionBar(p, ChatColor.DARK_GREEN+"Vous êtes dans votre base");
				}else {
					ActionBar.sendActionBar(p, ChatColor.GOLD+"Votre base est à "+ChatColor.AQUA+""+(int)p.getLocation().distance(main.getInstance().getGreenCenter(p))+ChatColor.GOLD+" blocks "+ChatColor.AQUA+ArrowTargetUtils.calculateArrow(p, main.getInstance().getGreenCenter(p)));
				}
			}
			if(main.getInstance().Orange.getEntries().contains(p.getDisplayName())) {
				if(171<plocx && plocx<203 && 47<plocz && plocz<79) {
					ActionBar.sendActionBar(p, ChatColor.DARK_GREEN+"Vous êtes dans votre base");
				}else {
					ActionBar.sendActionBar(p, ChatColor.GOLD+"Votre base est à "+ChatColor.AQUA+""+(int)p.getLocation().distance(main.getInstance().getOrangeCenter(p))+ChatColor.GOLD+" blocks "+ChatColor.AQUA+""+ArrowTargetUtils.calculateArrow(p, main.getInstance().getOrangeCenter(p)));
				}
			}
		}else {
			ActionBar.sendActionBar(p, "§6Le portail est à §3 "+(int)p.getLocation().distance(new Location(Bukkit.getWorld("world_nether"), -11, 31, -5))+" §6blocks §3"+ArrowTargetUtils.calculateArrow(p, new Location(Bukkit.getWorld("world_nether"), -11, 31, -5)));
		}
	}

}
