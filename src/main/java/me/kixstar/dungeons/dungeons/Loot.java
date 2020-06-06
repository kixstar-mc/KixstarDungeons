package me.kixstar.dungeons.dungeons;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Loot {

    public static List<ItemStack> generateLoot(List<LootConfiguration> configurations) {
        return configurations.parallelStream()
                .map(Loot::generateLoot)
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    private static List<ItemStack> generateLoot(LootConfiguration configuration) {
        List<ItemStack> finalItemStackList = new ArrayList<>();

        if (Math.random() <= configuration.getChance()) {
            int itemAmount = configuration.getItemStack().getAmount();
            int itemsForStack;
            int maxStackSize = configuration.getMaxStackSize();

            while (itemAmount > 0) {
                if (itemAmount - maxStackSize >= 0)
                {
                    itemsForStack = maxStackSize;
                } else {
                    itemsForStack = itemAmount;
                }
                finalItemStackList.add(new ItemStack(configuration.getItemStack().getType(), itemsForStack));
				itemAmount -= maxStackSize;
            }
        }

        return finalItemStackList;

        //uses the probability of the item in the configuration list to determine if it'll appear in the dungeon
        //splits the item lists into acceptable stack sizes
        //lootconfigs are for one item type each
    }


}