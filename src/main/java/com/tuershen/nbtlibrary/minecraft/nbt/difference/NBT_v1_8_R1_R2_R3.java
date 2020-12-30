package com.tuershen.nbtlibrary.minecraft.nbt.difference;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class NBT_v1_8_R1_R2_R3 extends NBT_v1_7_R1_R2_R3 {

    private static NBT_v1_8_R1_R2_R3 nbt_v1_8_r1;

    public NBT_v1_8_R1_R2_R3(String version) {
        super(version);
    }

    public static NBT_v1_8_R1_R2_R3 getInstance(){
        return nbt_v1_8_r1;
    }

    public static void init(String version) { nbt_v1_8_r1 = new NBT_v1_8_R1_R2_R3(version); }

}
