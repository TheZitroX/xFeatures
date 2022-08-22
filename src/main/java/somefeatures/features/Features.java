package somefeatures.features;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import somefeatures.features.commands.ParticleEffekt;
import somefeatures.features.listener.JoinListener;
import somefeatures.features.listener.QuitListener;
import somefeatures.features.smoke.SmokeType;
import somefeatures.features.smoke.UpdateParticleEffect;

import java.util.HashMap;
import java.util.Objects;

public final class Features extends JavaPlugin {
    public static Features instance;

    private static HashMap<Player, SmokeType> playerList;

    @Override
    public void onLoad() {
        instance = this;
        playerList = new HashMap<>();
    }

    @Override
    public void onEnable() {
        // particleeffekt
        try {
            Objects.requireNonNull(getCommand("setParticle")).setExecutor(new ParticleEffekt());
        } catch (Exception ignored) {
        }
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        new UpdateParticleEffect().runTaskTimer(
                this, 2, 2
        );
    }

    public static HashMap<Player, SmokeType> getPlayerList() {
        return playerList;
    }

    public static Features getInstance() {
        return instance;
    }
}
