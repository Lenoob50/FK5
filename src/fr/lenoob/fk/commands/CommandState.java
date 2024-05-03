package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;
import fr.lenoob.fk.scoreboard.SbPrelaunch;
import fr.lenoob.fk.utils.FKState;

public class CommandState implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("state")) {
			if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED+"Usage : /state {wait/game/pvp/nether/end/assauts/get}");
			}
			if(args.length >= 1) {
				if(args[0].equalsIgnoreCase("wait")) {
					main.getInstance().setState(FKState.WAIT);
					for(Player ps : Bukkit.getOnlinePlayers()) {
						new SbPrelaunch(main.getInstance().sm).prelaunch(ps);	
					}
				}
				if(args[0].equalsIgnoreCase("game")) {
					main.getInstance().setState(FKState.GAME);
					p.sendMessage(main.getInstance().getPrefix()+" Vous etes maintenant en "+main.getInstance().getState());
				}
				if(args[0].equalsIgnoreCase("pvp")) {
					main.getInstance().setState(FKState.PVP);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Le PVP est maintenant actif");
					World w = Bukkit.getWorld("world");
					w.setPVP(true);
				}
				if(args[0].equalsIgnoreCase("nether")) {
					main.getInstance().setState(FKState.NETHER);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+" Le Nether est maintenant actif");
				}
				if(args[0].equalsIgnoreCase("end")) {
					main.getInstance().setState(FKState.END);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+" L'end est desormais actif");
				}
				if(args[0].equalsIgnoreCase("assauts")) {
					main.getInstance().setState(FKState.ASSAULTS);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Les assauts sont desormais actif");
				}
				if(args[0].equalsIgnoreCase("get")) {
					p.sendMessage(main.getInstance().getPrefix()+" Vous etes maintenant en "+main.getInstance().getState());
				}
				if(args[0].equalsIgnoreCase("pvp")) {
					main.getInstance().setState(FKState.PVP);
					World w = Bukkit.getWorld("world");
					w.setPVP(true);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Le PVP est maintenant actif");
				}
			}
		}
		}
		return false;
	}


}
