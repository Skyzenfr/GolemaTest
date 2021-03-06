package skyzen.test.event;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import skyzen.test.Test;
import skyzen.test.utils.ItemModifier;
import skyzen.test.utils.Title;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {

    private final Test main;

    public PlayerListener(Test main) {
        this.main = main;
    }

    @EventHandler
    public void JoinRunnable(PlayerJoinEvent e) {

        final Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        inv.setItem(0, ItemModifier.setText(new ItemStack(Material.COMPASS, 1), "§bSélecteur de Kits"));

        new Runnable() {
            final int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, this, 0L, 100L);

            @Override
            public void run() {
                if (!p.isOnline())
                    Bukkit.getScheduler().cancelTask(taskID);
                else {
                    switch (1 + (int) (Math.random() * 4)) {
                        case 1:
                            Title.sendActionBar(p, "§cLe serveur est cours de développement !");
                            break;
                        case 2:
                            Title.sendActionBar(p, "§e|§d|§6| §bBienvenue sur §eSmashs §6|§d|§e|");
                            break;
                        case 3:
                            Title.sendActionBar(p, "§7Le serveur est en §6Pre-Alpha §7!");
                            break;
                        case 4:
                            Title.sendActionBar(p, "§aBoutique: §ehttps://shop.smashs.fr/");
                            break;
                    }
                }
            }
        };
    }

    @EventHandler
    public void LevelChange(PlayerLevelChangeEvent e) {
        final Player p = e.getPlayer();
        Title.sendTitle(p, "", "§bBravo vous êtes passé au niveau: §a" + p.getLevel(), 20);
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
        final Player player = e.getPlayer();
        if (player.isOp()) {
            if (player.getGameMode() == GameMode.CREATIVE) return;
            if (player.getLocation().add(0, -1, 0).getBlock().getType() != Material.AIR || player.getLocation().add(0, -1.5, 0).getBlock().getType() != Material.AIR) {
                Vector direction = player.getLocation().getDirection();
                direction.setY(0.85);
                player.setVelocity(direction.multiply(1));
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                e.setCancelled(true);
            } else e.setCancelled(true);
        } else {
            e.setCancelled(true);
            e.getPlayer().setAllowFlight(false);
        }
    }

    @EventHandler
    public void onPlayerFall(PlayerMoveEvent e) {
        if (e.getTo().getBlockY() <= 25) {
            final Player p = e.getPlayer();
            p.teleport(new Location(Bukkit.getWorld("world"), 0, 0, 0, 0f, 0f));
            Title.sendTitle(p, "", "§cNe vous éloignez pas trop du lobby !", 20);
        }
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
        String msg = e.getMessage();
        String[] args = msg.split(" ");
        if ((args[0].equalsIgnoreCase("/pl")) || (args[0].equalsIgnoreCase("/plugins"))) {
            e.setCancelled(true);
        } else if (((args[0].equalsIgnoreCase("/help")) || (args[0].equalsIgnoreCase("/?")))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void Chat(AsyncPlayerChatEvent e) {
        String Msg = e.getMessage();
        Msg = Msg.replace("&", "§");
        final Player p = e.getPlayer();
        if (p.isOp()) {
            e.setFormat("§c[Administrateur] " + p.getDisplayName() + " §8➽ §f" + Msg);
        } else {
            e.setFormat("§7" + p.getDisplayName() + " §8➽ §f" + Msg);
        }
    }
}