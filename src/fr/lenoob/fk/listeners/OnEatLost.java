package fr.lenoob.fk.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class OnEatLost implements Listener {
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		int foodlevel = e.getFoodLevel();
		if(main.getInstance().isState(FKState.PAUSE)) {
			e.setCancelled(true);
			e.setFoodLevel(foodlevel);
		}else {
			e.setCancelled(false);
		}
	}

}
