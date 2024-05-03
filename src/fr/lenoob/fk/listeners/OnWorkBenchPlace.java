package fr.lenoob.fk.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnWorkBenchPlace implements Listener {

    @EventHandler
    public void onWorkbenchPlace(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.WORKBENCH){
            e.setBuild(true);
        }
    }
}
