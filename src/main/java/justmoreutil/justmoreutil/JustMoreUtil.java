package justmoreutil.justmoreutil;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.ChatPaginator;

public final class JustMoreUtil extends JavaPlugin {

    private static JustMoreUtil instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommand("ping", new Ping());
        getLogger().info("JustMoreUtil Starting Up.");

    }

    private void registerCommand(String name, CommandExecutor executor) {
        PluginCommand command = getCommand(name);
        if (command != null) {
            command.setExecutor(executor);
        } else {
            getLogger().severe("Failed to register the '" + name + "' command.");
        }
    }

    public static JustMoreUtil getInstance() {
        return instance;
    }

    public static String returnName(){
        String titleLabel = ChatColor.RED + "[JustMoreUtil]: " + ChatColor.WHITE;
        return titleLabel;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
