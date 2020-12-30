package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.api.SerializableItemApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.nbt.TagBase;
import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;
import com.tuershen.nbtlibrary.minecraft.nbt.TagList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @auther Tuershen update Date on 2020/12/2
 */
public class NBTImp_v1_7_R1_R2_R3 extends AbstractNBTTagCompound {

    private static NBTImp_v1_7_R1_R2_R3 nbtImp_1_7_r1_r2_r3;

    public NBTImp_v1_7_R1_R2_R3(){}

    public NBTImp_v1_7_R1_R2_R3(Object nbtTagCompound){
        super(nbtTagCompound);
        if (nbtImp_1_7_r1_r2_r3 == null){
            nbtImp_1_7_r1_r2_r3 = this;
        }
    }

    public static NBTImp_v1_7_R1_R2_R3 getInstance(Object nbtTagCompound){
        return new NBTImp_v1_7_R1_R2_R3(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi(){
        if (nbtImp_1_7_r1_r2_r3 == null){
            nbtImp_1_7_r1_r2_r3 = new NBTImp_v1_7_R1_R2_R3();
        }
        return nbtImp_1_7_r1_r2_r3;
    }


    @Override public TagList listCrossoverValue(Object nbtTagList) { return this.baseListCrossoverValue(nbtTagList, "list"); }

    @Override public Map<String, Object> fieldMapConversion(Object nbtTagCompound) { return this.baseFieldMapConversion(nbtTagCompound, "map"); }

     /**
     * 获取String类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public String getString(String key){
        return String.valueOf(this.getBase(key,"getString"));
    }

    /**
     * 获取Boolean类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public boolean getBoolean(String key){
        return (boolean)this.getBase(key,"getBoolean");
    }

    /**
     * 获取byte类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public byte getByte(String key){
        return (byte)this.getBase(key,"getByte");
    }

    /**
     * 获取byte[]类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public byte[] getByteArray(String key){
        return (byte[])this.getBase(key,"getByteArray");
    }

    /**
     * 获取Double类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public double getDouble(String key){
        return (double)this.getBase(key,"getDouble");
    }

    /**
     * 获取Float类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public float getFloat(String key){
        return (float)this.getBase(key,"getFloat");
    }

    /**
     * 获取int类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public int getInt(String key){
        return (int)this.getBase(key,"getInt");
    }

    /**
     * 获取int[]类型的NBT值
     * @param key 节点名称
     * @return value
     */
    @Override public int[] getIntArray(String key){
        return (int[])this.getBase(key,"getIntArray");
    }

    @Override public boolean hasKey(String key){
        return (boolean)this.getBase(key,"hasKey");
    }

    @Override public void setString(String key, String value){
        this.setBase(key,value,"setString",String.class);
    }

    @Override public void setBoolean(String key, boolean value){
        this.setBase(key,value,"setBoolean",boolean.class);
    }

    @Override public void setByte(String key, byte value){
        this.setBase(key,value,"setByte",byte.class);
    }

    @Override public void setByteArray(String key, byte[] value){ this.setBase(key,value,"setByteArray",byte[].class); }

    @Override public void setDouble(String key, double value){
        this.setBase(key,value,"setDouble",double.class);
    }

    @Override public void setFloat(String key, float value){
        this.setBase(key,value,"setFloat",float.class);
    }

    @Override public void setInt(String key, int value){
        this.setBase(key,value,"setInt",int.class);
    }

    @Override public void setIntArray(String key, int[] value){
        this.setBase(key,value,"intArray",int[].class);
    }

    @Override public void setLong(String key, long value){
        this.setBase(key,value,"setLong",long.class);
    }

    @Override public void setShort(String key, short value){
        this.setBase(key,value,"setShort",short.class);
    }

    @Override public <T extends TagBase> void set(String key, T base) { this.baseSetTag(key, base, "set"); }

    @Override public Object getNMSCompound() {
        return this.nbtTagCompound;
    }

    @Override public void newNBTTagCompound() { super.baseNewNBTTagCompound(); }

    @Override public TagCompound getNBTTagCompoundApi() {
        return this.compoundCrossoverValue(this.nbtTagCompound);
    }

    @Override public void remove(String key) { baseRemove(key, "remove"); }

    @Override public void setCompoundMap(TagCompound tagCompound) { super.baseSetCompoundMap(tagCompound); }

    @Override public <T extends TagBase> Object newNBTTagList(T tagBase) {
        return this.baseNewList(tagBase, "add");
    }

    @Override public <T extends TagBase> Object newNBTTagCompound(T tagBase) { return this.baseNewCompound(tagBase, "map"); }

    @Override public Object assemblingTagList(List<TagBase> list) { return this.baseAssemblingTagList(list, "add"); }

    @Override
    public NBTTagCompoundApi getCompound(String key) {
        try {
            Method method = this.nbtTagCompound.getClass().getDeclaredMethod("getCompound", String.class);
            Object obj = method.invoke(this.nbtTagCompound, key);
            return new NBTImp_v1_7_R1_R2_R3(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T extends TagBase> T get(String key) {
        Object tagObj = getBase(key,"get");
        String clazzType = NBTTypeEnum.getInstance(tagObj.getClass()).getType();
        return (T)fieldValueConversion(clazzType, tagObj);
    }


    @Override
    public NBTTagCompoundApi newCompoundApi() {
        Object obj = null;
        try {
            obj = minecraftNBTTag.getNBTTagClass((byte)10).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new NBTImp_v1_7_R1_R2_R3(obj);
    }

    @Override
    public String setMethodType(Class<?> nbtClass) {
        switch (nbtClass.getSimpleName()) {
            case "TagByte":
                return "setByte";
            case "TagByteArray":
                return "setByteArray";
            case "TagDouble":
                return "setDouble";
            case "TagFloat":
                return "setFloat";
            case "TagInt":
                return "setInt";
            case "TagIntArray":
                return "setIntArray";
            case "TagLong":
                return "setLong";
            case "TagShort":
                return "setShort";
            case "TagString":
                return "setString";
            case "TagCompound":
            case "TagList":
                return "set";
        }
        return null;
    }

    @Override
    public TagBase fieldValueConversion(String type, Object obj) {
        switch (type) {
            case "byte":
            case "short":
            case "int":
            case "long":
            case "float":
            case "double":
            case "byteArray":
            case "string":
            case "intArray":
                return dataCrossoverValue("data", obj);
            case "list":
                return listCrossoverValue(obj);
            case "nbtTagCompound":
                return compoundCrossoverValue(obj);
        }
        return null;
    }




}
