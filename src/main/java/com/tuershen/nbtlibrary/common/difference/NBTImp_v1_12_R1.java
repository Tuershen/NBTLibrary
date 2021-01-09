package com.tuershen.nbtlibrary.common.difference;


import com.tuershen.nbtlibrary.api.SerializableInventory;
import com.tuershen.nbtlibrary.api.SerializableItemApi;
import com.tuershen.nbtlibrary.minecraft.nbt.TagBase;

/**
 * @auther Tuershen update Date on 2020/12/2
 */
public class NBTImp_v1_12_R1 extends NBTImp_v1_7_R1_R2_R3 {

    private static NBTImp_v1_12_R1 nbtImp_1_12_r1;

    public NBTImp_v1_12_R1(){}

    public NBTImp_v1_12_R1(Object nbtTagCompound){
        super(nbtTagCompound);
        if (nbtImp_1_12_r1 == null){
            nbtImp_1_12_r1 = this;
        }
    }

    public static NBTImp_v1_12_R1 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_12_R1(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_1_12_r1 == null){
            nbtImp_1_12_r1 = new NBTImp_v1_12_R1();
        }
        return nbtImp_1_12_r1;
    }


    public static SerializableInventory getSerializableInventory() {
        if (nbtImp_1_12_r1 == null){
            nbtImp_1_12_r1 = new NBTImp_v1_12_R1();
        }
        return nbtImp_1_12_r1;
    }



    @Override
    public String setMethodType(Class<?> nbtClass) {
        switch (nbtClass.getSimpleName()) {
            case "TagByte":
                return "setByte";
            case "TagByteArray":
                return "setByteArray";
            case "TagDouble":
                return "setDouble";
            case "TagFloat":
                return "setFloat";
            case "TagInt":
                return "setInt";
            case "TagIntArray":
                return "setIntArray";
            case "TagLong":
                return "setLong";
            case "TagLongArray":
                return "setLongArray";
            case "TagShort":
                return "setShort";
            case "TagString":
                return "setString";
            case "TagCompound":
            case "TagList":
                return "set";
        }
        return null;
    }

    @Override
    public TagBase fieldValueConversion(String type, Object obj) {
        switch (type) {
            case "byte":
            case "short":
            case "int":
            case "long":
            case "float":
            case "double":
            case "byteArray":
            case "string":
            case "intArray":
                return dataCrossoverValue("data", obj);
            case "longArray":
                return dataCrossoverValue("b", obj);
            case "list":
                return listCrossoverValue(obj);
            case "nbtTagCompound":
                return compoundCrossoverValue(obj);
        }
        return null;
    }


}
