package me.kixstar.dungeons.dungeons;

import org.bukkit.inventory.ItemStack;

public class LootConfiguration {

    private final ItemStack itemStack;
    private final int maxStackSize;
    private final float chance;

    public LootConfiguration(ItemStack itemStack, int maxStackSize, float chance) {
        this.itemStack = itemStack;
        this.maxStackSize = maxStackSize;
        this.chance = chance;
    }

    public LootConfiguration(ItemStack itemStack, float chance) {
        this.itemStack = itemStack;
        this.chance = chance;
        this.maxStackSize = (int)Math.ceil((float)itemStack.getAmount() / 4);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public float getChance() {
        return chance;
    }
}
