package skyzen.test.team;

import org.bukkit.entity.Player;

/**
 * Copié de mon plugin mini jeux
 */

public class Joueur {

    private final Player p;

    public Joueur(Player p) {
        this.p = p;
    }

    public final Player getPlayer() {
        return p;
    }

}