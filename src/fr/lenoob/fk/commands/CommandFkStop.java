package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.lenoob.fk.main;
import fr.lenoob.fk.scoreboard.SbPrelaunch;

public class CommandFkStop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			World w = Bukkit.getWorld("world");
			Location spawn = w.getSpawnLocation();
			Bukkit.getScheduler().cancelAllTasks();
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.teleport(spawn);
				new SbPrelaunch(main.getInstance().sm).prelaunch(p);
			}
			Bukkit.broadcastMessage(main.getInstance().getPrefix()+" Arrêt de la partie");
			main.getInstance().resetScenario();
		}
		return false;
	}

}
