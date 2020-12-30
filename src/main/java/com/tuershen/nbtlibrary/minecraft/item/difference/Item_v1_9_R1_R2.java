package com.tuershen.nbtlibrary.minecraft.item.difference;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class Item_v1_9_R1_R2 extends Item_v1_8_R1_R2_R3 {


    private static Item_v1_9_R1_R2 item_v1_9_r1_r2;

    public static void init(String version){
        try {
            item_v1_9_r1_r2 = new Item_v1_9_R1_R2();
            item_v1_9_r1_r2.itemStackClass = Class.forName("net.minecraft.server."+ version +".ItemStack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Item_v1_9_R1_R2 getInstance(){
        return item_v1_9_r1_r2;
    }

    @Override
    public Class<?> classItemStack() {
        return item_v1_9_r1_r2.itemStackClass;
    }



}
