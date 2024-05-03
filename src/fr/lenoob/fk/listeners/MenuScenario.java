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
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario rodless est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Rodless");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario rodless est �2activ�");
                    }
                    break;
                case FURNACE:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("CutClean")){
                        main.getInstance().scenario.remove("CutClean");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario CutClean est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("CutClean");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario CutClean est �2activ�");
                    }
                    break;
                case SKULL_ITEM:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Charged-Creeper")){
                        main.getInstance().scenario.remove("Charged-Creeper");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Charged Creeper est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Charged-Creeper");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Charged Creeper est �2activ�");
                    }
                    break;
                case ENDER_PEARL:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("EnderPearl")){
                        main.getInstance().scenario.remove("EnderPearl");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Ender Pearl est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("EnderPearl");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Ender Pearl est �2activ�");
                    }
                    break;
                case GOLD_SWORD:
                    e.setCancelled(true);
                    if(main.getInstance().scenario.contains("PVP")){
                        main.getInstance().scenario.remove("PVP");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario PVP est �cdesactiv�");
                        World w = Bukkit.getWorld("world");
                        w.setPVP(false);
                    }else{
                        main.getInstance().scenario.add("PVP");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario PVP est �2activ�");
                        World w = Bukkit.getWorld("world");
                        w.setPVP(true);
                    }
                    break;
                case POTION:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Potion")){
                        main.getInstance().scenario.remove("Potion");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Potion est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Potion");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Potion est �2activ�");
                    }
                    break;
                case TNT:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Kaboum")){
                        main.getInstance().scenario.remove("Kaboum");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Kaboum est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Kaboum");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Kaboum est �2activ�");
                    }
                    break;
                case APPLE:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Starter")){
                        main.getInstance().scenario.remove("Starter");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Starter est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Starter");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Starter est �2activ�");
                    }
                    break;
                case DIAMOND:
                	e.setCancelled(true);
                    if(main.getInstance().scenario.contains("Diamond")){
                        main.getInstance().scenario.remove("Diamond");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Diamond est �cdesactiv�");
                    }else{
                        main.getInstance().scenario.add("Diamond");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Diamond est �2activ�");
                    }
                    break;
                case ANVIL:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("TeamKill")){
                        main.getInstance().scenario.remove("TeamKill");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario TeamKill est �cdesactiv�");
                        main.getInstance().Orange.setAllowFriendlyFire(false);
                        main.getInstance().Rouge.setAllowFriendlyFire(false);
                        main.getInstance().Vert.setAllowFriendlyFire(false);
                    }else{
                        main.getInstance().scenario.add("TeamKill");
                        Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario TeamKill est �2activ�");
                        main.getInstance().Orange.setAllowFriendlyFire(true);
                        main.getInstance().Rouge.setAllowFriendlyFire(true);
                        main.getInstance().Vert.setAllowFriendlyFire(true);
                    }
                case CHEST:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("chest")) {
                		main.getInstance().scenario.remove("chest");
                		Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Chest Random est �cdesactiv�");
                	 }else{
                         main.getInstance().scenario.add("chest");
                         Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Chest Random est �2activ�");
                     }
                     break;
                case ENDER_PORTAL_FRAME:
                	e.setCancelled(true);
                	if(main.getInstance().scenario.contains("end")) {
                		main.getInstance().scenario.remove("end");
                		Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Ender est �cdesactiv�");
                	 }else{
                         main.getInstance().scenario.add("end");
                         Bukkit.broadcastMessage(main.getInstance().getPrefix()+" �3Le sc�nario Ender est �2activ�");
                     }
                     break;
			default:
				break;
            }

        }
    }

}

