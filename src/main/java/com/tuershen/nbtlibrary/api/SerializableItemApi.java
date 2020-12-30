package com.tuershen.nbtlibrary.api;


import org.bukkit.inventory.ItemStack;

public interface SerializableItemApi extends SerializableTag {

    /**
     * 反序列
     * @param paramString 源数据
     * @return bukkit -> ItemStack
     */
    ItemStack deserialize(String paramString);

    /**
     * 序列化
     * @param paramItemStack bukkit -> ItemStack
     * @return String二进制源数据
     */
    String serialize(ItemStack paramItemStack);




}
