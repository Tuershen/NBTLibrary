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

    public TagCompound toTagCompound(){
        if (this instanceof TagCompound) {
            return (TagCompound) this;
        }
        return new TagCompound();
    }

    public TagList toList(){
        if (this instanceof TagList) {
            return (TagList) this;
        }
        return new TagList();
    }

    public TagInt toTagInt(){
        if (this instanceof TagInt) {
            return (TagInt) this;
        }
        return new TagInt();
    }

    public TagByte toTagByte(){
        if (this instanceof TagByte) {
            return (TagByte) this;
        }
        return new TagByte();
    }

    public TagShort toTagShort(){
        if (this instanceof TagShort) {
            return (TagShort) this;
        }
        return new TagShort();
    }

    public TagString toTagString(){
        if (this instanceof TagString) {
            return (TagString) this;
        }
        return new TagString();
    }

    public TagLong toTagLong(){
        if (this instanceof TagLong) {
            return (TagLong) this;
        }
        return new TagLong();
    }


    public TagIntArray toTagIntArray(){
        if (this instanceof TagIntArray) {
            return (TagIntArray) this;
        }
        return new TagIntArray();
    }



    public TagByteArray toTagByteArray(){
        if (this instanceof TagByteArray) {
            return (TagByteArray) this;
        }
        return new TagByteArray();
    }


    public TagLongArray toTagLongArray(){
        if (this instanceof TagLongArray) {
            return (TagLongArray) this;
        }
        return new TagLongArray();
    }


    public TagDouble toTagDouble(){
        if (this instanceof TagDouble) {
            return (TagDouble) this;
        }
        return new TagDouble();
    }


    public TagFloat toTagFloat(){
        if (this instanceof TagFloat) {
            return (TagFloat) this;
        }
        return new TagFloat();
    }





}
