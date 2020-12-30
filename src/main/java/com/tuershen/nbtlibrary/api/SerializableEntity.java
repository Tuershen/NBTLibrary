package com.tuershen.nbtlibrary.api;

import org.bukkit.entity.Entity;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public interface SerializableEntity extends SerializableTag {



    /**
     * 序列化
     * @param data
     * @return
     */
    Entity deserializeEntity(String data);

    /**
     * 序列化实体，保存实体数据
     * @param paramItemStack
     * @return
     */
    String serializeEntity(Entity paramItemStack);





}
