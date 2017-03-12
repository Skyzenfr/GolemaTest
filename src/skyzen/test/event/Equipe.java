package skyzen.test.event;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Copié de mon plugin mini jeux
 */

public class Equipe
{
    private final ArrayList<Joueur> joueurs;
    private final String name, chatColor;
    private final Location spawn;
    private Equipe adv;

    public Equipe(String name, String chatColor, Location spawn)
    {
        this.joueurs = new ArrayList<>();
        this.name = name;
        this.chatColor = chatColor;
        this.spawn = spawn;
    }

    public void setAdv(Equipe adv)
    {
        this.adv = adv;
    }

    public final String getName()
    {
        return name;
    }

    public final String getChatColor()
    {
        return chatColor;
    }

    public final Location getSpawn()
    {
        return spawn;
    }

    public final ArrayList<Joueur> getJoueurs()
    {
        return joueurs;
    }

    public boolean containsJoueur(Joueur joueur)
    {
        return joueurs.contains(joueur);
    }

    public boolean containsPlayer(Player player)
    {
        for (Joueur j : joueurs)
            if (j.getPlayer() == player)
                return true;
        return false;
    }

    public int addJoueur(Joueur joueur)
    {
        if (joueurs.contains(joueur))
            return 0;
        if (adv.containsJoueur(joueur))
            adv.removeJoueur(joueur);
        joueurs.add(joueur);
        return 1;
    }

    public void removeJoueur(Joueur joueur)
    {
        if (!joueurs.contains(joueur))
            return;
        joueurs.remove(joueur);
    }
}
