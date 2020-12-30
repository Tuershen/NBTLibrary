package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagLong extends TagNumber implements Serializable {

    private static final long serialVersionUID = -1414668621766600673L;

    private long data;

    public TagLong(long data){
        this.data = data;
    }

    public TagLong(){}

    public long getData() {
        return data;
    }

    @TagAnnotation( tagType = "long")
    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagLong{data=" + data + "}";
    }


    @Override
    public long getLong() {
        return this.data;
    }

    @Override
    public int getInt() {
        return (int)(this.data & 0x7fffffffffffffffL);
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
        return (float) this.data;
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 4;
    }
}
