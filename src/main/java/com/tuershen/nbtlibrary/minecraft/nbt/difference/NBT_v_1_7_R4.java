package com.tuershen.nbtlibrary.minecraft.nbt.difference;


/**
 * @auther Tuershen update Date on 2020/11/13
 * 版本1.7.R4
 * 1.7.R4与其他版本的1.7有所不同
 */
public class NBT_v_1_7_R4 extends NBT_v1_7_R1_R2_R3 {

    private static NBT_v_1_7_R4 nbt_v_1_7_r4;

    public NBT_v_1_7_R4(String version) {
        super(version);
    }

    public static void init(String version){
        nbt_v_1_7_r4 = new NBT_v_1_7_R4(version);
    }

    public static NBT_v_1_7_R4 getInstance(){
        return nbt_v_1_7_r4;
    }

}
