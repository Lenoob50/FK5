package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;


public class CommandTeam implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(msg.equalsIgnoreCase("team")) {
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args[0].length() == 0 || args[1].length() == 0) {
					p.sendMessage("La commande est /team <team> <player>");
				}
				if(args.length >=1) {
					if(args[0].equalsIgnoreCase("Orange")) {
						main.getInstance().Orange.addEntry(args[1].toString());
						Bukkit.broadcastMessage(ChatColor.GOLD+""+args[1].toString()+ChatColor.GREEN+" à rejoins l'équipe des "+ChatColor.GOLD+"Jaune");
					}					
					if(args[0].equalsIgnoreCase("Rouge")) {
						main.getInstance().Rouge.addEntry(args[1].toString());
						Bukkit.broadcastMessage(ChatColor.RED+""+args[1].toString()+ChatColor.GREEN+"à rejoins l'équipe des "+ChatColor.RED+"Rouge");
					}
					if(args[0].equalsIgnoreCase("Vert")) {
						main.getInstance().Vert.addEntry(args[1].toString());
						Bukkit.broadcastMessage(ChatColor.GREEN+""+args[1].toString()+ChatColor.GREEN+"à rejoins l'équipe des "+ChatColor.DARK_GREEN+"Vert");
					}
					
				}
			}
		}
		return false;
	}

}
