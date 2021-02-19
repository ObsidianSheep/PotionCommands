package me.obby.PotionCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireRes implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("FireRes") || label.equalsIgnoreCase("fr")) {
			
			Player player = (Player) sender;
			
			if (!player.hasPermission("potioncommands.use.fireRes")) {
				sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
				return true;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "Only ingame players can play the game!");
				return true;
			}
			
			if (args.length == 0) {
				potion(player);
				
				return false;
			}
			
			return true;
		}
		return false;
	}
	
	public void potion(Player player) {
		String potionName = "fireRes";
		String potionNameChat = "Fire Resistance";
		int duration = Main.config.getconfig().getConfigurationSection(potionName).getInt("duration") * 20;
		int power = Main.config.getconfig().getConfigurationSection(potionName).getInt("strength") - 1 ;
		int chatPower = power + 1;

		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, duration, power));
		player.sendMessage(ChatColor.RED + "Gave you " + potionNameChat + " " + chatPower + " for " + duration + " Seconds!");
		Bukkit.getLogger().info("Gave " + potionNameChat + " " + chatPower + " to " + player + " for " + duration + " seconds!");
		return;
	}

}
