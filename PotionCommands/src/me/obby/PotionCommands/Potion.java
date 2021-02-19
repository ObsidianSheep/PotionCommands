package me.obby.PotionCommands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Potion implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("potion")) {
			Player player = (Player) sender;
			
			if (!player.hasPermission("potioncommands.use")) {
				sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
				return true;
			}
			
			if (args.length == 0) {
				// /potion

				if (!(sender instanceof Player)) {
					sender.sendMessage(ChatColor.DARK_RED + "Only ingame players can play the game!");
					return true;
				}
				
				gui(player);
				return true;
			}
			
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("reload")) {
					// /potion reload

					if (!player.hasPermission("potioncommands.reload")) {
						sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to run this command!");
						return true;
					}

					Main.config.reloadConfig();
					player.sendMessage(ChatColor.DARK_RED + "Config reloaded!");
					Bukkit.getLogger().info("Potion Commands config has been reloaded!");
					return true;
				}
				
				return true;
			}

			return true;
		}
		
		return false;
	}

	public void gui(Player player) {
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.RED + "Potions");
		// Potions : strength, speed, fire res, haste, night vision, water breathing, regeneration, jump boost
		ItemStack filler = new ItemStack(Material.getMaterial(Main.config.getconfig().getString("filler")));
		ItemStack potion1 = new ItemStack(Material.POTION);
		ItemStack potion2 = new ItemStack(Material.POTION);
		ItemStack potion3 = new ItemStack(Material.POTION);
		ItemStack potion4 = new ItemStack(Material.POTION);
		ItemStack potion5 = new ItemStack(Material.POTION);
		ItemStack potion6 = new ItemStack(Material.POTION);
		ItemStack potion7 = new ItemStack(Material.POTION);
		ItemStack potion8 = new ItemStack(Material.POTION);
		// Customize

		// Strength
		ItemMeta meta1 = potion1.getItemMeta();
		List<String> lore1 = new ArrayList<String>();
		lore1.add("");
		lore1.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Strength!");
		meta1.setDisplayName(ChatColor.RED + "Strength");
		meta1.setLore(lore1);
		potion1.setItemMeta(meta1);
		inv.setItem(11, potion1);

		// Speed
		ItemMeta meta2 = potion2.getItemMeta();
		List<String> lore2 = new ArrayList<String>();
		lore2.add("");
		lore2.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Speed!");
		meta2.setDisplayName(ChatColor.RED + "Speed");
		meta2.setLore(lore2);
		potion2.setItemMeta(meta2);
		inv.setItem(12, potion2);
		
		// Fire Resistance
		ItemMeta meta3 = potion3.getItemMeta();
		List<String> lore3 = new ArrayList<String>();
		lore3.add("");
		lore3.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Fire Resistance!");
		meta3.setDisplayName(ChatColor.RED + "Fire Resistance");
		meta3.setLore(lore3);
		potion3.setItemMeta(meta3);
		inv.setItem(13, potion3);
		
		// Haste
		ItemMeta meta4 = potion4.getItemMeta();
		List<String> lore4 = new ArrayList<String>();
		lore4.add("");
		lore4.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Haste!");
		meta4.setDisplayName(ChatColor.RED + "Haste");
		meta4.setLore(lore4);
		potion4.setItemMeta(meta4);
		inv.setItem(14, potion4);
		
		// Night Vision
		ItemMeta meta5 = potion5.getItemMeta();
		List<String> lore5 = new ArrayList<String>();
		lore5.add("");
		lore5.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Night Vision!");
		meta5.setDisplayName(ChatColor.RED + "Night Vision");
		meta5.setLore(lore5);
		potion5.setItemMeta(meta5);
		inv.setItem(15, potion5);
		
		// Water Breathing
		ItemMeta meta6 = potion6.getItemMeta();
		List<String> lore6 = new ArrayList<String>();
		lore6.add("");
		lore6.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Water Breathing!");
		meta6.setDisplayName(ChatColor.RED + "Water Breathing");
		meta6.setLore(lore6);
		potion6.setItemMeta(meta6);
		inv.setItem(21, potion6);
		
		// Regeneration
		ItemMeta meta7 = potion7.getItemMeta();
		List<String> lore7 = new ArrayList<String>();
		lore7.add("");
		lore7.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Regeneration!");
		meta7.setDisplayName(ChatColor.RED + "Regeneration");
		meta7.setLore(lore7);
		potion7.setItemMeta(meta7);
		inv.setItem(22, potion7);
		
		// Jump Boost
		ItemMeta meta8 = potion8.getItemMeta();
		List<String> lore8 = new ArrayList<String>();
		lore8.add("");
		lore8.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Activate Jump Boost!");
		meta8.setDisplayName(ChatColor.RED + "Jump Boost");
		meta8.setLore(lore8);
		potion8.setItemMeta(meta8);
		inv.setItem(23, potion8);

		// Filler
		for (int index = 0; index < inv.getSize(); index++) {
			if (inv.getItem(index) == null) {
				inv.setItem(index, filler);
			}
			player.openInventory(inv);
		}
	}

}
