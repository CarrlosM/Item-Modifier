package us.carlosmendez.commissions.itemmodifier.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.carlosmendez.commissions.itemmodifier.lang.Lang;
import us.carlosmendez.commissions.itemmodifier.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CmdSetLore implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Lang.ERR_NOT_PLAYER.toString());
            return true;
        }
        Player player = (Player) sender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (!player.hasPermission("itemmodifier.setlore")) {
            player.sendMessage(Lang.ERR_MISSING_PERM.toString());
            return true;
        }

        if (itemStack == null || itemStack.getType() == Material.AIR) {
            player.sendMessage(Lang.ERR_EMPTY_HANDED.toString());
            return true;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> newLore = null;

        if (args.length > 0) {
            String[] lines = StringUtils.join(args, " ").split("\\\\n");

            newLore = new ArrayList<>();
            for (String line : lines) {
                newLore.add(Util.colorize(line));
            }
        }

        itemMeta.setLore(newLore);
        itemStack.setItemMeta(itemMeta);
        player.updateInventory();
        player.sendMessage(newLore == null ? Lang.CMD_LORE_REMOVED.toString() : Lang.CMD_LORE_SET.toString());
        return true;
    }
}
