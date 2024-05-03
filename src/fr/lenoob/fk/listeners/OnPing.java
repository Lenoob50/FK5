package fr.lenoob.fk.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class OnPing implements Listener {
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMaxPlayers(6);
		e.setMotd(ChatColor.AQUA+"Bienvenue sur "+ChatColor.DARK_GREEN+"Fallen Kingdomm's");
	}

}
