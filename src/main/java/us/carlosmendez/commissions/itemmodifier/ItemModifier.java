package us.carlosmendez.commissions.itemmodifier;

import org.bukkit.plugin.java.JavaPlugin;
import us.carlosmendez.commissions.itemmodifier.commands.CmdSetLore;
import us.carlosmendez.commissions.itemmodifier.commands.CmdSetName;
import us.carlosmendez.commissions.itemmodifier.lang.Lang;

public class ItemModifier extends JavaPlugin {
    private static ItemModifier instance;

    @Override
    public void onEnable() {
        instance = this;

        registerConfig();
        registerLang();
        registerCommands();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static ItemModifier getInstance() {
        return instance;
    }

    private void registerCommands() {
        getCommand("setlore").setExecutor(new CmdSetLore());
        getCommand("setname").setExecutor(new CmdSetName());
    }

    private void registerConfig() {
        saveDefaultConfig();
    }

    private void registerLang() {
        Lang.setFileConfiguration(getConfig());

        for (Lang lang : Lang.values()) {
            if (!getConfig().isSet(lang.path)) {
                getConfig().set(lang.path, lang.def);
            }
        }

        saveConfig();
    }
}
