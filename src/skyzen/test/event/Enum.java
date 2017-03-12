package skyzen.test.event;

import org.bukkit.Material;

public enum Enum {

    COMPASS(Material.STONE_PICKAXE,"TEST",1);

    Material material;
    String name;
    int ammount;

    Enum(Material material,String name,int ammount){
        this.material = material;
        this.name = name;
        this.ammount = ammount;
    }

    public Material getMaterial(){
        return this.material;
    }

    public int getAmmount(){
        return this.ammount;
    }

    public String getName(){
        return this.name;
    }
}
