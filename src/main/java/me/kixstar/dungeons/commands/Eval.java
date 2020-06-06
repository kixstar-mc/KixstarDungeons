package me.kixstar.dungeons.commands;

import me.kixstar.dungeons.KixstarDungeons;
import me.kixstar.dungeons.dungeons.ChunkUtils;
import me.kixstar.dungeons.portals.KixstarPortal;
import org.apache.commons.jexl3.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Eval implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression expression = engine.createExpression(String.join(" ", args));
        JexlContext context = new MapContext();
        context.set("sender", sender);
        context.set("command", command);
        context.set("server", sender.getServer());
        context.set("plugin", KixstarDungeons.getInstance());
        context.set("chunkutils", ChunkUtils.class);
        try {
            Object result = expression.evaluate(context);
            if (result != null) {
                if (result instanceof Collection<?>) {
                    ((Collection<?>) result).forEach(i -> sender.sendMessage(String.valueOf(i)));
                } else {
                    String str = String.valueOf(result);
                    sender.sendMessage(str);
                }
            }
            return true;
        } catch (JexlException ex) {
            sender.sendMessage(String.format("Error trying to evaluate that command: %s", ex));
            return false;
        }
    }

}
