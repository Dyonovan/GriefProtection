package com.dyonovan.griefprotection.event;

import com.dyonovan.griefprotection.handlers.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class RightClickEvent {

    @SubscribeEvent
    public void playerRightClick(PlayerInteractEvent event) {

        if (event.isCanceled() || event.world.isRemote ||
                event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) return;

        ItemStack heldItem = event.entityPlayer.inventory.getCurrentItem();
        if (heldItem == null) return;

        if(heldItem.getUnlocalizedName().equals(ConfigHandler.tool)) {
            //event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation("msg.test.txt"));
        }
    }
}
