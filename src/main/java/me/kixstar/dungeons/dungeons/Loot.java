package me.kixstar.dungeons.dungeons;

import org.bukkit.inventory.ItemStack;

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

    public static List<ItemStack> generateLoot(LootConfiguration configuration) {
        return null;
    }
        //uses the probability of the item in the configfuration list to determine if it'll appear in the dungeon
        //splits the item lists into acceptable stack sizes
        //lootconfigs are for one item type each
}
