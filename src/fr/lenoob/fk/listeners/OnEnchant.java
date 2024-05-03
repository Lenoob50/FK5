package fr.lenoob.fk.listeners;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class OnEnchant implements Listener {
	
	@EventHandler
	public void onEnchant(EnchantItemEvent e) {
		Player p = e.getEnchanter();
		if(e.getEnchantBlock() == Enchantment.PROTECTION_ENVIRONMENTAL) {
			if(e.getExpLevelCost() == 3) {
				e.setCancelled(true);
				p.sendMessage("Tu ne peux pas enchant de ceux niveaux la");
			}else {
				e.setCancelled(false);
			}
		}
	}

}
