package com.dyonovan.griefprotection.handlers;

import com.dyonovan.griefprotection.command.CommandClaimBlocks;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;

public class CommandHandler {

    public static void init() {

        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;

        manager.registerCommand((new CommandClaimBlocks()));
    }
}
