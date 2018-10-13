package jab.spigot.testcase;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.ArrayList;

public class PlayerListener implements Listener {

  @EventHandler
  public void on(PlayerLoginEvent event) {
    createMap(event.getPlayer());
  }

  private void createMap(Player player) {
    // Create a new MapView.
    MapView mapView = Bukkit.createMap(player.getWorld());
    // Grab the default renderers, and get rid of it.
    for (MapRenderer mapRenderer : new ArrayList<>(mapView.getRenderers())) {
      if (mapRenderer != null) {
        mapView.removeRenderer(mapRenderer);
      }
    }
    // Add our renderer instead.
    mapView.addRenderer(new TestCaseMapRenderer());
    // Create a Map Item like we would normally for a empty one.
    ItemStack i = new ItemStack(Material.FILLED_MAP);
    MapMeta mapMeta = (MapMeta) i.getItemMeta();
    // The durability value is the ID linking to the MapView
    mapMeta.setMapId(mapView.getId());
    i.setItemMeta(mapMeta);
    player.getInventory().addItem(i);
  }
}
