package fr.lenoob.fk.scoreboard;

import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.RED;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;


public class SbPrelaunch {
	
	private ScoreboardManager scoreboardManager;
    public SbPrelaunch(ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;
    }
    
    public int timer = 11;
    
    
    public void prelaunch(Player player) {
        scoreboardManager.createBoard(player, fastBoard -> {
            fastBoard.updateTitle(GOLD+"Fallen Kingdom's");
            World world = Bukkit.getWorld("world");
            main.getInstance().setState(FKState.WAIT);
            world.setGameRuleValue("doDayLightCycle", "false");
            fastBoard.updateLines(
            		//0
            		GOLD + "Temps : §3--H--",
            		//1
                    GOLD + "Jour : §30" ,
                    //2
                    GOLD + ">>―――――――――――<<",
                    //3
                    GOLD + "PVP : "+RED+"✗" ,
                    //4
                    GOLD + "Nether : "+RED+"✗",
                    //5
                    GOLD + "End : " +RED+"✗",
                    //6
                    GOLD + "Assauts : "+RED+"✗",
                    //7
                    GOLD + ">>―――――――――――<<",
                    //8
                    GOLD + "Dev : Lenoob"

            );
        });
    }

}


