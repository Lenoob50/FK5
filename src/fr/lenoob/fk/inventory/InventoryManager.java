package fr.lenoob.fk.inventory;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Golem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {

	public Inventory Scenario;

	
	 public InventoryManager(){
		 	ScenarioSelect();
	 }
	 public void ScenarioSelect(){
	        Inventory invt = Bukkit.createInventory(null,36, ChatColor.DARK_AQUA+"Scenarios");
	        ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE,1,(short) 9);
	        ItemMeta im = is.getItemMeta();
	        im.setDisplayName(" ");
	        is.setItemMeta(im);
	        
	    	ItemStack rod = new ItemStack(Material.FISHING_ROD);
			ItemMeta rodM = rod.getItemMeta();
			rodM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le Rodless");
			rodM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> rodlore = new ArrayList<String>();
			rodlore.add(ChatColor.GREEN+"Ce scenario active ou non l'utilisation");
			rodlore.add(ChatColor.GREEN+"de la canne à péche");
			rodM.setLore(rodlore);
			rod.setItemMeta(rodM);

			ItemStack CutClean = new ItemStack(Material.FURNACE);
			ItemMeta CutCleanM = CutClean.getItemMeta();
			CutCleanM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le CutClean");
			CutCleanM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> Cutlore = new ArrayList<String>();
			Cutlore.add(ChatColor.GREEN+"Ce scenario active ou non la cuisson");
			Cutlore.add(ChatColor.GREEN+"automatique des minerais");
			CutCleanM.setLore(Cutlore);
			CutClean.setItemMeta(CutCleanM);

			ItemStack Creeper = new ItemStack(Material.SKULL_ITEM,1,(short)4);
			ItemMeta CreeperM = Creeper.getItemMeta();
			CreeperM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le spawn de Creeper Chargé");
			CreeperM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> CreeperLore = new ArrayList<String>();
			CreeperLore.add(ChatColor.GREEN+"Ce scenario active ou non le spawn");
			CreeperLore.add(ChatColor.GREEN+"de creeper chargé (20%)");
			CreeperM.setLore(CreeperLore);
			Creeper.setItemMeta(CreeperM);

			ItemStack Pearl = new ItemStack(Material.ENDER_PEARL);
			ItemMeta PearlM = Pearl.getItemMeta();
			PearlM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver l'utilisation de Pearl");
			PearlM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> PearlLore = new ArrayList<String>();
			PearlLore.add(ChatColor.GREEN+"Ce scenario active ou non l'utilisation");
			PearlLore.add(ChatColor.GREEN+"d'ender pearl");
			PearlM.setLore(PearlLore);
			Pearl.setItemMeta(PearlM);

			ItemStack PVP = new ItemStack(Material.GOLD_SWORD);
			ItemMeta PVPM = PVP.getItemMeta();
			PVPM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le PVP");
			PVPM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> PVPLore = new ArrayList<String>();
			PVPLore.add(ChatColor.GREEN+"Ce scenario active ou non le PVP");
			PVPM.setLore(PVPLore);
			PVP.setItemMeta(PVPM);
			
			ItemStack Potion = new ItemStack(Material.POTION);
			ItemMeta PotionM = Potion.getItemMeta();
			PotionM.setDisplayName(ChatColor.DARK_AQUA+"Active/Desactive le drop de Potions");
			PotionM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> PotionLore = new ArrayList<String>();
			PotionLore.add(ChatColor.GREEN+"Ce scenario active ou non le drop de potion");
			PotionLore.add(ChatColor.GREEN+"lorsqu'un mob meurt");
			PotionM.setLore(PotionLore);
			Potion.setItemMeta(PotionM);
			
			ItemStack Gapp = new ItemStack(Material.TNT);
			ItemMeta GappM = Gapp.getItemMeta();
			GappM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le drop de TNT");
			GappM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> GappLore = new ArrayList<String>();
			GappLore.add(ChatColor.GREEN+"Ce scenario active ou non le drop de TNT");
			GappLore.add(ChatColor.GREEN+"lorsqu'un joueur meurt");
			GappM.setLore(GappLore);
			Gapp.setItemMeta(GappM);
			
			ItemStack Apple = new ItemStack(Material.APPLE);
			ItemMeta AppleM = Apple.getItemMeta();
			AppleM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le starter");
			AppleM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> StarterLore = new ArrayList<String>();
			StarterLore.add(ChatColor.GREEN+"Ce scenario active ou non le starter");
			StarterLore.add(ChatColor.GREEN+"Compositon : ");
			StarterLore.add(ChatColor.GREEN+"-10 Pommes Rouges");
			StarterLore.add(ChatColor.GREEN+"-10 Steak");
			AppleM.setLore(StarterLore);
			Apple.setItemMeta(AppleM);
			
			
			ItemStack Diamond = new ItemStack(Material.DIAMOND);
			ItemMeta DiamondM = Diamond.getItemMeta();
			DiamondM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le double diamants");
			DiamondM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> DiamondLore = new ArrayList<String>();
			DiamondLore.add(ChatColor.GREEN+"Ce scenario active ou non");
			DiamondLore.add(ChatColor.GREEN+"le boost de diamants (X2)");
			DiamondM.setLore(DiamondLore);
			Diamond.setItemMeta(DiamondM);
			
			ItemStack TK = new ItemStack(Material.ANVIL);
			ItemMeta TKM = TK.getItemMeta();
			TKM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver le Team Kill");
			TKM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> TKLore = new ArrayList<>();
			TKLore.add(ChatColor.GREEN+"Ce scenario active ou non");
			TKLore.add(ChatColor.GREEN+"la possibilité de se taper entre alliés");
			TKM.setLore(TKLore);
			TK.setItemMeta(TKM);
			
			ItemStack chest = new ItemStack(Material.CHEST);
			ItemMeta chestM = chest.getItemMeta();
			chestM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver les coffres");
			chestM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> chestLore = new ArrayList<>();
			chestLore.add(ChatColor.GREEN+"Ce scenario active ou non");
			chestLore.add(ChatColor.GREEN+"le spawn de coffre à un jour random");
			chestM.setLore(chestLore);
			chest.setItemMeta(chestM);
			
			ItemStack end = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta endM = TK.getItemMeta();
			endM.setDisplayName(ChatColor.DARK_AQUA+"Activer/Desactiver l'end");
			endM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			List<String> endLore = new ArrayList<>();
			endLore.add(ChatColor.GREEN+"Ce scenario active ou non");
			endLore.add(ChatColor.GREEN+"la possibilité de se taper entre alliés");
			endM.setLore(endLore);
			end.setItemMeta(endM);
			

			invt.setItem(0, end);
	        invt.setItem(2,Gapp);
	        invt.setItem(4, Apple);
	        invt.setItem(6, Potion);
	        invt.setItem(10,rod);
			invt.setItem(12,CutClean);
			invt.setItem(14,Creeper);
			invt.setItem(16,Pearl);
			invt.setItem(19, TK);
			invt.setItem(21,PVP);
			invt.setItem(23, Diamond);
			invt.setItem(25, chest);
	        
	        Scenario = invt;
	 }
}

