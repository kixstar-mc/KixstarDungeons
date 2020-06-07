package me.kixstar.dungeons.dungeons;

import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChestUtils {

    private static final Random random = new Random();

    /**
     * distributeItems distributes a list of items into different chests, randomly
     *
     * @param chests
     * @param items
     */
    static void distributeItems(List<Chest> chests, List<ItemStack> items) {
        if (chests == null || items == null || items.isEmpty()) {
            return;
        }
        for (Chest chest : chests) {
            List<ItemStack> itemStacks = new ArrayList<>();
            for (int i = 0; i < random.nextInt(items.size()); i++) {
                itemStacks.add(items.get(i));
                items.remove(i);
            }
            distributeItems(chest.getInventory(), itemStacks);
        }
    }

    /**
     * distributeItems distributes a list of items into random slots of a given inventory
     *
     * @param inventory
     * @param items
     */
    static void distributeItems(Inventory inventory, List<ItemStack> items) {
        if (inventory == null || items == null || items.isEmpty()) {
            return;
        }
        for (ItemStack item : items) {
            int ramdomSlot = random.nextInt(27);
            while (inventory.getItem(ramdomSlot) != null) {
                ramdomSlot = random.nextInt(27);
            }
            inventory.setItem(ramdomSlot, item);
        }
    }
}
