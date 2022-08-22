package somefeatures.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import somefeatures.features.Features;
import somefeatures.features.smoke.SmokeType;
public class JoinListener implements Listener {
    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Features.getPlayerList().put(e.getPlayer(), SmokeType.NONE);
        Bukkit.getConsoleSender().sendMessage("Added: " + e.getPlayer().getName() + " Size: " + Features.getPlayerList().size());
        Bukkit.getConsoleSender().sendMessage("Removed: " + e.getPlayer().getName());
    }
}
