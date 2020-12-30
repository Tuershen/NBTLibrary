package com.tuershen.nbtlibrary.api;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public interface CompoundLibraryApi {



    /**
     * 获取物品的NBT数据
     * @param itemStack 物品
     * @return NBTTagCompoundApi包含所有NMS中的get，set操作
     */
    NBTTagCompoundApi getCompound(ItemStack itemStack);


    /**
     * 设置物品的NBT数据
     * @param itemStack 需要需要的物品
     * @param compoundTagApi NBTTagCompoundApi实例相当于NMS的NBTTagCompound实例
     * @return 修改过后的物品
     */

    ItemStack setCompound(ItemStack itemStack, NBTTagCompoundApi compoundTagApi);

    /**
     * 序列化ItemStack
     * @return 序列化接口，包含序列化和反序列化
     */
    SerializableItemApi getSerializeItem();


    /**
     * 序列化容器
     * @return 序列化接口，包含序列化和反序列化
     */
    SerializableInventory getSerializableInventoryApi();


    /**
     *
     * @return
     */
    SerializableEntity getSerializableEntityApi();

    /**
     * 获取实体的NBTTagCompound相关接口
     * @param livingEntity 实例LivingEntity
     * @return EntityNBTTagCompoundApi包含获取设置实体的NBT数据
     */
    EntityNBTTagCompoundApi getEntityCompoundApi(LivingEntity livingEntity);

    /**
     * 方塊Tile
     * @param block
     * @return
     */
    TileEntityCompoundApi getTileEntityCompoundApi(Block block);


    /**
     * 把Bukkit的ItemStack转换为NMS的ItemStack
     * @param itemStack
     * @return NMS -> ItemStack
     */
    Object getMinecraftItem(ItemStack itemStack);


}
