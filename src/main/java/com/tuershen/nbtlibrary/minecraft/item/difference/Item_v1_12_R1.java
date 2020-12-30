package com.tuershen.nbtlibrary.minecraft.item.difference;

import com.tuershen.nbtlibrary.minecraft.item.AbstractMinecraftItem;

public class Item_v1_12_R1 extends AbstractMinecraftItem {


    private static Item_v1_12_R1 item_v1_12_r1;

    public static void init(String version){
        try {
            item_v1_12_r1 = new Item_v1_12_R1();
            item_v1_12_r1.itemStackClass =  Class.forName("net.minecraft.server."+version+".ItemStack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Item_v1_12_R1 getInstance() {
        return item_v1_12_r1;
    }

    @Override
    public Class<?> classItemStack() {
        return item_v1_12_r1.itemStackClass;
    }

}
