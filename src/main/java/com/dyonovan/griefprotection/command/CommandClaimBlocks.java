package com.dyonovan.griefprotection.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandClaimBlocks extends CommandBase {

    @Override
    public String getCommandName() {
        return "claimblocks";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "Usage: /claimblocks <player> <add/remove> <amount>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) {

        if (args.length != 3 || !(args[1].equalsIgnoreCase("add") || args[1].equalsIgnoreCase("remove")))
            throw new WrongUsageException(getCommandUsage(iCommandSender), new Object[0]);
        else if (!checkLong(args[2]))
            throw new WrongUsageException("Not a valid number!", new Object[0]);
        else if (!checkUsername(args[0]))
            throw new PlayerNotFoundException();

        EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(args[0]);

        if (args[1].equalsIgnoreCase("add")) {
            player.getEntityData().setLong("ClaimBlocks",
                    player.getEntityData().getLong("ClaimBlocks") + Long.parseLong(args[2]));
            iCommandSender.addChatMessage(new ChatComponentText(
                    "Added " + args[2] + " giving the player a total of " +  player.getEntityData().getLong("ClaimBlocks")));
        } else if (args[1].equalsIgnoreCase("remove")) {
            if ((player.getEntityData().getLong("ClaimBlocks") - Long.parseLong(args[2])) < 0)
                throw new WrongUsageException("This would bring the players Claim Blocks below 0!", new Object[0]);
            else {
                player.getEntityData().setLong("ClaimBlocks",
                        player.getEntityData().getLong("ClaimBlocks") - Long.parseLong(args[2]));
                iCommandSender.addChatMessage(new ChatComponentText(
                        "Removed " + args[2] + " giving the player a total of " +  player.getEntityData().getLong("ClaimBlocks")));
            }
        }
    }

    private boolean checkUsername(String playerName) {

        for (String o: MinecraftServer.getServer().getAllUsernames()) {
            if (o.equalsIgnoreCase(playerName))
                return true;
        }
        return false;
    }

    private boolean checkLong(String num) {

        try {
            Long.parseLong(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }
}
