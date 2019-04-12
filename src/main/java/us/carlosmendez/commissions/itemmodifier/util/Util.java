package us.carlosmendez.commissions.itemmodifier.util;

import org.bukkit.ChatColor;
import us.carlosmendez.commissions.itemmodifier.ItemModifier;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Util {
    private static ItemModifier plugin = ItemModifier.getInstance();

    public static String colorize(String string) {
        for (ChatColor chatColor : ChatColor.values()) {
            Set<String> aliases = new HashSet<>(Collections.singletonList(chatColor.name()));

            if (plugin.getConfig().isSet("Aliases." + chatColor.name())) {
                aliases.addAll(plugin.getConfig().getStringList("Aliases." + chatColor.name()));
            }

            for (String alias : aliases) {
                string = string.replaceAll("(?i)\\*(" + alias + ")\\*", chatColor.toString());
            }
        }

        return ChatColor.translateAlternateColorCodes('&', string);
    }
}