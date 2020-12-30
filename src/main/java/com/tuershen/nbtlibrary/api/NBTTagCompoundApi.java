package com.tuershen.nbtlibrary.api;

import com.tuershen.nbtlibrary.minecraft.nbt.TagBase;
import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;

public interface NBTTagCompoundApi {


    /**
     * 根据键获取String值
     * @param key 键
     * @return String
     */
    String getString(String key);


    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    boolean getBoolean(String key);


    /**
     * 根据键获取Byte值
     * @param key 键
     * @return Byte
     */
    byte getByte(String key);

    /**
     * 根据键获取Byte数组
     * @param key 键
     * @return Byte数组
     */
    byte[] getByteArray(String key);

    /**
     * 根据键获取Double值
     * @param key 键
     * @return Double
     */
    double getDouble(String key);

    /**
     * 根据键获取Float值
     * @param key 键
     * @return Float
     */
    float getFloat(String key);

    /**
     * 根据键获取Int值
     * @param key 键
     * @return Int
     */
    int getInt(String key);

    /**
     * 根据键获取Int数组
     * @param key 键
     * @return Int数组
     */
    int[] getIntArray(String key);

    /**
     * 获取当前复合标签的Api接口
     * @param key 键
     * @return NBTTagCompoundApi
     */
    <T extends TagBase> NBTTagCompoundApi getCompound(String key);

    /**
     * 根据键获取TagBase，
     * T可以是, TagInt,TagShort,TagString,TagCompound,TagList.......
     * @param key 键
     * @return TagBase
     */
    <T extends TagBase> T get(String key);

    /**
     * 是否存在该键
     * @param key 键名称
     * @return boolean
     */
    boolean hasKey(String key);

    /**
     * 添加String类型的NBT标签
     * @param key 键
     * @return boolean
     */
    void setString(String key, String value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setBoolean(String key, boolean value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setByte(String key, byte value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setByteArray(String key, byte[] value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setDouble(String key, double value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setFloat(String key, float value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setInt(String key, int value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setIntArray(String key, int[] value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setLong(String key, long value);

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    void setShort(String key, short value);

    /**
     *
     * @return
     */
    NBTTagCompoundApi newCompoundApi();

    /**
     * 根据键获取Boolean值
     * @param key 键
     * @return boolean
     */
    <T extends TagBase> void set(String key, T base);

    Object getNMSCompound();

    void newNBTTagCompound();

    TagCompound getNBTTagCompoundApi();

    void remove(String key);

    void setCompoundMap(TagCompound tagCompound);



}
