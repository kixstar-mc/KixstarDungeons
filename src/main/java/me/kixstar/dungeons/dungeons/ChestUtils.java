package me.kixstar.dungeons.dungeons;

import org.bukkit.block.Chest;
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

    }

    /**
     * distributeItems distributes a list of items into random slots of a given inventory
     * @param inventory
     * @param items
     */
    static void distributeItems(Inventory inventory, List<ItemStack> items) {
        // get random number between 0-26
        random.nextInt(27);
    }

}
