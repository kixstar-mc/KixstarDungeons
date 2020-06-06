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
    private static List<ItemStack> itemStacks;
    /**
     * distributeItems distributes a list of items into different chests, randomly
     * @param chests
     * @param items
     */
    static void distributeItems(List<Chest> chests, List<ItemStack> items) {
        if (chests != null && items != null && !(items.isEmpty())) {
            itemStacks = items;
            for (Chest chest : chests) {
                distributeItems(chest.getInventory(), items);
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
            for (int i = 1; i < random.nextInt(7); i++) {
                int randomInt = random.nextInt(items.size());
                int ramdomSlot = random.nextInt(27);
                if (inventory.getItem(ramdomSlot) != null) {
                    inventory.setItem(ramdomSlot, items.get(randomInt));
                    items.remove(randomInt);
                    itemStacks.remove(randomInt);
                } else {
                    i = i--;
                }
            }
        } else {
            return;
        }

    }
}
