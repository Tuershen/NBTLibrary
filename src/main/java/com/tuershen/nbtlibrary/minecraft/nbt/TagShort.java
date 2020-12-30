package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagShort extends TagNumber implements Serializable {

    private static final long serialVersionUID = 9064701882837284432L;

    private short data;

    public TagShort(short data){
        this.data = data;
    }

    public TagShort(){}

    public short getData() {
        return data;
    }

    @TagAnnotation( tagType = "short" )
    public void setData(short data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagShort{data=" + data + "}";
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
        return 2;
    }
}
