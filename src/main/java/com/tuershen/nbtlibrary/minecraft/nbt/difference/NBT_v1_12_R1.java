package com.tuershen.nbtlibrary.minecraft.nbt.difference;

/**
 * @auther Tuershen update Date on 2020/11/13
 * 版本 1.12.R1
 */
public class NBT_v1_12_R1 extends NBT_v1_7_R1_R2_R3 {

    private static NBT_v1_12_R1 nbt_v1_12_r1;

    public NBT_v1_12_R1(String version) {
        super(version);
        try {
            super.nbtMapClass.put( (byte)12, Class.forName("net.minecraft.server."+ version +".NBTTagLongArray"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static NBT_v1_12_R1 getInstance(){
        return nbt_v1_12_r1;
    }

    public static void init(String version) { nbt_v1_12_r1 = new NBT_v1_12_R1(version); }

}
