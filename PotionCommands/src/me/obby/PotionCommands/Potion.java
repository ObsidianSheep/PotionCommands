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
		String guiName = Main.config.getconfig().getString("guiName");
		String guiNameFormat = Main.config.getconfig().getString("guiNameFormat");
		int guiSize = Main.config.getconfig().getInt("guiSize");
		
		Inventory inv = Bukkit.createInventory(null, guiSize, ChatColor.translateAlternateColorCodes('&', guiNameFormat) + guiName);
		// Potions : strength, speed, fire res, haste, night vision, water breathing, regeneration, jump boost
		
		// Pulls all the custom settings from the config
		ItemStack filler = new ItemStack(Material.getMaterial(Main.config.getconfig().getString("filler")));
		
		ItemStack potion1 = new ItemStack(Material.POTION);
		int potion1loc = Main.config.getconfig().getConfigurationSection("strengthgui").getInt("location");
		String potion1Lore = Main.config.getconfig().getConfigurationSection("strengthgui").getString("lore");
		String potion1TitleColor = Main.config.getconfig().getConfigurationSection("strengthgui").getString("titlecolor");
		Boolean potion1Active = Main.config.getconfig().getConfigurationSection("strengthgui").getBoolean("active");
		
		ItemStack potion2 = new ItemStack(Material.POTION);
		int potion2loc = Main.config.getconfig().getConfigurationSection("speedgui").getInt("location");
		String potion2Lore = Main.config.getconfig().getConfigurationSection("speedgui").getString("lore");
		String potion2TitleColor = Main.config.getconfig().getConfigurationSection("speedgui").getString("titlecolor");
		Boolean potion2Active = Main.config.getconfig().getConfigurationSection("speedgui").getBoolean("active");
		
		ItemStack potion3 = new ItemStack(Material.POTION);
		int potion3loc = Main.config.getconfig().getConfigurationSection("fireResgui").getInt("location");
		String potion3Lore = Main.config.getconfig().getConfigurationSection("fireResgui").getString("lore");
		String potion3TitleColor = Main.config.getconfig().getConfigurationSection("fireResgui").getString("titlecolor");
		Boolean potion3Active = Main.config.getconfig().getConfigurationSection("fireResgui").getBoolean("active");
		
		ItemStack potion4 = new ItemStack(Material.POTION);
		int potion4loc = Main.config.getconfig().getConfigurationSection("hastegui").getInt("location");
		String potion4Lore = Main.config.getconfig().getConfigurationSection("hastegui").getString("lore");
		String potion4TitleColor = Main.config.getconfig().getConfigurationSection("hastegui").getString("titlecolor");
		Boolean potion4Active = Main.config.getconfig().getConfigurationSection("hastegui").getBoolean("active");
		
		ItemStack potion5 = new ItemStack(Material.POTION);
		int potion5loc = Main.config.getconfig().getConfigurationSection("nightVisiongui").getInt("location");
		String potion5Lore = Main.config.getconfig().getConfigurationSection("nightVisiongui").getString("lore");
		String potion5TitleColor = Main.config.getconfig().getConfigurationSection("nightVisiongui").getString("titlecolor");
		Boolean potion5Active = Main.config.getconfig().getConfigurationSection("nightVisiongui").getBoolean("active");
		
		ItemStack potion6 = new ItemStack(Material.POTION);
		int potion6loc = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getInt("location");
		String potion6Lore = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getString("lore");
		String potion6TitleColor = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getString("titlecolor");
		Boolean potion6Active = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getBoolean("active");
		
		ItemStack potion7 = new ItemStack(Material.POTION);
		int potion7loc = Main.config.getconfig().getConfigurationSection("regengui").getInt("location");
		String potion7Lore = Main.config.getconfig().getConfigurationSection("regengui").getString("lore");
		String potion7TitleColor = Main.config.getconfig().getConfigurationSection("regengui").getString("titlecolor");
		Boolean potion7Active = Main.config.getconfig().getConfigurationSection("regengui").getBoolean("active");
		
		ItemStack potion8 = new ItemStack(Material.POTION);
		int potion8loc = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getInt("location");
		String potion8Lore = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getString("lore");
		String potion8TitleColor = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getString("titlecolor");
		Boolean potion8Active = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getBoolean("active");
		
		// Create the potion items in the gui and hide the item if the player does not have the permission to use it

		if (!potion1Active == false) {
			if (player.hasPermission("potioncommands.use.strength")) {
				// Strength
				ItemMeta meta1 = potion1.getItemMeta();
				List<String> lore1 = new ArrayList<String>();
				lore1.add("");
				lore1.add(ChatColor.translateAlternateColorCodes('&', potion1Lore));
				meta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion1TitleColor) + "Strength");
				meta1.setLore(lore1);
				potion1.setItemMeta(meta1);
				inv.setItem(potion1loc, potion1);
			} 
		}
		if (!potion2Active == false) {
			if (player.hasPermission("potioncommands.use.speed")) {
				// Speed
				ItemMeta meta2 = potion2.getItemMeta();
				List<String> lore2 = new ArrayList<String>();
				lore2.add("");
				lore2.add(ChatColor.translateAlternateColorCodes('&', potion2Lore));
				meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion2TitleColor) + "Speed");
				meta2.setLore(lore2);
				potion2.setItemMeta(meta2);
				inv.setItem(potion2loc, potion2);
			} 
		}
		if (!potion3Active == false) {
			if (player.hasPermission("potioncommands.use.fireRes")) {
				// Fire Resistance
				ItemMeta meta3 = potion3.getItemMeta();
				List<String> lore3 = new ArrayList<String>();
				lore3.add("");
				lore3.add(ChatColor.translateAlternateColorCodes('&', potion3Lore));
				meta3.setDisplayName(
						ChatColor.translateAlternateColorCodes('&', potion3TitleColor) + "Fire Resistance");
				meta3.setLore(lore3);
				potion3.setItemMeta(meta3);
				inv.setItem(potion3loc, potion3);
			} 
		}
		if (!potion4Active == false) {
			if (player.hasPermission("potioncommands.use.haste")) {
				// Haste
				ItemMeta meta4 = potion4.getItemMeta();
				List<String> lore4 = new ArrayList<String>();
				lore4.add("");
				lore4.add(ChatColor.translateAlternateColorCodes('&', potion4Lore));
				meta4.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion4TitleColor) + "Haste");
				meta4.setLore(lore4);
				potion4.setItemMeta(meta4);
				inv.setItem(potion4loc, potion4);
			} 
		}
		if (!potion5Active == false) {
			if (player.hasPermission("potioncommands.use.nightVision")) {
				// Night Vision
				ItemMeta meta5 = potion5.getItemMeta();
				List<String> lore5 = new ArrayList<String>();
				lore5.add("");
				lore5.add(ChatColor.translateAlternateColorCodes('&', potion5Lore));
				meta5.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion5TitleColor) + "Night Vision");
				meta5.setLore(lore5);
				potion5.setItemMeta(meta5);
				inv.setItem(potion5loc, potion5);
			} 
		}
		if (!potion6Active == false) {
			if (player.hasPermission("potioncommands.use.waterBreathing")) {
				// Water Breathing
				ItemMeta meta6 = potion6.getItemMeta();
				List<String> lore6 = new ArrayList<String>();
				lore6.add("");
				lore6.add(ChatColor.translateAlternateColorCodes('&', potion6Lore));
				meta6.setDisplayName(
						ChatColor.translateAlternateColorCodes('&', potion6TitleColor) + "Water Breathing");
				meta6.setLore(lore6);
				potion6.setItemMeta(meta6);
				inv.setItem(potion6loc, potion6);
			} 
		}
		if (!potion7Active == false) {
			if (player.hasPermission("potioncommands.use.regeneration")) {
				// Regeneration
				ItemMeta meta7 = potion7.getItemMeta();
				List<String> lore7 = new ArrayList<String>();
				lore7.add("");
				lore7.add(ChatColor.translateAlternateColorCodes('&', potion7Lore));
				meta7.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion7TitleColor) + "Regeneration");
				meta7.setLore(lore7);
				potion7.setItemMeta(meta7);
				inv.setItem(potion7loc, potion7);
			} 
		}
		if (!potion8Active == false) {
			if (player.hasPermission("potioncommands.use.jumpBoost")) {
				// Jump Boost
				ItemMeta meta8 = potion8.getItemMeta();
				List<String> lore8 = new ArrayList<String>();
				lore8.add("");
				lore8.add(ChatColor.translateAlternateColorCodes('&', potion8Lore));
				meta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', potion8TitleColor) + "Jump Boost");
				meta8.setLore(lore8);
				potion8.setItemMeta(meta8);
				inv.setItem(potion8loc, potion8);
			} 
		}
		// Filler
		for (int index = 0; index < inv.getSize(); index++) {
			if (inv.getItem(index) == null) {
				inv.setItem(index, filler);
			}
			player.openInventory(inv);
		}
	}

}
