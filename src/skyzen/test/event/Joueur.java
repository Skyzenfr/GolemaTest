package skyzen.test.event;

import org.bukkit.entity.Player;

public class Joueur
{

    private final Player p;

    public Joueur(Player p)
    {
        this.p = p;
    }

    public final Player getPlayer()
    {
        return p;
    }

}