package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagDouble extends TagNumber implements Serializable {

    private static final long serialVersionUID = -2756051522700197105L;

    private double data;

    public TagDouble(double data){
        this.data = data;
    }

    public TagDouble(){}

    public double getData() {
        return data;
    }

    @TagAnnotation( tagType = "double" )
    public void setData(double data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagDouble{data=" + data + "}";
    }

    @Override
    public long getLong() {
        return (long)this.data;
    }

    @Override
    public int getInt() {
        return floor(this.data);
    }

    @Override
    public short getShort() {
        return (short)(floor(this.data) & 0xFFFF);
    }

    @Override
    public byte getByte() {
        return (byte)(floor(this.data) & 0xFF);
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
        return 6;
    }
}
