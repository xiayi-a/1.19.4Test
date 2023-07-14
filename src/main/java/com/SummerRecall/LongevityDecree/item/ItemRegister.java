package com.SummerRecall.LongevityDecree.item;

import com.SummerRecall.LongevityDecree.LongevityDecreeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LongevityDecreeMod.MODID);

    public static final RegistryObject<Item> ItemTest = ITEMS.register("test1", ItemTest::new);




}

