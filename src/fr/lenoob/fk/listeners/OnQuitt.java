package fr.lenoob.fk.listeners;

import fr.lenoob.fk.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuitt implements Listener {
	
	@EventHandler
	public void onQuitt(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		int max = Bukkit.getMaxPlayers();
		int online = Bukkit.getOnlinePlayers().size()-1;
		e.setQuitMessage("");
		Bukkit.broadcastMessage(main.getInstance().getPrefix()+ ChatColor.RESET+""+p.getDisplayName()+ChatColor.GOLD+" à quitter le jeu ("+online+"/"+max+")");
	}

}
