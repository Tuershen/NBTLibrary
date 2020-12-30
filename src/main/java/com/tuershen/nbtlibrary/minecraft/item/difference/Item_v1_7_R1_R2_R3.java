package com.tuershen.nbtlibrary.minecraft.item.difference;

import com.tuershen.nbtlibrary.minecraft.item.AbstractMinecraftItem;

public class Item_v1_7_R1_R2_R3 extends AbstractMinecraftItem {


    private static Item_v1_7_R1_R2_R3 item_v1_7_r1_r2_r3;

    public static void init(String version){
        try {
            item_v1_7_r1_r2_r3 = new Item_v1_7_R1_R2_R3();
            item_v1_7_r1_r2_r3.itemStackClass = Class.forName("net.minecraft.server."+ version +".ItemStack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Item_v1_7_R1_R2_R3 getInstance(){
        return item_v1_7_r1_r2_r3;
    }

    @Override
    public Class<?> classItemStack() {
        return item_v1_7_r1_r2_r3.itemStackClass;
    }

}
