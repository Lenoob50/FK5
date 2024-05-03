package fr.lenoob.fk.scoreboard;

import static org.bukkit.ChatColor.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class SbRejoin {

    private ScoreboardManager scoreboardManager;
    public SbRejoin(ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;
    
	}	

    public int timer = 0;
    public int Episode = 1;
    public void Rejoin(Player player) throws IOException {
        scoreboardManager.createBoard(player, fastBoard -> {
            fastBoard.updateTitle(GOLD+"Fallen Kingdom's");

            Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
                @Override
                public void run() {
                	String ligne;
                	FileReader fr;
                	BufferedReader lecteurAvecBuffer = null;
                	try {
						fr= new FileReader("plugins/FallenKingdomm's/time.txt");
						lecteurAvecBuffer = new BufferedReader(fr);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
                	try {
						while((ligne = lecteurAvecBuffer.readLine()) != null) {
							fastBoard.updateLine(0,ligne);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                	String lineep ;
                	FileReader frep ;
                	BufferedReader lecteurAvecBufferEp = null;
                	try {
						frep = new FileReader("plugins/FallenKingdomm's/ep.txt");
						lecteurAvecBufferEp = new BufferedReader(frep);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
                	try {
						while((lineep = lecteurAvecBufferEp.readLine()) != null) {
							fastBoard.updateLine(1, "§6Jour :§3"+lineep.toString());
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                	if(main.getInstance().isState(FKState.PVP)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+RED+"✗");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.NETHER)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.END)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                		fastBoard.updateLine(5,  GOLD + "End : "+GREEN+"✔");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.ASSAULTS)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                		fastBoard.updateLine(5,  GOLD + "End : "+GREEN+"✔");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+GREEN+"✔");
                	}
                	if(main.getInstance().isState(FKState.GAME)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+RED+"✗");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+RED+"✗");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	
                    if(timer == 1170) {
                    	player.sendMessage("§3[§6Fallen Kingdomm's§3]§6 Début du jour : &3" + Episode+1 + BLUE+" &6dans 30 secondes");
                    }
                    if(timer == 1190) {
                    	player.sendMessage("§3[§6Fallen Kingdomm's§3]§6 Début du jour : &3" + Episode+1 + BLUE+" &6dans 10 secondes");
                    }
                    if(main.getInstance().Orange.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, "§6Votre Team :§6 Orange");
                    }else if(main.getInstance().Rouge.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, "§6Votre Team :§4 Rouge");
                    }else if(main.getInstance().Vert.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, "§6Votre Team :§2 Vert");
                    }else if(main.getInstance().Dieu.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, "§6Votre Team :§7 Dieu");
                    }else {
                    	fastBoard.updateLine(8, "§6Votre Team :§4 No Team");
                    }
                    fastBoard.updateLine(9, GOLD+" ");
                    fastBoard.updateLine(10, GOLD+"Kill(s) : "+AQUA+""+player.getStatistic(Statistic.PLAYER_KILLS));
                }
            }, 20, 20);
            	

            fastBoard.updateLines(
            		//0
            		GOLD + "",
            		//1
                    GOLD + "" ,
                    //2
                    GOLD + ">>―――――――――――――<<",
                    //3
                    GOLD + "" ,
                    //4
                    GOLD + "",
                    //5
                    GOLD + "",
                    //6
                    GOLD + "",
                    //7
                    GOLD+ ">>―――――――――――――<<"
                    //9


            );
        });
    }

}



