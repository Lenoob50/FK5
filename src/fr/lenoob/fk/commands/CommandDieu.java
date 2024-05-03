package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

import fr.lenoob.fk.main;

public class CommandDieu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("La commande est /dieu <player>");
			}
			if(args.length >= 1) {
				
				StringBuilder bc = new StringBuilder();
				for(String part : args) {
					bc.append(part + "");
				}
				main.getInstance().Dieu.addEntry(bc.toString());
				Bukkit.broadcastMessage(main.getInstance().getPrefix()+bc.toString()+ GOLD+" à  rejoins l'équipe Dieu");
				}
		}else {
			sender.sendMessage("Vous n'etes pas un joueur veuillez vous conecter pour utliser cette commande");
		}
		return false;
	}

}
