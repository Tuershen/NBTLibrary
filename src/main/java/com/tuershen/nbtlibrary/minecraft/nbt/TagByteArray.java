package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;
import java.util.Arrays;

public class TagByteArray extends TagBase implements Serializable {

    private static final long serialVersionUID = -706221587191341580L;

    private byte[] data;

    public TagByteArray(byte[] data){
        this.data = data;
    }

    public TagByteArray(){

    }

    public byte[] getData() {
        return data;
    }

    @TagAnnotation( tagType = "byteArray" )
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagByteArray{data=" + Arrays.toString(data) + "}";
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 7;
    }
}
