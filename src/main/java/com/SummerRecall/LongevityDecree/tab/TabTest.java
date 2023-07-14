package com.SummerRecall.LongevityDecree.tab;

import com.SummerRecall.LongevityDecree.item.ItemRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;


public class TabTest {
    public CreativeModeTab output (CreativeModeTab.Builder builder) {
        return builder.title(Component.translatable("creative"))
                .icon(() -> new ItemStack(ItemRegister.ItemTest.get()))
                .displayItems((parameters, output) ->
                {
                    output.accept(ItemRegister.ItemTest.get());
                })
                .build();
    }
}
