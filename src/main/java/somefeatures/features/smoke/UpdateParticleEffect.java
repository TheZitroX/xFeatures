package somefeatures.features.smoke;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import somefeatures.features.Features;

import java.util.ArrayList;

public class UpdateParticleEffect extends BukkitRunnable {
    @Override
    public void run() {
//        Bukkit.getServer().broadcastMessage("test");
        // update each player
        Features.getPlayerList().forEach((player, smokeType) -> {
            switch (smokeType) {
                case NONE: return;
                case GOLD:
                    ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    assert itemMeta != null;
                    itemMeta.setDisplayName("§5§lSpeedStar");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("§7§lItem from " + player.getName());
                    lore.add("");
                    itemMeta.setLore(lore);
                    itemStack.setItemMeta(itemMeta);
//                    if (player.getItemInHand().isSimilar(itemStack)) {
                        Particle.DustTransition dustTransition = new Particle.DustTransition(
                                Color.RED,
                                Color.fromRGB(212, 175, 55),
                                5.0f
                        );
                        player.getWorld().spawnParticle(
                            Particle.DUST_COLOR_TRANSITION,
                            player.getLocation(),
                            25,
                            dustTransition
                        );
//                        player.setVelocity(
//                            player.getVelocity().add(new Vector(0, 1, 0))
//                        );
//                    }
            }
        });
    }
}
