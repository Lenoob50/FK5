package fr.lenoob.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.lenoob.fk.main;
import fr.lenoob.fk.scoreboard.Sb;
import fr.lenoob.fk.utils.FKState;

public class CommandStart implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			ItemStack steak = new ItemStack(Material.COOKED_BEEF, 10);
			ItemStack apple = new ItemStack(Material.APPLE,10);
			for(Player p : Bukkit.getOnlinePlayers()) {
				new Sb(main.getInstance().sm).game(p);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().clear();
				if(main.getInstance().Rouge.getEntries().contains(p.getDisplayName())) {
					p.teleport(new Location(Bukkit.getWorld("world"), -123, 95, -340));
				}
				if(main.getInstance().Vert.getEntries().contains(p.getDisplayName())) {
					p.teleport(new Location(Bukkit.getWorld("world"), 160, 93, 330));
				}
				if(main.getInstance().Orange.getEntries().contains(p.getDisplayName())) {
					p.teleport(new Location(Bukkit.getWorld("world"), 184, 86, 60));
				}
				if(main.getInstance().scenario.contains("Starter")) {
					p.getInventory().addItem(steak);
					p.getInventory().addItem(apple);
				}
			}
			
			Bukkit.broadcastMessage(main.getInstance().getPrefix()+" La partie commence");
			Bukkit.broadcastMessage(main.getInstance().getPrefix()+" Début du jour §3 1");
			main.getInstance().setState(FKState.GAME);
			World w = Bukkit.getWorld("world");
			w.setTime(0);
			w.setDifficulty(Difficulty.NORMAL);
			w.setGameRuleValue("doDaylightCycle", "true");
		}
		return false;
	}

}
