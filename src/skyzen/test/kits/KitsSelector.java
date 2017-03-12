package skyzen.test.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import skyzen.test.Test;
import skyzen.test.utils.ItemModifier;

public class KitsSelector implements Listener {

    private final Test plugin;

    public KitsSelector(Test main) {
        this.plugin = main;
    }

    @EventHandler
    public void onClickTank(InventoryClickEvent e) {
        if (!e.getInventory().getTitle().equalsIgnoreCase("Sélecteur de Kits")) return;
        if (e.getCurrentItem().getType() == null) return;
        if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {

            final ItemStack casque = new ItemStack(Material.CHAINMAIL_HELMET, 1);
            final ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
            final ItemStack legging = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
            final ItemStack boot = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
            final PlayerInventory inv = e.getWhoClicked().getInventory();

            inv.clear();
            inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
            inv.setItem(1, new ItemStack(Material.BOW));
            inv.setItem(24, new ItemStack(Material.ARROW));
            inv.setHelmet(casque);
            inv.setChestplate(chestplate);
            inv.setLeggings(legging);
            inv.setBoots(boot);

            e.getWhoClicked().sendMessage("§7[§eKits§7] §eVous avez choisi le Kit: §bTank");
            e.getWhoClicked().closeInventory();
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClickArrow(InventoryClickEvent e) {
        if (!e.getInventory().getTitle().equalsIgnoreCase("Sélecteur de Kits")) return;
        if (e.getCurrentItem().getType() == null) return;
        if (e.getCurrentItem().getType() == Material.ARROW) e.getWhoClicked().closeInventory();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) || e.getItem() == null) return;
        if (e.getItem().getType() == Material.COMPASS) {
            final Inventory inv = Bukkit.createInventory(e.getPlayer(), 36, "Sélecteur de Kits");

            //première ligne
            inv.setItem(11, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));
            inv.setItem(12, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));
            inv.setItem(13, ItemModifier.setText(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1), "§b§nTank", "", "§7test"));
            inv.setItem(14, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));
            inv.setItem(15, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));

            //deuxième ligne
            inv.setItem(21, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));
            inv.setItem(22, ItemModifier.setText(new ItemStack(Material.WOOL, 1), "§b§nDéfenseur", "", "§7test"));
            inv.setItem(23, ItemModifier.setText(ItemModifier.giveSkull("MHF_Question"), "§cProchainement.."));

            //fermer l'inventaire
            inv.setItem(35, ItemModifier.setText(new ItemStack(Material.ARROW, 1), "§fFermer l'inventaire", ""));

            //ouvrir l'inventaire
            e.getPlayer().openInventory(inv);
        }
    }

}
