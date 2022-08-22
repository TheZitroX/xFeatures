package somefeatures.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import somefeatures.features.Features;

public class QuitListener implements Listener {
    @EventHandler
    private void onQuit(PlayerQuitEvent e) {
        Features.getPlayerList().remove(e.getPlayer());
        Bukkit.getConsoleSender().sendMessage("Removed: " + e.getPlayer().getName() + " Size: " + Features.getPlayerList().size());
    }
}
