package fr.lenoob.fk.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.lenoob.fk.main;
import fr.lenoob.fk.inventory.InventoryManager;

public class Scenario implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
        	Player p = (Player) commandSender;
            if(p.isOp()) {
                if(strings.length == 0) {
                	p.sendMessage(main.getInstance().getPrefix()+ChatColor.DARK_RED+" La commande est /scenario <choose/active>");
                }else {
                	if(strings[0].equalsIgnoreCase("active")) {
                		p.sendMessage(main.getInstance().getPrefix()+"Les scenarios actifs sont "+main.getInstance().scenario);
                	}else if(strings[0].equalsIgnoreCase("choose")) {
                		Inventory inv = new InventoryManager().Scenario;
                        p.updateInventory();
                        p.openInventory(inv);
                	}
                }
            }else {
            	p.sendMessage(main.getInstance().getPrefix()+ChatColor.DARK_RED+" Tu dois etre opérateur pour exécuter cette commande");
            }
        }
        return false;
    }
}
