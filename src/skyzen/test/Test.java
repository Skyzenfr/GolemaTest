package skyzen.test;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import skyzen.test.event.PlayerListener;
import skyzen.test.kits.KitsSelector;

import java.util.ArrayList;

public class Test extends JavaPlugin{

    public static Test instance;
    private ArrayList<Listener> listeners;

    public void onEnable(){

        this.listeners = new ArrayList<>();

        /**
         * initialisation des listeners
         */
        listeners.add(new PlayerListener(this));
        listeners.add(new KitsSelector(this));

        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        getLogger().info("");
        getLogger().info(getDescription().getName());
        getLogger().info("Version " + getDescription().getVersion());
        getLogger().info("");
        getLogger().info("Activated");
        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void onDisable(){

        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        getLogger().info("");
        getLogger().info(getDescription().getName());
        getLogger().info("Version " + getDescription().getVersion());
        getLogger().info("");
        getLogger().info("Disabled");
        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

}
