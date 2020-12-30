package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.SerializableItemApi;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class NBTImp_v1_11_R1 extends NBTImp_v1_7_R1_R2_R3 {

    private static NBTImp_v1_11_R1 nbtImp_1_11_r1;

    public NBTImp_v1_11_R1(){}

    public NBTImp_v1_11_R1(Object nbtTagCompound){
        super(nbtTagCompound);
        if (nbtImp_1_11_r1 == null){
            nbtImp_1_11_r1 = this;
        }
    }

    public static NBTImp_v1_11_R1 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_11_R1(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_1_11_r1 == null){
            nbtImp_1_11_r1 = new NBTImp_v1_11_R1();
        }
        return nbtImp_1_11_r1;
    }

}
