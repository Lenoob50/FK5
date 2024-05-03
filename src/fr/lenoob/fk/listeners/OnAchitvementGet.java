package fr.lenoob.fk.listeners;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class OnAchitvementGet implements Listener {

    @EventHandler

    public void onAchiventGet(PlayerAchievementAwardedEvent e){
        if(main.getInstance().isState(FKState.GAME)){
            e.setCancelled(true);
        }
    }
}
