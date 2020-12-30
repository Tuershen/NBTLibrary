package com.tuershen.nbtlibrary.api;

import com.tuershen.nbtlibrary.minecraft.nbt.TagBase;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public interface SerializableTag {

    /**
     * 序列化TagBase
     * @param t
     * @param <T> TagBase子类
     * @return String二进制源数据
     */
    <T extends TagBase> String getTagBaseByteStream(T t);

    /**
     * 反序列化
     * @param data 源数据
     * @param <T> TagBase子类
     * @return TagBase
     */
    <T extends TagBase> T deserializeTagBase(String data);


}
