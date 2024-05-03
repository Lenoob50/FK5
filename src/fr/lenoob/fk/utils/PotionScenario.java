package fr.lenoob.fk.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.lenoob.fk.main;

public class PotionScenario implements Listener {
	
	@EventHandler
	public void killEntity(EntityDeathEvent e) {
		if(main.getInstance().scenario.contains("Potion")) {
			Entity ent = e.getEntity();
			if(ent.getType() == EntityType.CREEPER){
				e.getDrops().clear();
				Random r = new Random();
				int alea = r.nextInt(10);
				switch(alea) {
				case 0:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8195));
					break;
				case 1:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8198));
					break;
				case 2:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8197));
					break;
				case 3:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8206));
					break;
				case 4: 
					e.getDrops().add(new ItemStack(Material.TNT, 1));
					break;
				case 5: case 6: case 7: case 8: case 9: case 10:
					e.getDrops().add(new ItemStack(Material.SULPHUR));
					break;
				}
				
			}		
			if(ent.getType() == EntityType.SKELETON){
				e.getDrops().clear();
				Random r = new Random();
				int alea = r.nextInt(10);
				switch(alea) {
				case 0:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8195));
					break;
				case 1:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8198));
					break;
				case 2:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8197));
					break;
				case 3:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8206));
					break;
				case 4:case 5: case 6: case 7: case 8: case 9: case 10:
					e.getDrops().add(new ItemStack(Material.ARROW, 3));
					break;
				}
				
			}
			if(ent.getType() == EntityType.ZOMBIE){
				e.getDrops().clear();
				Random r = new Random();
				int alea = r.nextInt(10);
				switch(alea) {
				case 0:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8195));
					break;
				case 1:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8198));
					break;
				case 2:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8197));
					break;
				case 3:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8206));
					break;
				case 4:case 5: case 6: case 7: case 8: case 9: case 10:
					e.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 3));
					break;
				}
				
			}
			if(ent.getType() == EntityType.ENDERMAN){
				e.getDrops().clear();
				Random r = new Random();
				int alea = r.nextInt(10);
				switch(alea) {
				case 0:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8195));
					break;
				case 1:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8198));
					break;
				case 2:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8197));
					break;
				case 3:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8206));
					break;
				case 4:case 5: case 6: case 7: case 8: case 9: case 10:
					e.getDrops().add(new ItemStack(Material.ENDER_PEARL, 1));
					break;
				}
				
			}
			if(ent.getType() == EntityType.SPIDER){
				e.getDrops().clear();
				Random r = new Random();
				int alea = r.nextInt(10);
				switch(alea) {
				case 0:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8195));
					break;
				case 1:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8198));
					break;
				case 2:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8197));
					break;
				case 3:
					e.getDrops().add(new ItemStack(Material.POTION, 1, (short) 8206));
					break;
				case 4:
					e.getDrops().add(new ItemStack(Material.SPIDER_EYE, 1));
					break;
				case 5: case 6: case 7: case 8: case 9: case 10:
					e.getDrops().add(new ItemStack(Material.STRING, 1));
					break;
				}
				
			}
		}else {
			return;
		}
	}

}
