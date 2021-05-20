package me.obby.PotionCommands.Listeners;

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
		
		String guiName = Main.config.getconfig().getString("guiName");
		
		int potion1loc = Main.config.getconfig().getConfigurationSection("strengthgui").getInt("location");
		int potion2loc = Main.config.getconfig().getConfigurationSection("speedgui").getInt("location");
		int potion3loc = Main.config.getconfig().getConfigurationSection("fireResgui").getInt("location");
		int potion4loc = Main.config.getconfig().getConfigurationSection("hastegui").getInt("location");
		int potion5loc = Main.config.getconfig().getConfigurationSection("nightVisiongui").getInt("location");
		int potion6loc = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getInt("location");
		int potion7loc = Main.config.getconfig().getConfigurationSection("regengui").getInt("location");
		int potion8loc = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getInt("location");
		
		Boolean potion1Active = Main.config.getconfig().getConfigurationSection("strengthgui").getBoolean("active");
		Boolean potion2Active = Main.config.getconfig().getConfigurationSection("speedgui").getBoolean("active");
		Boolean potion3Active = Main.config.getconfig().getConfigurationSection("fireResgui").getBoolean("active");
		Boolean potion4Active = Main.config.getconfig().getConfigurationSection("hastegui").getBoolean("active");
		Boolean potion5Active = Main.config.getconfig().getConfigurationSection("nightVisiongui").getBoolean("active");
		Boolean potion6Active = Main.config.getconfig().getConfigurationSection("waterBreathinggui").getBoolean("active");
		Boolean potion7Active = Main.config.getconfig().getConfigurationSection("regengui").getBoolean("active");
		Boolean potion8Active = Main.config.getconfig().getConfigurationSection("jumpBoostgui").getBoolean("active");


		// Checks that the player is in the correct inventory
		if (!event.getView().getTitle().contains(guiName)) {
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
		if (!potion1Active == false) {	
			if (event.getSlot() == potion1loc) {
				if (!player.hasPermission("potioncommands.use.strength")) {
					return;
				}
				strength.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion2Active == false) {
			// speed
			if (event.getSlot() == potion2loc) {
				if (!player.hasPermission("potioncommands.use.speed")) {
					return;
				}
				speed.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion3Active == false) {
			// Fire Res
			if (event.getSlot() == potion3loc) {
				if (!player.hasPermission("potioncommands.use.fireRes")) {
					return;
				}
				fireRes.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion4Active == false) {
			// Haste
			if (event.getSlot() == potion4loc) {
				if (!player.hasPermission("potioncommands.use.haste")) {
					return;
				}
				haste.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion5Active == false) {
			// Night Vision
			if (event.getSlot() == potion5loc) {
				if (!player.hasPermission("potioncommands.use.nightVision")) {
					return;
				}
				nightVision.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion6Active == false) {
			// Water Breathing
			if (event.getSlot() == potion6loc) {
				if (!player.hasPermission("potioncommands.use.waterBreathing")) {
					return;
				}
				waterBreathing.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion7Active == false) {
			// Regeneration
			if (event.getSlot() == potion7loc) {
				if (!player.hasPermission("potioncommands.use.regeneration")) {
					return;
				}
				regen.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		if (!potion8Active == false) {
			// Jump Boost
			if (event.getSlot() == potion8loc) {
				if (!player.hasPermission("potioncommands.use.jumpBoost")) {
					return;
				}
				jumpBoost.potion(player);
				player.closeInventory();
				player.updateInventory();
			} 
		}
		
	}

}
