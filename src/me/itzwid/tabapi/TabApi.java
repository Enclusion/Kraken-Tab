package me.itzwid.tabapi;

import com.alexandeh.kraken.Kraken;
import com.alexandeh.kraken.tab.PlayerTab;
import com.alexandeh.kraken.tab.event.PlayerTabCreateEvent;

import net.lightshard.practice.Practice;
import net.lightshard.practice.objects.entity.player.PlayerCache;
import net.lightshard.practice.objects.entity.player.PlayerCache.CachedDataType;
import net.lightshard.practice.objects.entity.player.state.StateSpectating;
import net.lightshard.practice.objects.game.category.CategoryManager;
import net.lightshard.practice.objects.game.category.FightCategory;
import net.lightshard.practice.objects.game.fight.DuelFight;
import net.lightshard.practice.objects.game.fight.FightManager;
import net.lightshard.practice.objects.stats.StatManager;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TabApi extends JavaPlugin implements Listener
{
  private static TabApi instance;
    
  public static TabApi getInstance()
  {
    if (instance == null)
    {
      instance = new TabApi();
    }
    return instance;
  }
  
  @Override
  public void onEnable() 
  {
    instance = this;
    
    setupFiles();
    
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    
    new Kraken(this);
    
    getConsoleCommandSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&d[iTabAPI] &aSuccessfully loaded iTabAPI version" + getDescription().getVersion() + "."));
  }
  
  @Override
  public void onDisable()
  {
    instance = null;
    
    getConsoleCommandSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[TabApi] Plugin disabled."));
  }
  
  private String getCardinalDirection(Player player) 
  {
    double rotation = (player.getLocation().getYaw() - 90) % 360;
    if (rotation < 0) 
    {
      rotation += 360.0;
    }
    if (0 <= rotation && rotation < 22.5) 
    {
      return "N";
    }
    else if (22.5 <= rotation && rotation < 67.5) 
    {
      return "NE";
    }
    else if (67.5 <= rotation && rotation < 112.5) 
    {
      return "E";
    }
    else if (112.5 <= rotation && rotation < 157.5) 
    {
      return "SE";
    }
    else if (157.5 <= rotation && rotation < 202.5) 
    {
      return "S"; 
    }
    else if (202.5 <= rotation && rotation < 247.5) 
    {
      return "SW";
    }
    else if (247.5 <= rotation && rotation < 292.5) 
    {
      return "W";
    }
    else if (292.5 <= rotation && rotation < 337.5)
    {
      return "NW";
    }
    else if (337.5 <= rotation && rotation < 360.0)
    {
      return "N";
    }
    else 
    {
      return null;
    }
  }
  
  private String translate(Player player, String path)
  {
    if (path.contains("%player_kills%"))
    {
      path = path.replace("%player_kills%", String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)));
    }
    
    if (path.contains("%player_deaths%"))
    {
      path = path.replace("%player_deaths%", String.valueOf(player.getStatistic(Statistic.DEATHS)));  
    }
    
    if (path.contains("%player_location%"))
    {
      path = path.replace("%player_location%", "(" + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockZ() + ") [" + getCardinalDirection(player) + "]");
    }
    
    if (path.contains("%online_players%"))
    {
      path = path.replace("%online_players%", String.valueOf(Bukkit.getServer().getOnlinePlayers().length));
    }
    
    if (path.contains("%player_ping%"))
    {
      path = path.replace("%player_ping%", String.valueOf(((CraftPlayer) player).getHandle().ping));
    }
    
    return path;
  }
  
  @EventHandler
  public void onPlayerTabCreateEvent(PlayerTabCreateEvent event) 
  {
    Player player = event.getPlayer();
    PlayerTab playerTab = event.getPlayerTab();
        playerTab.getByPosition(0, 0).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("1"))).send();        
        playerTab.getByPosition(0, 1).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("2"))).send();
        playerTab.getByPosition(0, 2).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("3"))).send();
        playerTab.getByPosition(0, 3).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("4"))).send();
        playerTab.getByPosition(0, 4).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("5"))).send();  
        playerTab.getByPosition(0, 5).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("6"))).send();
        playerTab.getByPosition(0, 6).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("7"))).send();
        playerTab.getByPosition(0, 7).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("8"))).send();
        playerTab.getByPosition(0, 8).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("9"))).send();
        playerTab.getByPosition(0, 9).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("10"))).send();
        playerTab.getByPosition(0, 10).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("11"))).send();
        playerTab.getByPosition(0, 11).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("12"))).send();
        playerTab.getByPosition(0, 12).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("13"))).send();
        playerTab.getByPosition(0, 13).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("14"))).send();
        playerTab.getByPosition(0, 14).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("15"))).send();
        playerTab.getByPosition(0, 15).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("16"))).send();
        playerTab.getByPosition(0, 16).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("17"))).send();
        playerTab.getByPosition(0, 17).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("18"))).send();
        playerTab.getByPosition(0, 18).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("19"))).send();
        playerTab.getByPosition(0, 19).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("20"))).send();        
        playerTab.getByPosition(1, 0).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("21"))).send();        
        playerTab.getByPosition(1, 1).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("22"))).send();
        playerTab.getByPosition(1, 2).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("23"))).send();
        playerTab.getByPosition(1, 3).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("24"))).send();
        playerTab.getByPosition(1, 4).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("25"))).send();  
        playerTab.getByPosition(1, 5).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("26"))).send();
        playerTab.getByPosition(1, 6).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("27"))).send();
        playerTab.getByPosition(1, 7).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("28"))).send();
        playerTab.getByPosition(1, 8).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("29"))).send();
        playerTab.getByPosition(1, 9).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("30"))).send();
        playerTab.getByPosition(1, 10).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("31"))).send();
        playerTab.getByPosition(1, 11).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("32"))).send();
        playerTab.getByPosition(1, 12).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("33"))).send();
        playerTab.getByPosition(1, 13).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("34"))).send();
        playerTab.getByPosition(1, 14).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("35"))).send();
        playerTab.getByPosition(1, 15).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("36"))).send();
        playerTab.getByPosition(1, 16).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("37"))).send();
        playerTab.getByPosition(1, 17).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("38"))).send();
        playerTab.getByPosition(1, 18).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("39"))).send();
        playerTab.getByPosition(1, 19).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("40"))).send(); 
        playerTab.getByPosition(2, 0).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("41"))).send();        
        playerTab.getByPosition(2, 1).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("42"))).send();
        playerTab.getByPosition(2, 2).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("43"))).send();
        playerTab.getByPosition(2, 3).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("44"))).send();
        playerTab.getByPosition(2, 4).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("45"))).send();  
        playerTab.getByPosition(2, 5).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("46"))).send();
        playerTab.getByPosition(2, 6).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("47"))).send();
        playerTab.getByPosition(2, 7).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("48"))).send();
        playerTab.getByPosition(2, 8).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("49"))).send();
        playerTab.getByPosition(2, 9).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("50"))).send();
        playerTab.getByPosition(2, 10).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("51"))).send();
        playerTab.getByPosition(2, 11).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("52"))).send();
        playerTab.getByPosition(2, 12).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("53"))).send();
        playerTab.getByPosition(2, 13).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("54"))).send();
        playerTab.getByPosition(2, 14).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("55"))).send();
        playerTab.getByPosition(2, 15).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("56"))).send();
        playerTab.getByPosition(2, 16).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("57"))).send();
        playerTab.getByPosition(2, 17).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("58"))).send();
        playerTab.getByPosition(2, 18).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("59"))).send();
        playerTab.getByPosition(2, 19).text(ChatColor.translateAlternateColorCodes('&', getConfig().getString("60"))).send(); 
}

  
  public ConsoleCommandSender getConsoleCommandSender()
  {
    return Bukkit.getServer().getConsoleSender();
  }
  
  public FileConfigurationOptions getFileConfigurationOptions()
  {
    return getConfig().options();
  }
  
  private void setupFiles()
  {
    try
    {
      if (!getDataFolder().exists()) 
      {
        getDataFolder().mkdirs();
      }
      
      File file = new File(getDataFolder(), "config.yml");
      if (!file.exists())
      {
        getFileConfigurationOptions().copyDefaults(true);
        saveConfig();
        getConsoleCommandSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&d[iTabAPI] &eCould not find file &dconfig.yml&e, the plugin will create the file automatically."));
      }
      else
      {
        getConsoleCommandSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&d[iTabAPI] &eThe file has been &ddetected, &eloading configuration."));
      }
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }
}