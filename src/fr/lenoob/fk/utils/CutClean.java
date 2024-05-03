package fr.lenoob.fk.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import fr.lenoob.fk.main;



public class CutClean implements Listener {
	
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(main.getInstance().scenario.contains("CutClean")){
            if (event.isCancelled()) {
                return;
            }
            Block b = event.getBlock();
            World w = b.getWorld();
            Location l = b.getLocation();
            Player p = event.getPlayer();

            if (b.getType() == Material.IRON_ORE) {
                event.setCancelled(true);
                b.setType(Material.AIR);
                p.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                ExperienceOrb orb = w.spawn(l, ExperienceOrb.class);
                orb.setExperience(1);
            } else if (b.getType() == Material.GOLD_ORE) {
                event.setCancelled(true);
                b.setType(Material.AIR);
                p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                ExperienceOrb orb = w.spawn(l, ExperienceOrb.class);
                orb.setExperience(1);
            }else if (b.getType() == Material.DIAMOND_ORE) {
            	if(main.getInstance().scenario.contains("Diamond")) {
                	event.setCancelled(true);
                	b.setType(Material.AIR);
                	p.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
                	ExperienceOrb orb = w.spawn(l, ExperienceOrb.class);
                	orb.setExperience(1);
            	}
            }
        }else{
            return;
        }
    }

}
