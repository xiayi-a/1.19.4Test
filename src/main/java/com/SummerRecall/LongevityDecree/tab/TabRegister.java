package com.SummerRecall.LongevityDecree.tab;

import com.SummerRecall.LongevityDecree.LongevityDecreeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TabRegister {
    public static CreativeModeTab TEST_TAB;

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register event) {
        TEST_TAB = event.registerCreativeModeTab(new ResourceLocation(LongevityDecreeMod.MODID,"tab1"), builder ->
                new TabTest().output(builder));
    }
}
