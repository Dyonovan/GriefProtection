package com.dyonovan.griefprotection.event;

import com.dyonovan.griefprotection.handlers.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class LoginEvent {

    @SubscribeEvent
    public void onPlayerLogin(EntityJoinWorldEvent event) {

        //Assign initial amount of claim blocks
        if (event.entity instanceof EntityPlayer)
        if (!event.entity.getEntityData().hasKey("ClaimBlocks"))
            event.entity.getEntityData().setLong("ClaimBlocks", ConfigHandler.initialClaimBlocks);

    }
}
