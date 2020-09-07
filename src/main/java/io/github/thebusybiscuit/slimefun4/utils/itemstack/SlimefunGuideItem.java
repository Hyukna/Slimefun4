package io.github.thebusybiscuit.slimefun4.utils.itemstack;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.cscorelib2.chat.ChatColors;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.guide.CheatSheetSlimefunGuide;

/**
 * This is just a helper {@link ItemStack} class for the {@link SlimefunGuide} {@link ItemStack}.
 * 
 * @author TheBusyBiscuit
 * 
 * @see SlimefunGuide
 * @see SlimefunGuideImplementation
 *
 */
public class SlimefunGuideItem extends ItemStack {

    public SlimefunGuideItem(@Nonnull SlimefunGuideImplementation implementation, @Nonnull String name) {
        super(Material.ENCHANTED_BOOK);

        ItemMeta meta = getItemMeta();
        meta.setDisplayName(ChatColors.color(name));

        List<String> lore = new LinkedList<>();
        lore.add(implementation instanceof CheatSheetSlimefunGuide ? "&4&l只能由管理員打開" : "");
        lore.add(ChatColors.color("&e右鍵點擊 &8\u21E8 &7打開指南"));
        lore.add(ChatColors.color("&e蹲下+右鍵點擊 &8\u21E8 &7打開設置及資訊"));

        meta.setLore(lore);
        SlimefunPlugin.getItemTextureService().setTexture(meta, "SLIMEFUN_GUIDE");

        setItemMeta(meta);
    }

}
