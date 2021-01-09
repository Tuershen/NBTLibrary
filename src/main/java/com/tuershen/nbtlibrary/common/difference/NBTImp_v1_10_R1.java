package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.SerializableInventory;
import com.tuershen.nbtlibrary.api.SerializableItemApi;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class NBTImp_v1_10_R1 extends NBTImp_v1_9_R1_R2 {

    private static NBTImp_v1_10_R1 nbtImp_v_1_10_r1;

    public NBTImp_v1_10_R1(){}

    public NBTImp_v1_10_R1(Object nbtTagCompound){
        super(nbtTagCompound);
        if (nbtImp_v_1_10_r1 == null){
            nbtImp_v_1_10_r1 = this;
        }
    }

    public static NBTImp_v1_10_R1 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_10_R1(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_v_1_10_r1 == null){
            nbtImp_v_1_10_r1 = new NBTImp_v1_10_R1();
        }
        return nbtImp_v_1_10_r1;
    }

    public static SerializableInventory getSerializableInventory() {
        if (nbtImp_v_1_10_r1 == null){
            nbtImp_v_1_10_r1 = new NBTImp_v1_10_R1();
        }
        return nbtImp_v_1_10_r1;
    }


}
