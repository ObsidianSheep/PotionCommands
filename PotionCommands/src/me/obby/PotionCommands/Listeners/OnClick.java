package me.obby.PotionCommands.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.obby.PotionCommands.*;

public class OnClick implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {

		Strength strength = new Strength();
		Speed speed = new Speed();
		FireRes fireRes = new FireRes();
		Haste haste = new Haste();
		NightVision nightVision = new NightVision();
		WaterBreathing waterBreathing = new WaterBreathing();
		Regen regen = new Regen();
		JumpBoost jumpBoost = new JumpBoost();

		// Checks that the player is in the correct inventory
		if (!event.getView().getTitle().contains("Potions")) {
			return;
		}
		// If player clicks on a filler item nothing happens
		if (event.getCurrentItem() == null) {
			return;
		}
		// If the item does not have any meta data nothing happens
		// bug check for above if statement
		if (event.getCurrentItem().getItemMeta() == null) {
			return;
		}

		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);

		if (event.getClickedInventory().getType() == InventoryType.PLAYER) {
			return;
		}

		// Start of potions

		// Strength
		if (event.getSlot() == 11) {
			if (!player.hasPermission("potioncommands.use.strength")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			strength.potion(player);
			player.closeInventory();
			player.updateInventory();
		}

		// speed
		if (event.getSlot() == 12) {
			if (!player.hasPermission("potioncommands.use.speed")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			speed.potion(player);
			player.closeInventory();
			player.updateInventory();
		}

		// Fire Res
		if (event.getSlot() == 13) {
			if (!player.hasPermission("potioncommands.use.fireRes")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			fireRes.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
		// Haste
		if (event.getSlot() == 14) {
			if (!player.hasPermission("potioncommands.use.haste")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			haste.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
		// Night Vision
		if (event.getSlot() == 15) {
			if (!player.hasPermission("potioncommands.use.nightVision")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			nightVision.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
		// Water Breathing
		if (event.getSlot() == 21) {
			if (!player.hasPermission("potioncommands.use.waterBreathing")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			waterBreathing.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
		// Regeneration
		if (event.getSlot() == 22) {
			if (!player.hasPermission("potioncommands.use.regeneration")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			regen.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
		// Jump Boost
		if (event.getSlot() == 23) {
			if (!player.hasPermission("potioncommands.use.jumpBoost")) {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this potion");
				player.closeInventory();
				player.updateInventory();
				return;
			}
			jumpBoost.potion(player);
			player.closeInventory();
			player.updateInventory();
		}
		
	}

}
