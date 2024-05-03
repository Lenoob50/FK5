package fr.lenoob.fk;


import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GOLD;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.lenoob.fk.commands.CommandBroadcast;
import fr.lenoob.fk.commands.CommandDieu;
import fr.lenoob.fk.commands.CommandFKTp;
import fr.lenoob.fk.commands.CommandFkStop;
import fr.lenoob.fk.commands.CommandPause;
import fr.lenoob.fk.commands.CommandStart;
import fr.lenoob.fk.commands.CommandState;
import fr.lenoob.fk.commands.CommandTeam;
import fr.lenoob.fk.commands.FkTpTab;
import fr.lenoob.fk.commands.PauseComplete;
import fr.lenoob.fk.commands.RandomTeam;
import fr.lenoob.fk.commands.Scenario;
import fr.lenoob.fk.commands.ScenarioCompleter;
import fr.lenoob.fk.commands.StateCommandTab;
import fr.lenoob.fk.commands.TabTeam;
import fr.lenoob.fk.inventory.InventoryManager;
import fr.lenoob.fk.listeners.MenuScenario;
import fr.lenoob.fk.listeners.OnAchitvementGet;
import fr.lenoob.fk.listeners.OnBreak;
import fr.lenoob.fk.listeners.OnCreeperSpawn;
import fr.lenoob.fk.listeners.OnDimChange;
import fr.lenoob.fk.listeners.OnEatLost;
import fr.lenoob.fk.listeners.OnEnchant;
import fr.lenoob.fk.listeners.OnJoin;
import fr.lenoob.fk.listeners.OnMoove;
import fr.lenoob.fk.listeners.OnNetherPlace;
import fr.lenoob.fk.listeners.OnPearlUseE;
import fr.lenoob.fk.listeners.OnPing;
import fr.lenoob.fk.listeners.OnPlace;
import fr.lenoob.fk.listeners.OnQuitt;
import fr.lenoob.fk.listeners.OnRodUse;
import fr.lenoob.fk.listeners.OnTalk;
import fr.lenoob.fk.listeners.OnTorchPlace;
import fr.lenoob.fk.listeners.OnWaterPlace;
import fr.lenoob.fk.listeners.OnWorkBenchPlace;
import fr.lenoob.fk.listeners.PlayerDeath;
import fr.lenoob.fk.scoreboard.ScoreboardManager;
import fr.lenoob.fk.utils.CutClean;
import fr.lenoob.fk.utils.CutCleanFood;
import fr.lenoob.fk.utils.FKState;
import fr.lenoob.fk.utils.PotionScenario;


public class main extends JavaPlugin {
	public Scoreboard sb ;
	public Team Orange;
	public Team Vert;
	public Team Rouge;
	public Team Dieu;
	public FKState current;
	public String Prefix = AQUA+"["+GOLD+"Fallen Kingdomm's"+AQUA+"]"+GOLD+":";
	public List<String> scenario = new ArrayList<>();
	
	PluginManager pm = Bukkit.getPluginManager();

	@Override
	public void onEnable() {
		instance = this;
		if(this.isState(FKState.PAUSE)) {
			current = FKState.PAUSE;
		}else {
			current = FKState.WAIT;
		}
		new InventoryManager();
		System.out.println("[FK] Plugin allume");
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnPing(), this);
		pm.registerEvents(new OnPlace(), this);
		pm.registerEvents(new OnTalk(), this);
		pm.registerEvents(new OnMoove(), this);
		pm.registerEvents(new OnBreak(), this);
		pm.registerEvents(new OnQuitt(), this);
		pm.registerEvents(new OnCreeperSpawn(), this);
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new OnDimChange(), this);
		pm.registerEvents(new OnWaterPlace(), this);
		pm.registerEvents(new OnTorchPlace(), this);
		pm.registerEvents(new OnRodUse(), this);
		pm.registerEvents(new CutClean(), this);
		pm.registerEvents(new OnPearlUseE(),this);
		pm.registerEvents(new OnNetherPlace(), this);
		pm.registerEvents(new OnEatLost(), this);
		pm.registerEvents(new OnEnchant(), this);
		pm.registerEvents(new OnAchitvementGet(), this);
		pm.registerEvents(new OnWorkBenchPlace(), this);
		pm.registerEvents(new MenuScenario(),this);
		pm.registerEvents(new PotionScenario(), this);
		pm.registerEvents(new CutCleanFood(), this);
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Orange = sb.registerNewTeam("Orange");
		Orange.setAllowFriendlyFire(true);
		Orange.setDisplayName(ChatColor.GOLD+"");
		Orange.setPrefix(ChatColor.GOLD+"");
		Vert = sb.registerNewTeam("Vert");
		Vert.setAllowFriendlyFire(true);
		Vert.setDisplayName(ChatColor.DARK_GREEN+"");
		Vert.setPrefix(ChatColor.DARK_GREEN+"");
		Rouge = sb.registerNewTeam("Rouge");
		Rouge.setAllowFriendlyFire(true);
		Rouge.setDisplayName(ChatColor.RED+"");
		Rouge.setPrefix(ChatColor.RED+"");
		Dieu = sb.registerNewTeam("Dieu");
		Dieu.setAllowFriendlyFire(true);
		Dieu.setDisplayName(ChatColor.WHITE+"");
		Dieu.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
		World w = Bukkit.getWorld("world");
		w.setPVP(false);
		w.setTime(0);
		w.setDifficulty(Difficulty.PEACEFUL);
		w.setGameRuleValue("doDaylightCycle", "false");
		registerHealth();
		getCommand("fkpause").setTabCompleter(new PauseComplete());
		getCommand("fkpause").setExecutor(new CommandPause());
		getCommand("fkstart").setExecutor(new CommandStart());
		getCommand("fkstop").setExecutor(new CommandFkStop());
		getCommand("bc").setExecutor(new CommandBroadcast());
		getCommand("state").setExecutor(new CommandState());
		getCommand("state").setTabCompleter(new StateCommandTab());
		getCommand("fktp").setExecutor(new CommandFKTp());
		getCommand("fktp").setTabCompleter(new FkTpTab());
		getCommand("dieu").setExecutor(new CommandDieu());
		getCommand("team").setExecutor(new CommandTeam());
		getCommand("team").setTabCompleter(new TabTeam());
		getCommand("teamr").setExecutor(new RandomTeam());
		getCommand("scenario").setExecutor(new Scenario());
		getCommand("scenario").setTabCompleter(new ScenarioCompleter());
	}
	

	@Override
	public void onDisable() {
		resetScenario();
		System.out.println("[Fk] Plugin eteint");
	}
	
	@Override
	public void onLoad() {
		System.out.println("===========||FK Plugin||===========");
		System.out.println(" ");
		System.out.println("Version : "+pm.getPlugin(this.getName()));
		System.out.println(" ");
		System.out.println("Author : Lenoob_");
		System.out.println(" ");
		System.out.println("===========||FK Plugin||===========");
	}
	
	public static main instance;
	public static main getInstance() {
		return instance;
	}
	
	public FKState getState() {
		return current;
	}
	
	public void registerHealth() {
		if(sb.getObjective("health")!= null) {
			sb.getObjective("helath").unregister();
		}
		Objective h = sb.registerNewObjective("health", "health");
		h.setDisplayName(ChatColor.RED+"♥");
		h.setDisplaySlot(DisplaySlot.BELOW_NAME);
	}
	public void setState(FKState state) {
		current = state;
	}
	
	public boolean isState(FKState state) {
		return current ==  state;
	}
	
	public Location getGreenCenter(Player p) {
		return new Location(Bukkit.getWorld("world"), 168,p.getLocation().getY(),334);
	}
	public Location getRedCenter(Player p) {
		return new Location(Bukkit.getWorld("world"), -134,p.getLocation().getY(),-346);
	}
	
	public Location getOrangeCenter(Player p) {
		return new Location(Bukkit.getWorld("world"),186,p.getLocation().getY(),62 );
	}
	
	public ScoreboardManager sm = new ScoreboardManager();

	public String getPrefix(){
		return Prefix;
	}

	public void resetScenario(){
		scenario.clear();
	}
	
}
