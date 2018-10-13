package jab.spigot.testcase;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

public class TestCaseMapRenderer extends MapRenderer {

  TestCaseMapRenderer() {
    super(true);
  }

  @Override
  public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
    mapCanvas.drawText(24, 24, MinecraftFont.Font, "TestCase");
  }
}
