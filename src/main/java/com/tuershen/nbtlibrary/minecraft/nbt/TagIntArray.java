package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;
import java.util.Arrays;

public class TagIntArray extends TagBase implements Serializable {

    private static final long serialVersionUID = 8093291414514590195L;

    private int[] data;

    public TagIntArray(int[] data){
        this.data = data;
    }

    public TagIntArray(){}

    public int[] getData() {
        return data;
    }

    @TagAnnotation( tagType = "intArray")
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagIntArray{data=" + Arrays.toString(data) + "}";
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 11;
    }
}
