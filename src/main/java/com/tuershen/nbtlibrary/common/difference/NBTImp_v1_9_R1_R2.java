package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.SerializableItemApi;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class NBTImp_v1_9_R1_R2 extends NBTImp_v1_8_R1_R2_R3 {


    private static NBTImp_v1_9_R1_R2 nbtImp_v1_9_r1_r2;

    public NBTImp_v1_9_R1_R2(){}

    public NBTImp_v1_9_R1_R2(Object nbtTagCompound){
        super(nbtTagCompound);
        if (nbtImp_v1_9_r1_r2 == null){
            nbtImp_v1_9_r1_r2 = this;
        }
    }

    public static NBTImp_v1_9_R1_R2 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_9_R1_R2(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_v1_9_r1_r2 == null){
            nbtImp_v1_9_r1_r2 = new NBTImp_v1_9_R1_R2();
        }
        return nbtImp_v1_9_r1_r2;
    }


}
