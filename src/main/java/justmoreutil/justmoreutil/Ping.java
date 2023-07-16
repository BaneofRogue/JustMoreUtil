package justmoreutil.justmoreutil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Ping implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @Nullable String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(JustMoreUtil.returnName() + "Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args == null || args.length == 0) {
            int ping = player.getPing();
            sender.sendMessage(JustMoreUtil.returnName() + ChatColor.GREEN + "Your Ping: " + ping);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                int ping = target.getPing();
                sender.sendMessage(JustMoreUtil.returnName() + ChatColor.GREEN + target.getName() + " has a ping of: " + ping);
            } else {
                sender.sendMessage(JustMoreUtil.returnName() + "Invalid player name.");
            }
        } else {
            sender.sendMessage("Usage: /ping <player>(optional)");
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @Nullable String[] args) {
        return null;
    }
}