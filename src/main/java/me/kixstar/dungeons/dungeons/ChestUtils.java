package me.kixstar.dungeons.dungeons;

import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class ChestUtils {

    private static final Random random = new Random();
    /**
     * distributeItems distributes a list of items into different chests, randomly
     * @param chests
     * @param items
     */
    static void distributeItems(List<Chest> chests, List<ItemStack> items) {
        if (chests != null && items != null && !(items.isEmpty())) {
            for (Chest chest : chests) {
                List<ItemStack> itemStacks = null;
                for (int i = 0; i < random.nextInt(items.size()); i++) {
                    itemStacks.add(items.get(i));
                    items.remove(i);
                }
                distributeItems(chest.getInventory(), itemStacks);
            }
        } else {
            return;
        }
    }

    /**
     * distributeItems distributes a list of items into random slots of a given inventory
     * @param inventory
     * @param items
     */
    static void distributeItems(Inventory inventory, List<ItemStack> items) {
        if (inventory != null && items != null && !(items.isEmpty())) {
            for (ItemStack item : items) {
                int ramdomSlot = random.nextInt(27);
                if (inventory.getItem(ramdomSlot) != null) {
                    inventory.setItem(ramdomSlot, item);
                }
            }
        } else {
            return;
        }
    }
}
