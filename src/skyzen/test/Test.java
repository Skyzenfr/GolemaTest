package skyzen.test;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import skyzen.test.event.PlayerListener;
import skyzen.test.kits.KitsSelector;

public class Test extends JavaPlugin {
    public static Test instance;
    private final PluginManager pm = getServer().getPluginManager();

    public void onEnable() {
        pm.registerEvents(new PlayerListener(this), this);
        pm.registerEvents(new KitsSelector(this), this);

        getLogger().info("===================================");
        getLogger().info("");
        getLogger().info(getDescription().getName());
        getLogger().info("Version " + getDescription().getVersion());
        getLogger().info("");
        getLogger().info("Activated");
        getLogger().info("===================================");
    }

    public void onDisable() {
        getLogger().info("===================================");
        getLogger().info("");
        getLogger().info(getDescription().getName());
        getLogger().info("Version " + getDescription().getVersion());
        getLogger().info("");
        getLogger().info("Disabled");
        getLogger().info("===================================");
    }
}
