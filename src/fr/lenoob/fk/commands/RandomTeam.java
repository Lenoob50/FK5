package fr.lenoob.fk.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;

public class RandomTeam implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			for(Player ps : Bukkit.getOnlinePlayers()) {
					Random r = new Random();
					int alea = r.nextInt(2);
					switch(alea) {
					case 0:
						main.getInstance().Orange.addEntry(ps.getDisplayName());
						break;
					case 1:
						main.getInstance().Vert.addEntry(ps.getDisplayName());
						break;
					case 2:
						main.getInstance().Rouge.addEntry(ps.getDisplayName());
						break;
					default:
						break;
					}
			}
			Bukkit.broadcastMessage(ChatColor.GOLD+"Les Oranges : "+main.getInstance().Orange.getEntries());
			Bukkit.broadcastMessage(ChatColor.GREEN+"Les Verts : "+main.getInstance().Vert.getEntries());
			Bukkit.broadcastMessage(ChatColor.DARK_PURPLE+"Les Violets : "+main.getInstance().Rouge.getEntries());
		}
		return false;
	}

}
