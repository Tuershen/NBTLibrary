package com.tuershen.nbtlibrary.minecraft.item.difference;

import com.tuershen.nbtlibrary.minecraft.item.AbstractMinecraftItem;

/**
 * @auther Tuershen update Date on 2020/11/28
 */
public class Item_v1_6_R3 extends AbstractMinecraftItem {

    private static Item_v1_6_R3 item_v1_6_r3;

    public static void init(){
        try {
            item_v1_6_r3 = new Item_v1_6_R3();
            item_v1_6_r3.itemStackClass = Class.forName("net.minecraft.item.ItemStack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Item_v1_6_R3 getInstance(){
        return item_v1_6_r3;
    }

    @Override
    public Class<?> classItemStack() {
        return item_v1_6_r3.itemStackClass;
    }

}
