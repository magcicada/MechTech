package com.brachy84.mechtech;

import com.brachy84.mechtech.client.Sounds;
import com.brachy84.mechtech.common.CommonProxy;
import com.brachy84.mechtech.common.cover.MTCoverBehaviors;
import com.brachy84.mechtech.common.machines.MTTileEntities;
import com.brachy84.mechtech.common.machines.multis.MetaTileEntityTeslaTower;
import com.brachy84.mechtech.network.NetworkHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MechTech.MODID, name = MechTech.NAME, version = MechTech.VERSION, dependencies = "required-after:gregtech;")
public class MechTech {
    public static final String MODID = "mechtech";
    public static final String NAME = "MechTech";
    public static final String VERSION = "1.0.0-alpha";

    public static final Logger logger = LogManager.getLogger("MechTech");
    @SidedProxy(modId = MODID, clientSide = "com.brachy84.mechtech.common.ClientProxy", serverSide = "com.brachy84.mechtech.common.CommonProxy")
    public static CommonProxy proxy;

    public static ResourceLocation loc(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        NetworkHandler.init();
        proxy.preLoad();
        Sounds.registerSounds();
        MTTileEntities.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MTCoverBehaviors.init();
        MetaTileEntityTeslaTower.initTorusBlocks();
    }

    public static String blockPosToString(BlockPos pos) {
        return "X: " + pos.getX() + ", Y: " + pos.getY() + ", Z: " + pos.getZ();
    }
}
