package me.kixstar.dungeons.dungeons;

import io.papermc.lib.PaperLib;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ChunkUtils {

    static CompletableFuture<List<Chunk>> getChunksForBounds(World world, int fromX, int fromZ, int toX, int toZ) {
        fromX = getChunkNumber(fromX);
        fromZ = getChunkNumber(fromZ);
        toX = getChunkNumber(toX);
        toZ = getChunkNumber(toZ);
        List<CompletableFuture<Chunk>> chunks = new ArrayList<>();
        for (int x = fromX; x <= toX; x++) {
            for (int z = fromZ; z <= toZ; z++) {
                chunks.add(PaperLib.getChunkAtAsync(world, x, z));
            }
        }
        CompletableFuture<Chunk>[] chunksArray = (CompletableFuture<Chunk>[]) chunks.toArray();
        return CompletableFuture.allOf(chunksArray).thenApply(ignored -> chunks.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }

    private static int getChunkNumber(float i) {
        return (int) Math.floor(i / 16);
    }

    static List<Block> findBlocksInChunks(List<Chunk> chunks, Material material) {
        return chunks.parallelStream()
                .map(chunk -> {
                    List<Block> hits = new ArrayList<>();
                    for (int y = 0; y < 256; y++) {
                        for (int x = chunk.getX(); x < chunk.getX() + 16; x++) {
                            for (int z = chunk.getX(); z < chunk.getX() + 16; z++) {
                                Block block = chunk.getBlock(x, y, z);
                                if (block.getType() == material) {
                                    hits.add(block);
                                }
                            }
                        }
                    }
                    return hits;
                })
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    static List<Block> replaceAllInChunks(List<Chunk> chunks, Material material, Block block) {
        return findBlocksInChunks(chunks, material).parallelStream().map(b -> {
            block.setType(block.getType());
            block.setBlockData(block.getBlockData());
            return block;
        }).collect(Collectors.toList());
    }

}
