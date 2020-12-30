package com.tuershen.nbtlibrary.minecraft.item.difference;

import com.tuershen.nbtlibrary.minecraft.item.AbstractMinecraftItem;

public class Item_v1_7_R4 extends AbstractMinecraftItem {

    private static Item_v1_7_R4 item_v1_7_r4;

    public static void init(){
        try {
            item_v1_7_r4 = new Item_v1_7_R4();
            item_v1_7_r4.itemStackClass = Class.forName("net.minecraft.item.ItemStack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Item_v1_7_R4 getInstance(){
        return item_v1_7_r4;
    }

    @Override
    public Class<?> classItemStack() {
        return item_v1_7_r4.itemStackClass;
    }

}
