package io.github.thebusybiscuit.slimefun4.implementation.guide;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.SlimefunGuideItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

/**
 * This is an admin-variant of the {@link ChestSlimefunGuide} which allows a {@link Player}
 * to spawn in a {@link SlimefunItem} via click rather than showing their {@link Recipe}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class CheatSheetSlimefunGuide extends ChestSlimefunGuide {

    private final ItemStack item;

    public CheatSheetSlimefunGuide() {
        super(false);

        item = new SlimefunGuideItem(this, "&cSlimefun指南 &4(作弊介面)");
    }

    @Override
    public boolean isSurvivalMode() {
        return false;
    }

    @Override
    public SlimefunGuideLayout getLayout() {
        return SlimefunGuideLayout.CHEAT_SHEET;
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    protected void createHeader(Player p, PlayerProfile profile, ChestMenu menu) {
        super.createHeader(p, profile, menu);

        // Remove Settings Panel
        menu.addItem(1, ChestMenuUtils.getBackground());
        menu.addMenuClickHandler(1, ChestMenuUtils.getEmptyClickHandler());
    }
}
