package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;

public class TagFloat extends TagNumber implements Serializable {

    private static final long serialVersionUID = 858057592032243870L;

    private float data;

    public TagFloat(float data){
        this.data = data;
    }

    public TagFloat(){}

    public float getData() {
        return data;
    }

    @TagAnnotation( tagType = "float" )
    public void setData(float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagFloat{data=" + data + "}";
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
        return this.data;
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 5;
    }
}
