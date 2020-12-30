package com.tuershen.nbtlibrary.minecraft.nbt;


import java.io.Serializable;


public abstract class TagBase implements Serializable {

    //序列化版本id
    private static final long serialVersionUID  = 658655221344413188L;

    public abstract Object data();

    public abstract byte getTypeId();

    protected static String getNBTTag(byte typeByte) {
        switch (typeByte) {
            case 1:
                return "NBTTagByte";
            case 2:
                return "NBTTagShort";
            case 3:
                return "NBTTagInt";
            case 4:
                return "NBTTagLong";
            case 5:
                return "NBTTagFloat";
            case 6:
                return "NBTTagDouble";
            case 7:
                return "NBTTagByteArray";
            case 8:
                return "NBTTagString";
            case 9:
                return "NBTTagList";
            case 10:
                return "NBTTagCompound";
            case 11:
                return "NBTTagIntArray";
            case 12:
                return "NBTTagLongArray";
        }
        return null;
    }

}
