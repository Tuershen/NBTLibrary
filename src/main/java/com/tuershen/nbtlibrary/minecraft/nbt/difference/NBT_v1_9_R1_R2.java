package com.tuershen.nbtlibrary.minecraft.nbt.difference;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class NBT_v1_9_R1_R2 extends NBT_v1_8_R1_R2_R3 {

    private static NBT_v1_9_R1_R2 nbt_v1_9_r1_r2;

    public NBT_v1_9_R1_R2(String version) {
        super(version);
    }

    public static NBT_v1_9_R1_R2 getInstance(){
        return nbt_v1_9_r1_r2;
    }

    public static void init(String version) { nbt_v1_9_r1_r2 = new NBT_v1_9_R1_R2(version); }

}
