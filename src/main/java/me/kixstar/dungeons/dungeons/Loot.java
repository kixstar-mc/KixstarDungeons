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

}
