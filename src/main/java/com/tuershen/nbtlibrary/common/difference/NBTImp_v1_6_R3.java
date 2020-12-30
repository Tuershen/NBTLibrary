package com.tuershen.nbtlibrary.common.difference;

import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.api.SerializableItemApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.nbt.TagBase;
import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;
import com.tuershen.nbtlibrary.minecraft.nbt.TagList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @auther Tuershen update Date on 2020/12/2
 */
public class NBTImp_v1_6_R3 extends AbstractNBTTagCompound {

    public static NBTImp_v1_6_R3 nbtImp_1_6_r3;

    public NBTImp_v1_6_R3(){}

    public NBTImp_v1_6_R3(Object nbtTagCompound){
       super(nbtTagCompound);
       if (nbtImp_1_6_r3 == null){
           nbtImp_1_6_r3 = this;
       }
    }

    public static NBTImp_v1_6_R3 getInstance(Object nbtTagCompound) {
        return new NBTImp_v1_6_R3(nbtTagCompound);
    }

    public static SerializableItemApi serializableItemApi() {
        if (nbtImp_1_6_r3 == null){
            nbtImp_1_6_r3 = new NBTImp_v1_6_R3();
        }
        return nbtImp_1_6_r3;
    }


    @Override public void newNBTTagCompound() { super.baseNewNBTTagCompound(); }

    @Override public TagList listCrossoverValue(Object nbtTagList) { return this.baseListCrossoverValue(nbtTagList, "field_74747_a"); }

    @Override public Map<String, Object> fieldMapConversion(Object nbtTagCompound) { return this.baseFieldMapConversion(nbtTagCompound, "field_74784_a"); }

    @Override public <T extends TagBase> void set(String key, T base) { this.baseSetTag(key, base, "func_74782_a"); }

    @Override public Object getNMSCompound() {
        return this.deserializeNBTTagCompound(this.getNBTTagCompoundApi());
    }

    @Override public <T extends TagBase> Object newNBTTagList(T tagBase) { return this.baseNewList(tagBase, "func_74742_a"); }

    @Override public <T extends TagBase> Object newNBTTagCompound(T tagBase) { return this.baseNewCompound(tagBase, "field_74784_a"); }

    @Override public TagCompound getNBTTagCompoundApi() { return this.compoundCrossoverValue(this.nbtTagCompound); }

    @Override public String getString(String key) {
        return this.getBase(key, "func_74779_i").toString();
    }

    @Override public boolean getBoolean(String key) {
        return (boolean)this.getBase(key, "func_74767_n");
    }

    @Override public byte getByte(String key) {
        return (byte)this.getBase(key, "func_74771_c");
    }

    @Override public byte[] getByteArray(String key) {
        return (byte[])this.getBase(key, "func_74770_j" );
    }

    @Override public double getDouble(String key) {
        return (double)this.getBase(key, "func_74769_h");
    }

    @Override public float getFloat(String key) {
        return (float)this.getBase(key, "func_74760_g");
    }

    @Override public int getInt(String key) {
        return (int)this.getBase(key, "func_74762_e");
    }

    @Override public int[] getIntArray(String key) {
        return (int[])this.getBase(key, "func_74759_k");
    }

    @Override public boolean hasKey(String key) {
        return (boolean)this.getBase(key, "func_74764_b");
    }

    @Override public void setString(String key, String value) { this.setBase(key, value, "func_74778_a", String.class); }

    @Override public void setBoolean(String key, boolean value) { this.setBase(key, value, "func_74757_a", boolean.class); }

    @Override public void setByte(String key, byte value) {
        this.setBase(key, value, "func_74774_a", byte.class);
    }

    @Override public void setByteArray(String key, byte[] value) { this.setBase(key, value, "func_74773_a", byte[].class); }

    @Override public void setDouble(String key, double value) { this.setBase(key, value, "func_74780_a", double.class); }

    @Override public void setFloat(String key, float value) {
        this.setBase(key, value, "func_74776_a", float.class);
    }

    @Override public void setInt(String key, int value) {
        this.setBase(key, value, "func_74768_a", int.class);
    }

    @Override public void setIntArray(String key, int[] value) { this.setBase(key, value, "func_74783_a", int[].class); }

    @Override public void setLong(String key, long value) {
        this.setBase(key, value, "func_74772_a", long.class);
    }

    @Override public void setShort(String key, short value) {
        this.setBase(key, value, "func_74777_a", short.class);
    }

    @Override
    public NBTTagCompoundApi getCompound(String key) {
        try {
            Method method = this.nbtTagCompound.getClass().getDeclaredMethod("func_74775_l", String.class);
            Object obj = method.invoke(this.nbtTagCompound, key);
            return new NBTImp_v1_6_R3(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * func_74781_a = getTag
     * 原文：gets a generic tag with the specified name
     * 相当于getTag
     * @param key 键
     * @param <T> TagBase
     * @return TagBase
     */
    @Override
    public <T extends TagBase> T get(String key) {
        Object tagObj = getBase(key,"func_74781_a");
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
        return new NBTImp_v1_6_R3(obj);
    }





    @Override
    public void remove(String key) {
        baseRemove(key, "func_82580_o");
    }

    @Override
    public void setCompoundMap(TagCompound tagCompound) {
        super.baseSetCompoundMap(tagCompound);
    }


    @Override
    public String setMethodType(Class<?> nbtClass) {
        switch (nbtClass.getSimpleName()) {
            case "TagByte":
                return "func_74774_a";
            case "TagByteArray":
                return "func_74773_a";
            case "TagDouble":
                return "func_74780_a";
            case "TagFloat":
                return "func_74776_a";
            case "TagInt":
                return "func_74768_a";
            case "TagIntArray":
                return "func_74783_a";
            case "TagLong":
                return "func_74772_a";
            case "TagShort":
                return "func_74777_a";
            case "TagString":
                return "func_74778_a";
            case "TagCompound":
            case "TagList":
                return "func_74782_a";
        }
        return null;
    }

    @Override
    public TagBase fieldValueConversion(String type, Object obj) {
        switch (type) {
            case "byte":
                return dataCrossoverValue("field_74756_a", obj);
            case "short":
                return dataCrossoverValue("field_74752_a", obj);
            case "int":
                return dataCrossoverValue("field_74748_a", obj);
            case "long":
                return dataCrossoverValue("field_74753_a", obj);
            case "float":
                return dataCrossoverValue("field_74750_a", obj);
            case "double":
                return dataCrossoverValue("field_74755_a", obj);
            case "byteArray":
                return dataCrossoverValue("field_74754_a", obj);
            case "string":
                return dataCrossoverValue("field_74751_a", obj);
            case "intArray":
                return dataCrossoverValue("field_74749_a", obj);
            case "list":
                return listCrossoverValue(obj);
            case "nbtTagCompound":
                return compoundCrossoverValue(obj);
        }
        return null;
    }

    /**

     * @param tagBase
     * @return
     */
    protected Object newInstance_NBTBase(TagBase tagBase) {
        switch (tagBase.getClass().getSimpleName()) {
            case "TagByte":
            case "TagByteArray":
            case "TagDouble":
            case "TagFloat":
            case "TagInt":
            case "TagIntArray":
            case "TagLong":
            case "TagShort":
            case "TagString":
            case "TagLongArray":
                String type = tagBase.getClass().getSimpleName();
                Class<?> tagClass = minecraftNBTTag.getNBTTagClass(tagBase.getTypeId());
                try {
                    Constructor<?> constructor = tagClass.getConstructor(String.class, nmsFactory.get(type));
                    constructor.setAccessible(true);
                    return minecraftNBTTag.getNBTTagClass((byte)-1).cast(constructor.newInstance(String.valueOf(tagBase.data()), tagBase.data()));
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            case "TagCompound":
                return deserializeNBTTagCompound((TagCompound) tagBase);
            case "TagList":
                return assemblingTagList(((TagList)tagBase).getData());
        }
        return null;
    }

    @Override
    public Object assemblingTagList(List<TagBase> list) {
        return this.baseAssemblingTagList(list, "func_74742_a");
    }

}
