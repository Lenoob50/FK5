package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;

public class CommandBroadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("La commande est /bc <args>");
			}
			if(args.length >= 1) {
				
				StringBuilder bc = new StringBuilder();
				for(String part : args) {
					bc.append(part + " ");
				}
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(main.getInstance().getPrefix() +bc.toString());
				Bukkit.broadcastMessage(" ");
			}
		}
		return false;
	}

}
