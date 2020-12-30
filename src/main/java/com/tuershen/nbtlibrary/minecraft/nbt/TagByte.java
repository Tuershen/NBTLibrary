package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagByte extends TagNumber implements Serializable {

    private static final long serialVersionUID = -4834697848365801958L;

    private byte data;

    public TagByte(byte data){
        this.data = data;
    }

    public TagByte(){}

    public byte getData() {
        return data;
    }

    @TagAnnotation( tagType = "byte")
    public void setData(byte data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagByte{data=" + data + "}";
    }

    @Override
    public long getLong() {
        return this.data;
    }

    @Override
    public int getInt() {
        return this.data;
    }

    @Override
    public short getShort() {
        return this.data;
    }

    @Override
    public byte getByte() {
        return this.data;
    }

    @Override
    public double getDouble() {
        return this.data;
    }

    @Override
    public float getFloat() {
        return this.data;
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 1;
    }
}
