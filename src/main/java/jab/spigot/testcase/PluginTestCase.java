package jab.spigot.testcase;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginTestCase extends JavaPlugin {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new PlayerListener(), this);
  }

  @Override
  public void onDisable() {}
}
