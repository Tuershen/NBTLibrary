package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagInt extends TagNumber implements Serializable {

    private static final long serialVersionUID = -2438855542076367613L;

    private int data;

    public TagInt(int data){
        this.data = data;
    }

    public TagInt(){}

    public int getData() {
        return data;
    }

    @TagAnnotation( tagType = "int")
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagInt{data=" + data + "}";
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
        return (short)(this.data & 0xFFFF);
    }

    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
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
        return 3;
    }
}
