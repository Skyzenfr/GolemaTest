package skyzen.test;

import org.bukkit.Material;

public enum Items {

    COMPASS(Material.COMPASS, "Compass_test", 1),
    CHEST(Material.CHEST, "Chest_test", 1);

    Material material;
    String name;
    int ammount;

    Items(Material material, String name, int ammount) {
        this.material = material;
        this.name = name;
        this.ammount = ammount;
    }

    public Material getMaterial() {
        return this.material;
    }

    public int getAmmount() {
        return this.ammount;
    }

    public String getName() {
        return this.name;
    }
}
