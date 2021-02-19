package me.obby.PotionCommands;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.obby.PotionCommands.Files.ConfigManager;
import me.obby.PotionCommands.Listeners.OnClick;

public class Main extends JavaPlugin implements Listener{
	
	public static ConfigManager config;
	public static Listener listener;
	
	@Override
	public void onEnable() {
		
		PluginManager PluginManager = Bukkit.getPluginManager();
		PluginManager.registerEvents(new OnClick(), this);
		this.getCommand("Potion").setExecutor(new Potion());
		this.getCommand("Strength").setExecutor(new Strength());
		this.getCommand("Speed").setExecutor(new Speed());
		this.getCommand("FireRes").setExecutor(new FireRes());
		this.getCommand("Haste").setExecutor(new Haste());
		this.getCommand("NightVision").setExecutor(new NightVision());
		this.getCommand("WaterBreathing").setExecutor(new WaterBreathing());
		this.getCommand("Regen").setExecutor(new Regen());
		this.getCommand("JumpBoost").setExecutor(new JumpBoost());
		
		Main.config = new ConfigManager(this);
		
	}
	
	@Override	
	public void onDisable() {
		
	}
	
}