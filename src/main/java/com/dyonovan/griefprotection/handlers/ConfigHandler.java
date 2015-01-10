package com.dyonovan.griefprotection.handlers;

import com.dyonovan.griefprotection.lib.Constants;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;
    public static String tool, dbHost, dbName, dbUser, dbPass;
    public static int initialClaimBlocks, dbPort;
    public static boolean blockLogging;

    public static void init() {

        config = new Configuration(new File("config/GriefProtection/griefprotection.cfg"));
        config.load();

        tool = config.get(Constants.GENERAL_SETTINGS, "Grief Protection Tool", "item.shovelGold").getString();
        initialClaimBlocks = config.get(Constants.GENERAL_SETTINGS, "Initial Claim Blocks", 5000).getInt();
        blockLogging = config.get(Constants.GENERAL_SETTINGS, "Enable Block Logging?", false).getBoolean();

        dbHost = config.get(Constants.BLOCK_LOGGING, "Database Host", "127.0.0.1").getString();
        dbPort = config.get(Constants.BLOCK_LOGGING, "Database Port", 3306).getInt();
        dbName = config.get(Constants.BLOCK_LOGGING, "Database Name", "griefprotection").getString();
        dbUser = config.get(Constants.BLOCK_LOGGING, "Database User", "griefprotection").getString();
        dbPass = config.get(Constants.BLOCK_LOGGING, "Database Password", "password").getString();

        config.save();
    }
}
