package fr.lenoob.fk.listeners;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.lenoob.fk.main;
import fr.lenoob.fk.scoreboard.SbInPause;
import fr.lenoob.fk.scoreboard.SbPrelaunch;
import fr.lenoob.fk.scoreboard.SbRejoin;
import fr.lenoob.fk.utils.FKState;
import fr.lenoob.fk.utils.Tablist;

public class OnJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws IOException {
		Player p = e.getPlayer();
		e.setJoinMessage(" ");
		int j = Bukkit.getOnlinePlayers().size();
		int m = Bukkit.getMaxPlayers();
		Bukkit.broadcastMessage(main.getInstance().getPrefix()+ ChatColor.GOLD+p.getDisplayName()+ChatColor.GREEN+" à rejoins le jeu ( "+j+"/"+m+")");
		p.setScoreboard(main.getInstance().sb);
		Tablist.sendTablist(p, ChatColor.AQUA+"Fallen Kingdomm's",
				ChatColor.DARK_GREEN+"Orga : "+ChatColor.GREEN+"Les gens biens",
				ChatColor.GOLD+"Hebergement : "+ChatColor.YELLOW+"Censurent");
		if(main.getInstance().isState(FKState.WAIT)) {
			new SbPrelaunch(main.getInstance().sm).prelaunch(p);
		}if(!main.getInstance().isState(FKState.WAIT)) {
			new SbRejoin(main.getInstance().sm).Rejoin(p);
		}
		if(main.getInstance().isState(FKState.PAUSE)) {
			new SbInPause(main.getInstance().sm).prelaunch(p);
		}
	}

}
