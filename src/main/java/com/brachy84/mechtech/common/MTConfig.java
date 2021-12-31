package com.brachy84.mechtech.common;

import com.brachy84.mechtech.MechTech;
import net.minecraftforge.common.config.Config;

@Config(modid = MechTech.MODID)
public class MTConfig {

    public static ModularArmor modularArmor = new ModularArmor();
    public static TeslaTower teslaTower = new TeslaTower();

    public static class ModularArmor {
        public Modules modules = new Modules();

        @Config.Comment("Amount of module slots of the helmet")
        @Config.Name("Helmet slots")
        @Config.RequiresMcRestart
        @Config.RangeInt(min = 0, max = 12)
        public int helmetSlots = 3;

        @Config.Comment("Amount of module slots of the chest plate")
        @Config.Name("Chest plate slots")
        @Config.RequiresMcRestart
        @Config.RangeInt(min = 0, max = 12)
        public int chestPlateSlots = 5;

        @Config.Comment("Amount of module slots of the leggings")
        @Config.Name("Leggings slots")
        @Config.RequiresMcRestart
        @Config.RangeInt(min = 0, max = 12)
        public int leggingsSlots = 4;

        @Config.Comment("Amount of module slots of the boots")
        @Config.Name("Boots slots")
        @Config.RequiresMcRestart
        @Config.RangeInt(min = 0, max = 12)
        public int bootsSlot = 2;
    }

    public static class Modules {
        @Config.Name("Binocular zoom level (default: 5x zoom)")
        @Config.RangeDouble
        public double binocularZoom = 5;

        @Config.Name("Tesla Coil damage")
        @Config.RangeDouble
        public double teslaCoilDamage = 5;

        @Config.Name("Tesla Coil range (radius)")
        @Config.RangeDouble
        public double teslaCoilRange = 5;

        @Config.Name("Tesla Coil max entities damaged per second")
        @Config.RangeInt(min = 0)
        public int teslaCoilMaxEntitiesPerSecond = 5;

        @Config.Name("Tesla Coil damage energy ratio")
        @Config.Comment("Determine how much energy should be drawn per damage dealt. 0 will disable energy use")
        @Config.RangeDouble
        public double teslaCoilDamageEnergyRatio = 40;
    }

    public static class TeslaTower {

        @Config.Name("Lightning chance")
        @Config.Comment("Chance on each insertion to spawn a lightning")
        @Config.RangeDouble(min = 0, max = 1)
        public double lightningChance = 0.5;
    }
}