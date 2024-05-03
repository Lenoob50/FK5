package fr.lenoob.fk.scoreboard;

import static org.bukkit.ChatColor.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import fr.lenoob.fk.main;
import fr.lenoob.fk.utils.FKState;

public class Sb {

    private ScoreboardManager scoreboardManager;
    public Sb(ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;
    
	}	

	public static Sb instance;
	public static Sb getInstance(){
	        return instance;
	}
    public int timer = 0;
    public int Episode = 1;
    public World w = Bukkit.getWorld("world");

    public void game(Player player) {
        scoreboardManager.createBoard(player, fastBoard -> {
            fastBoard.updateTitle(GOLD+"Fallen Kingdom's");

            Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
                @Override
                public void run() {
                	timer++;
                    FileWriter fw2 = null;
					try {
						fw2 = new FileWriter("plugins/FallenKingdomm's/timer.txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    try {
                    	String bt = String.valueOf(timer);
						fw2.write(bt);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    try {
						fw2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}             	
                    
                    String dateformat = new SimpleDateFormat("'§6Temps :§3 'mm:ss").format(timer * 1000);
                    FileWriter fw = null;
					try {
						fw = new FileWriter("plugins/FallenKingdomm's/time.txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    try {
						fw.write(dateformat);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        fastBoard.updateLine(0,dateformat);
                        
                    }
                    if(timer == 1200){
                        Episode ++;
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Début du jour : " + Episode);
                        fastBoard.updateLine(1, GOLD + "Jour : "+AQUA+ Episode );
                        timer = 0;
                        Bukkit.getWorld("world").setTime(0);
                    }
                    FileWriter f2 = null;
					try {
						f2 = new FileWriter("plugins/FallenKingdomm's/ep.txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    try {
                    	String epstring = String.valueOf(Episode);
						f2.write(epstring);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    try {
						f2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    if(Episode == 2 && timer == 0) {
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+"PVP Actif");
                    	fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                    	w.setPVP(true);
                    	main.getInstance().setState(FKState.PVP);
                    	
                    }
                    
                    
                    if(Episode == 4 && timer == 0) {
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Nether Actif");
						World world = Bukkit.getWorld("world");
						world.getBlockAt(new Location(world,-25,65,34)).setType(Material.FIRE);
                    	fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                    	main.getInstance().setState(FKState.NETHER);
                    	
                    }
					
					
					if(main.getInstance().scenario.contains("chest")) {
						
						if(Episode == 2 && timer == 0) {
	                    	ItemStack J3D = new ItemStack(Material.TNT, 2);
	                    	ItemStack J3F = new ItemStack(Material.IRON_INGOT, 4);
	                    	ItemStack J3G = new ItemStack(Material.GOLD_INGOT, 6);
	                    	ItemStack J3S = new ItemStack(Material.COOKED_BEEF, 64);
	                    	Location chestJ3loc = new Location(Bukkit.getWorld("world"), -160, 64, -87);
	                    	chestJ3loc.getBlock().setType(Material.CHEST);
	                    	Chest chestJ3 = (Chest) chestJ3loc.getBlock().getState();
	                    	chestJ3.getInventory().setItem(11,J3D);
	                    	chestJ3.getInventory().setItem(13,J3F);
	                    	chestJ3.getInventory().setItem(15,J3G);
	                    	chestJ3.getInventory().setItem(17,J3S);
	                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+GOLD+" un coffre a spawn en"+chestJ3loc.getX()+", "+chestJ3loc.getY()+", "+chestJ3loc.getZ());
	                    }
						
						if(Episode == 4 && timer == 0) {
							ItemStack J3D = new ItemStack(Material.TNT, 2);
							ItemStack J3F = new ItemStack(Material.IRON_INGOT, 4);
							ItemStack J3G = new ItemStack(Material.GOLD_INGOT, 6);
							ItemStack J3S = new ItemStack(Material.COOKED_BEEF, 64);
							Location chestJ3loc = new Location(Bukkit.getWorld("world"), 140, 65, -75);
							chestJ3loc.getBlock().setType(Material.CHEST);
							Chest chestJ3 = (Chest) chestJ3loc.getBlock().getState();
							chestJ3.getInventory().setItem(11,J3D);
							chestJ3.getInventory().setItem(13,J3F);
							chestJ3.getInventory().setItem(15,J3G);
							chestJ3.getInventory().setItem(17,J3S);
							Bukkit.broadcastMessage(main.getInstance().getPrefix()+GOLD+" un coffre a spawn en"+chestJ3loc.getX()+", "+chestJ3loc.getY()+", "+chestJ3loc.getZ());
						}
						if(Episode == 6 && timer == 0) {
							ItemStack J3D = new ItemStack(Material.TNT, 2);
							ItemStack J3F = new ItemStack(Material.IRON_INGOT, 4);
							ItemStack J3G = new ItemStack(Material.GOLD_INGOT, 6);
							ItemStack J3S = new ItemStack(Material.COOKED_BEEF, 64);
							Location chestJ3loc = new Location(Bukkit.getWorld("world"), 54, 65, -140);
							chestJ3loc.getBlock().setType(Material.CHEST);
							Chest chestJ3 = (Chest) chestJ3loc.getBlock().getState();
							chestJ3.getInventory().setItem(11,J3D);
							chestJ3.getInventory().setItem(13,J3F);
							chestJ3.getInventory().setItem(15,J3G);
							chestJ3.getInventory().setItem(17,J3S);
							Bukkit.broadcastMessage(main.getInstance().getPrefix()+GOLD+" un coffre a spawn en"+chestJ3loc.getX()+", "+chestJ3loc.getY()+", "+chestJ3loc.getZ());
						}
					}
					
                    if(Episode == 6 && timer == 0) {
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+" Assauts Actif");
                    	fastBoard.updateLine(6,  GOLD + "Assauts : "+GREEN+"✔");
                    	main.getInstance().setState(FKState.ASSAULTS);
                    	
                    }
                	if(main.getInstance().isState(FKState.PVP)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+RED+"✗");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.NETHER)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔”");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.END)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.ASSAULTS)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+GREEN+"✔");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+GREEN+"✔");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+GREEN+"✔");
                	}
                	if(main.getInstance().isState(FKState.GAME)) {
                		fastBoard.updateLine(3,  GOLD + "PVP : "+RED+"✗");
                		fastBoard.updateLine(4,  GOLD + "Nether : "+RED+"✗");
                		fastBoard.updateLine(5,  GOLD + "End : "+RED+"✗");
                		fastBoard.updateLine(6,  GOLD + "Assauts : "+RED+"✗");
                	}
                	if(main.getInstance().isState(FKState.PAUSE)) {
                		fastBoard.updateLine(9,  GOLD + "En pause : "+GREEN+"âœ”");
                	}
                    if(timer == 600) {
                    	w.setTime(13000);
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Début de la nuit");
                    	
                    }
                    
                    if(timer == 1170) {
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+" Fin du jour :§3" + Episode + GOLD+" dans 30 secondes");
                    }
                    if(timer == 1190) {
                    	Bukkit.broadcastMessage(main.getInstance().getPrefix()+"Fin du jour : §3" + Episode + GOLD+" dans 10 secondes");
                    }
                    if(main.getInstance().Orange.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, GOLD+"Votre Team :"+GOLD+" Orange");
                    }else if(main.getInstance().Rouge.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, GOLD+"Votre Team :"+DARK_RED+" Rouge");
                    }else if(main.getInstance().Vert.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, GOLD+"Votre Team :"+DARK_GREEN+" Vert");
                    }else if(main.getInstance().Dieu.getEntries().contains(player.getDisplayName())) {
                    	fastBoard.updateLine(8, GOLD+"Votre Team :"+GRAY+" Dieu");
                    }else {
                    	fastBoard.updateLine(8, "§6Votre Team :§4 No Team");
                    }
                    fastBoard.updateLine(10, GOLD+"Kill(s) : "+AQUA+""+player.getStatistic(Statistic.PLAYER_KILLS));
                }
            }, 20, 20);
            	

            fastBoard.updateLines(
            		//0
            		GOLD + "",
            		//1
                    GOLD + "Jour : §3"+Episode ,
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
                    GOLD +"Votre Team :"+RED+" NO Team",
                    //9
                    GOLD + " ",
                    //10
                    GOLD+"Kills : "+AQUA+"0"


            );
        });
    }

}



