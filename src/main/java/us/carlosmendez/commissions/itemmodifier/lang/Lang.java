package us.carlosmendez.commissions.itemmodifier.lang;

import org.apache.commons.lang.WordUtils;
import org.bukkit.configuration.file.FileConfiguration;
import us.carlosmendez.commissions.itemmodifier.util.Util;

public enum Lang {
    ERR_EMPTY_HANDED("You must be holding an item in your hand to do this"),
    ERR_MISSING_PERM("You don't have permission to use this command"),
    ERR_NOT_PLAYER("You must be a player to do this!"),

    CMD_LORE_REMOVED("Your item's lore has been removed!"),
    CMD_LORE_SET("Your item's lore has been changed!"),

    CMD_NAME_REMOVED("Your item's name has been removed"),
    CMD_NAME_SET("Your item has been renamed to {1}"),

    PREFIX("&e&lItem Modifier &8\u00BB &7");

    public String def;
    public String path;
    private static FileConfiguration fileConfiguration;

    Lang(String def) {
        this.def = def;
        this.path = WordUtils.capitalizeFully("Messages." + this.name().replace("_", "-"));
    }

    public static void setFileConfiguration(FileConfiguration fileConfiguration) {
        Lang.fileConfiguration = fileConfiguration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this != PREFIX) {
            stringBuilder.append(PREFIX.toString());
        }

        stringBuilder.append(fileConfiguration.getString(path, def));

        return Util.colorize(stringBuilder.toString());
    }

    public String toString(Object... objects) {
        String message = toString();
        int counter = 1;

        for (Object object : objects) {
            if (object instanceof String) {
                message = message.replace("{" + counter++ + "}", (String) object);
                continue;
            }

            if (object instanceof Double) {
                message = message.replace("{" + counter++ + "}", Double.toString((Double) object));
            }
        }

        return message;
    }
}