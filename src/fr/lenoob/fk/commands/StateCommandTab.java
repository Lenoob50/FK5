package fr.lenoob.fk.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class StateCommandTab implements TabCompleter{
	
	List<String> arguments = new ArrayList<String>();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(arguments.isEmpty()) {
			arguments.add("wait");
			arguments.add("game");
			arguments.add("nether");
			arguments.add("end");
			arguments.add("assauts");
			arguments.add("get");
			arguments.add("pvp");
		}
		
		List<String> result = new ArrayList<String>();
		if(args.length == 1) {
			for(String a : arguments) {
				if(a.toLowerCase().startsWith(args[0].toLowerCase())) {
					result.add(a);
					
				}
			}
			return result;
		}
		return null;
	}

}
