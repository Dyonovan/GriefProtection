package com.dyonovan.griefprotection;

import com.dyonovan.griefprotection.handlers.CommandHandler;
import com.dyonovan.griefprotection.handlers.ConfigHandler;
import com.dyonovan.griefprotection.handlers.MySQLHandler;
import com.dyonovan.griefprotection.lib.Constants;
import com.dyonovan.griefprotection.handlers.EventsHandler;
import com.dyonovan.griefprotection.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;

@Mod(name = Constants.MODNAME, modid = Constants.MODID, version = "@VERSION@", acceptableRemoteVersions = "*")

public class GriefProtection {

    @Instance(Constants.MODID)
    public static GriefProtection instance;

    @SidedProxy(clientSide = "com.dyonovan.griefprotection.proxy.ClientProxy",
            serverSide = "com.dyonovan.griefprotection.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

        CommandHandler.init();
    }

    @SideOnly(Side.SERVER)
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigHandler.init();
        EventsHandler.init();

        if (ConfigHandler.blockLogging) {
            MySQLHandler.connectDB();
        }

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
