package skyzen.test.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemModifier{

    public static ItemStack setText(ItemStack item, String name, String... lore)
    {
        ItemMeta meta = (ItemMeta) item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack giveSkull(String pseudo)
    {
        ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) is.getItemMeta();
        meta.setOwner(pseudo);
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack setBookPages(String title, String author, String... pages)
    {
        ItemStack is = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) is.getItemMeta();
        meta.setPages(pages);
        meta.setTitle(title);
        meta.setAuthor(author);
        is.setItemMeta(meta);
        return is;
    }

    public static String getName(ItemStack item)
    {
        return item.getItemMeta().getDisplayName();
    }
}