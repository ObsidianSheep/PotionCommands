package me.obby.PotionCommands.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.obby.PotionCommands.Main;

public class ConfigManager {

	private Main plugin;
	private FileConfiguration dataConfig = null;
	private File configFile = null;
	
	public ConfigManager(Main plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
		}
	
	public void reloadConfig() {
		if (this.configFile == null) {
			this.configFile = new File(this.plugin.getDataFolder(), "config.yml");
		}
		
		this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
		
		InputStream defaultStream = this.plugin.getResource("config.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataConfig.setDefaults(defaultConfig);
		}
	}
	
	public FileConfiguration getconfig() {
		if (this.dataConfig == null) {
			reloadConfig();
		}
		return this.dataConfig;
	}
	
	public void saveConfig() {
		if (this.dataConfig == null || this.configFile == null) {
			return;
		}
		try { 
			this.getconfig().save(this.configFile);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Cold not save file to " + this.configFile, e);
		}
		
	}
	
	public void saveDefaultConfig() {
		if (this.configFile == null) {
			this.configFile = new File(this.plugin.getDataFolder(), "config.yml");
		}
		if (!this.configFile.exists()) {
			this.plugin.saveResource("config.yml", false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
