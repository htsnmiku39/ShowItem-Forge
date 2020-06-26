package com.htsnmiku39.showitem;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ShowItem.MODID, version = ShowItem.VERSION,acceptableRemoteVersions = "*")
public class ShowItem
{
    public static final String MODID = "showitem";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // register server commands
        event.registerServerCommand(new CommandShowItem());
    }
}
