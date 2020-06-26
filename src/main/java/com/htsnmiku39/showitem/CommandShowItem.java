package com.htsnmiku39.showitem;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CommandShowItem implements ICommand {
    private final List aliases;
    protected String fullEntityName;
    protected Entity conjuredEntity;
    public CommandShowItem(){
        aliases = new ArrayList();
        aliases.add("conjure");
    }
    @Override
    public String getCommandName() {
        return "showitem";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "showitem";
    }

    @Override
    public List getCommandAliases() {

        return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] argString) {
        World world = sender.getEntityWorld();

        if (world.isRemote)
        {
//            System.out.println("Not processing on Client side");
        }
        else
        {
            EntityPlayer player = world.getPlayerEntityByName(sender.getCommandSenderName());
            ItemStack item = player.inventory.getCurrentItem();
            if (item==null){
                sender.addChatMessage(new ChatComponentText("\u8bf7\u4e0d\u8981\u5c55\u793a\u53f2\u8482\u592b\u7684\u53f3\u624b").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
                return;
            }
            IChatComponent msg = new ChatComponentText(player.getDisplayName());
            msg.appendSibling(new ChatComponentText(" \u5c55\u793a\u4e86\u624b\u4e2d\u7684\uff1a").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
            MinecraftServer.getServer().getConfigurationManager().sendChatMsg(msg.appendSibling(item.func_151000_E()));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
