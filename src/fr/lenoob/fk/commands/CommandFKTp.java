package fr.lenoob.fk.commands;

import fr.lenoob.fk.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

public class CommandFKTp implements CommandExecutor {

	Location baseRouge = new Location(Bukkit.getWorld("world"), -123, 95, -340);
	Location baseVerte = new Location(Bukkit.getWorld("world"), 160, 93, 330);
	Location baseOrange = new Location(Bukkit.getWorld("world"),184, 86, 60);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("fktp")) {
			if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED+"Usage : /fktp {Violet/Vert/Orange}");
			}
			if(args.length >= 1) {
				if(p.getGameMode() == GameMode.SPECTATOR || p.getGameMode() == GameMode.CREATIVE){
					if(args[0].equalsIgnoreCase("Rouge")) {
						if(args[1].equalsIgnoreCase("@a")) {
							for (Player op : Bukkit.getOnlinePlayers()) {
								op.teleport(baseRouge);
								op.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Rouge");
							}
						}else {
							p.teleport(baseRouge);
							p.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Rouge");
						}
					}
					if(args[0].equalsIgnoreCase("Orange")) {
						if(args[1].equalsIgnoreCase("@a")) {
							for (Player op : Bukkit.getOnlinePlayers()) {
								op.teleport(baseOrange);
								op.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Orange");
							}
						}else {
							p.teleport(baseOrange);
							p.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Orange");
						}
					}
					if(args[0].equalsIgnoreCase("Vert")) {
						if(args[1].equalsIgnoreCase("@a")) {
							for (Player op : Bukkit.getOnlinePlayers()) {
								op.teleport(baseVerte);
								op.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Verte");
							}
						}else {
							p.teleport(baseVerte);
							p.sendMessage(GREEN+"Vous avez été téléporté à la base "+AQUA+"Verte");
						}
					}
				}
				}else{
				p.sendMessage(main.getInstance().getPrefix()+"Tu dois etre en gamedmode spectateur ou créatif pour effectuer cette commande");
			}
			}
		}
		return false;
	}

}
