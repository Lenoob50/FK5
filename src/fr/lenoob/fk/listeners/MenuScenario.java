package fr.lenoob.fk.listeners;

import fr.lenoob.fk.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuScenario implements Listener {

    @EventHandler
    public void onInterract(InventoryClickEvent e){
        String name = e.getInventory().getName();
        if(e.getCurrentItem() == null)return;
        if(name.equals(ChatColor.DARK_AQUA+"Scenarios")){
            e.setCancelled(true);
            switch(e.getCurrentItem().getType()) {
                case FISHING_ROD:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Rodless")){
                        main.getInstance().scenario.remove("Rodless");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario rodless est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Rodless");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario rodless est §2activé");
                    }
                    break;
                case FURNACE:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("CutClean")){
                        main.getInstance().scenario.remove("CutClean");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario CutClean est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("CutClean");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario CutClean est §2activé");
                    }
                    break;
                case SKULL_ITEM:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Charged-Creeper")){
                        main.getInstance().scenario.remove("Charged-Creeper");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Charged Creeper est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Charged-Creeper");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Charged Creeper est §2activé");
                    }
                    break;
                case ENDER_PEARL:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("EnderPearl")){
                        main.getInstance().scenario.remove("EnderPearl");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Ender Pearl est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("EnderPearl");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Ender Pearl est §2activé");
                    }
                    break;
                case GOLD_SWORD:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("PVP")){
                        main.getInstance().scenario.remove("PVP");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario PVP est §cdesactivé");
                        World w = Bukkit.getWorld("world");
                        w.setPVP(false);
                    }else{
                        main.getInstance().scenario.add("PVP");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario PVP est §2activé");
                        World w = Bukkit.getWorld("world");
                        w.setPVP(true);
                    }
                    break;
                case POTION:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Potion")){
                        main.getInstance().scenario.remove("Potion");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Potion est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Potion");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Potion est §2activé");
                    }
                    break;
                case TNT:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Kaboum")){
                        main.getInstance().scenario.remove("Kaboum");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Kaboum est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Kaboum");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Kaboum est §2activé");
                    }
                    break;
                case APPLE:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Starter")){
                        main.getInstance().scenario.remove("Starter");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Starter est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Starter");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Starter est §2activé");
                    }
                    break;
                case DIAMOND:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Diamond")){
                        main.getInstance().scenario.remove("Diamond");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Diamond est §cdesactivé");
                    }else{
                        main.getInstance().scenario.add("Diamond");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Diamond est §2activé");
                    }
                    break;
                case ANVIL:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("TeamKill")){
                        main.getInstance().scenario.remove("TeamKill");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario TeamKill est §cdesactivé");
                        main.getInstance().Orange.setAllowFriendlyFire(false);
                        main.getInstance().Rouge.setAllowFriendlyFire(false);
                        main.getInstance().Vert.setAllowFriendlyFire(false);
                    }else{
                        main.getInstance().scenario.add("TeamKill");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario TeamKill est §2activé");
                        main.getInstance().Orange.setAllowFriendlyFire(true);
                        main.getInstance().Rouge.setAllowFriendlyFire(true);
                        main.getInstance().Vert.setAllowFriendlyFire(true);
                    }
                case CHEST:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("chest")) {
                		main.getInstance().scenario.remove("chest");
                		Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Chest Random est §cdesactivé");
                	 }else{
                         main.getInstance().scenario.add("chest");
                         Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Chest Random est §2activé");
                     }
                     break;
                case ENDER_PORTAL_FRAME:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("end")) {
                		main.getInstance().scenario.remove("end");
                		Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Ender est §cdesactivé");
                	 }else{
                         main.getInstance().scenario.add("end");
                         Bukkit.broadcastMessage(main.getInstance().getPrefix()+" §3Le scénario Ender est §2activé");
                     }
                     break;
			default:
				break;
            }

        }
    }

}

