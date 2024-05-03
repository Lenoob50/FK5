package fr.lenoob.fk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.lenoob.fk.main;

public class OnTalk implements Listener {
	
	@EventHandler
    public void onTalk(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String newmsg = e.getMessage().substring(1);
		e.setCancelled(true);
		if(main.getInstance().Rouge.getEntries().contains(p.getDisplayName())) {
			if(!e.getMessage().startsWith("!")) {
				for(String pr : main.getInstance().Rouge.getEntries()) {
					Player tr = Bukkit.getPlayer(pr);
					tr.sendMessage(ChatColor.GRAY+"[Team] "+ChatColor.RED+""+p.getName()+ChatColor.GOLD+" >> "+ChatColor.RESET+""+e.getMessage());
				}
			}else {
					for(Player op : Bukkit.getOnlinePlayers()) {
						op.sendMessage(ChatColor.GRAY+"[Global] "+ChatColor.RED+""+p.getName()+ChatColor.GOLD+" >> "+ChatColor.RESET+""+newmsg);
				}
			}
		}else if(main.getInstance().Vert.getEntries().contains(p.getDisplayName())) {
			if(!e.getMessage().startsWith("!")) {
				for(String pr : main.getInstance().Vert.getEntries()) {
					Player tr = Bukkit.getPlayer(pr);
					tr.sendMessage(ChatColor.GRAY+"[Team] "+ChatColor.GREEN+""+p.getName()+ChatColor.GOLD+" >> "+ChatColor.RESET+""+e.getMessage());
				}
			}else {
					for(Player op : Bukkit.getOnlinePlayers()) {
						op.sendMessage(ChatColor.GRAY+"[Global] "+ChatColor.GREEN+""+p.getName()+ChatColor.GOLD+" >> "+ChatColor.RESET+""+newmsg);
				}
			}
		}else {
			for(Player op : Bukkit.getOnlinePlayers()) {
				op.sendMessage(ChatColor.GRAY+"[Global] "+ChatColor.GREEN+""+p.getName()+ChatColor.GOLD+" >> "+ChatColor.RESET+""+e.getMessage());
			}
		}
		
    }

}

