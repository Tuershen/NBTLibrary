package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.SerializableInventory;
import com.tuershen.nbtlibrary.api.SerializableItemApi;

/**
 * @auther Tuershen update Date on 2020/12/2
 */
public class NBTImp_v1_7_R4 extends NBTImp_v1_7_R1_R2_R3 {

    private static NBTImp_v1_7_R4 nbtImp_1_7_r4;


    public NBTImp_v1_7_R4(){}

    public NBTImp_v1_7_R4(Object nbtTagCompound) {
        super(nbtTagCompound);
        if (nbtImp_1_7_r4 == null) {
            nbtImp_1_7_r4 = this;
        }
    }

    public static NBTImp_v1_7_R4 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_7_R4(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_1_7_r4 == null) {
            nbtImp_1_7_r4 = new NBTImp_v1_7_R4();
        }
        return nbtImp_1_7_r4;
    }

    public static SerializableInventory getSerializableInventory() {
        if (nbtImp_1_7_r4 == null){
            nbtImp_1_7_r4 = new NBTImp_v1_7_R4();
        }
        return nbtImp_1_7_r4;
    }




}
