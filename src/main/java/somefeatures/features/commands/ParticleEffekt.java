package somefeatures.features.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import somefeatures.features.Features;
import somefeatures.features.smoke.SmokeType;

import java.util.HashMap;

public class ParticleEffekt implements CommandExecutor {
    final String PREFIX = "§8[§5ParticleEffekt§8]§r ";
    final String PARTICLE_TYPES = "<Particle> (none, gold)";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "§l§cOnly players can execute this commands!");
            return false;
        }

        Player player = (Player) sender;
        // self
        if (args.length == 1) {
            setPlayerParticle(args[0], player);
        // other player
        } else if (args.length == 2) {
            String USAGE = PREFIX + "Usage: /setParticle [Player] " + PARTICLE_TYPES;
            Player otherPlayer = Bukkit.getPlayer(args[0]);
            if (!Features.getPlayerList().containsKey(otherPlayer)) {
                player.sendMessage(PREFIX + ChatColor.RED + "Playername does not exist");
            } else {
                setPlayerParticle(args[1], otherPlayer);
                player.sendMessage(PREFIX + ChatColor.GRAY + otherPlayer.getName() +" is Set");
            }
        // any other number of params
        } else {
            sender.sendMessage(PREFIX + ChatColor.RED + "/setParticle [Player] " + PARTICLE_TYPES);
        }
        return false;
    }

    private void setPlayerParticle(String string, Player player) {
        String USAGE = PREFIX + "Usage: /setParticle " + PARTICLE_TYPES;
        HashMap<Player, SmokeType> playerList = Features.getPlayerList();
        switch (string.toLowerCase()) {
            case "none":
                if (playerList.get(player) == SmokeType.NONE) {
                    alreadySetSameMessage(player);
                } else {
                    playerList.put(player, SmokeType.NONE);
                    particleSetMessage(player, SmokeType.NONE);
                }
                break;

            case "gold":
                if (playerList.get(player) == SmokeType.GOLD) {
                    alreadySetSameMessage(player);
                } else {
                    playerList.put(player, SmokeType.GOLD);
                    particleSetMessage(player, SmokeType.GOLD);
                }
                break;

            default:
                player.sendMessage(ChatColor.RED + USAGE);
                break;
        }
    }


    // ===================================MESSAGES===================================
    private void particleSetMessage(Player player, SmokeType smokeType) {
        player.sendMessage(PREFIX + ChatColor.GRAY + smokeType.toString() + " is set");
    }

    private void alreadySetSameMessage(Player player) {
        player.sendMessage(PREFIX + ChatColor.RED + "Already Set");
    }
}
