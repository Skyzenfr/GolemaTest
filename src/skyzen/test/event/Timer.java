package skyzen.test.event;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import skyzen.test.Test;
import sun.applet.Main;

/**
 * Copié de mon plugin mini jeux
 */

public class Timer implements Runnable
{

    private final int taskID;
    private int timeleft = 60;

    public Timer()
    {
        this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Test.instance, this, 0L, 20L);
    }

    @Override
    public void run()
    {
        for (Player p : Bukkit.getOnlinePlayers())
            p.setLevel(timeleft);
        if (timeleft == 0)
        {
            Bukkit.getScheduler().cancelTask(taskID);
            //Start Main.instance.start();
        } else
        {
            if (timeleft == 60 || timeleft == 30 || timeleft == 10)
                for (Player p : Bukkit.getOnlinePlayers())
                    p.sendMessage("§7[§dBowDragon§7] §eLa partie commence dans §6" + timeleft + " secondes");
            else if (timeleft < 6)
                for (Player p : Bukkit.getOnlinePlayers())
                    p.sendMessage("§7Début dans: " + ((timeleft == 1) ? " seconde" : " secondes"));
        }
        timeleft--;
    }

    public void cancel()
    {
        for (Player p : Bukkit.getOnlinePlayers())
        {
            p.setLevel(60);
            p.sendMessage("La partie a été annulé: pas assez de joueur");
        }
        Bukkit.getScheduler().cancelTask(taskID);
    }
}