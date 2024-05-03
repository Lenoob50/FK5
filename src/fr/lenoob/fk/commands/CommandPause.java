package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class CommandPause implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		FKState state = main.getInstance().getState();
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("La commande est /pause <on/off>");
			}
			if(args.length >= 1) {
				if(args[0].equalsIgnoreCase("on")) {
					if(main.getInstance().isState(FKState.PAUSE)) {
						p.sendMessage(main.getInstance().getPrefix()+RED+"La Partie est deja en pause");
					}else {
						Bukkit.broadcastMessage(main.getInstance().getPrefix()+p.getDisplayName()+" à mis la partie en Pause");
						Bukkit.getScheduler().cancelAllTasks();
						main.getInstance().setState(FKState.PAUSE);
					}

				}
				if(args[0].equalsIgnoreCase("off")) {
					main.getInstance().setState(state);
					Bukkit.broadcastMessage(main.getInstance().getPrefix()+p.getDisplayName()+" à interrompu la Pause");
					for(Player ps : Bukkit.getOnlinePlayers()) {
						
					}

				}
			}
		}
		return false;
	}

}
