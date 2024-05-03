package fr.lenoob.fk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.lenoob.fk.main;

public class OnCreeperSpawn implements Listener {
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		if(main.getInstance().scenario.contains("Charged-Creeper")){
			Entity ent = e.getEntity();
			if(ent.getType() == EntityType.CREEPER) {
				if(Math.random()*100<=20) {
					Creeper creeper = (Creeper) Bukkit.getWorld("world").spawnEntity(ent.getLocation(), EntityType.CREEPER);
					creeper.setPowered(true);
					ent.remove();
				}
			}else if(ent.getType() == EntityType.WITCH) {
				Witch witch = (Witch) Bukkit.getWorld("world").spawnEntity(ent.getLocation(), EntityType.ZOMBIE);
				ent.remove();
				
			}
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		Entity ent = e.getEntity();
		if(ent instanceof Creeper) {
			Creeper creeper = (Creeper) ent;
			if(creeper.isPowered()) {
				e.getDrops().clear();
				creeper.getWorld().dropItem(creeper.getLocation(), new ItemStack(Material.TNT,2));
			}else {
				return;
			}
		}
		if(ent instanceof Player) {
			EntityDamageEvent ede = ent.getLastDamageCause();
			DamageCause dc = ede.getCause();
			if(dc != DamageCause.ENTITY_ATTACK) {
				Player p = (Player) ent;
				Bukkit.broadcastMessage(main.getInstance().getPrefix()+p.getDisplayName()+" est mort");
			}else if( dc == DamageCause.ENTITY_ATTACK) {
				LivingEntity killer = e.getEntity();
				if(main.getInstance().Vert.getEntries().contains(killer.getName())&& main.getInstance().Rouge.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ ChatColor.RED +killer.getKiller().getDisplayName());
				}else if(main.getInstance().Vert.getEntries().contains(killer.getName())&& main.getInstance().Orange.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.GOLD+killer.getKiller().getDisplayName());
				}else if(main.getInstance().Rouge.getEntries().contains(killer.getName())&& main.getInstance().Vert.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.GREEN+killer.getKiller().getDisplayName());
				}else if(main.getInstance().Rouge.getEntries().contains(killer.getName())&& main.getInstance().Orange.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.GOLD+killer.getKiller().getDisplayName());
				}else if(main.getInstance().Orange.getEntries().contains(killer.getName())&& main.getInstance().Rouge.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.RED+killer.getKiller().getDisplayName());
				}else if(main.getInstance().Orange.getEntries().contains(killer.getName())&& main.getInstance().Rouge.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.RED+killer.getKiller().getDisplayName());
				}else if(main.getInstance().Orange.getEntries().contains(killer.getName())&& main.getInstance().Vert.getEntries().contains(killer.getKiller().getDisplayName())) {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.GOLD+killer.getKiller().getDisplayName());
				}else {
					Bukkit.broadcastMessage(main.getInstance().getPrefix() +killer.getName()+"à été tué par "+ChatColor.GOLD+killer.getKiller().getDisplayName());
				}
			}else {
				return;
			}
		}
	}

}
