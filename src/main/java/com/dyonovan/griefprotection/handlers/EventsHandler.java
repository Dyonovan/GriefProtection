package com.dyonovan.griefprotection.handlers;

import com.dyonovan.griefprotection.event.LoginEvent;
import com.dyonovan.griefprotection.event.RightClickEvent;
import net.minecraftforge.common.MinecraftForge;

public class EventsHandler {

    public static void init() {

        MinecraftForge.EVENT_BUS.register(new RightClickEvent());
        MinecraftForge.EVENT_BUS.register(new LoginEvent());

    }
}
