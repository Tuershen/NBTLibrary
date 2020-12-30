package com.tuershen.nbtlibrary.minecraft;

import com.tuershen.nbtlibrary.api.*;
import com.tuershen.nbtlibrary.api.SerializableEntity;
import com.tuershen.nbtlibrary.api.SerializableInventory;
import com.tuershen.nbtlibrary.api.SerializableItemApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.block.AbstractMinecraftEntityTile;
import com.tuershen.nbtlibrary.minecraft.entity.AbstractMinecraftEntity;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class PluginManager implements CompoundLibraryApi {

    @Override
    public ItemStack setCompound(ItemStack itemStack, NBTTagCompoundApi compoundTagApi) {
        MinecraftItemStack minecraftItemStack = CraftItemStack.asNMSCopy(itemStack);
        minecraftItemStack.setMinecraftItemStackTag(compoundTagApi.getNMSCompound());
        return CraftItemStack.asBukkitCopy(minecraftItemStack);
    }

    @Override
    public NBTTagCompoundApi getCompound(ItemStack itemStack) {
        return CraftItemStack.asNMSCopy(itemStack).getMinecraftItemStackTag();
    }

    @Override
    public SerializableItemApi getSerializeItem() {
        return AbstractNBTTagCompound.getSerializableItemApi();
    }

    @Override
    public SerializableInventory getSerializableInventoryApi() {
        return AbstractNBTTagCompound.getSerializableInventoryApi();
    }

    @Override
    public EntityNBTTagCompoundApi getEntityCompoundApi(LivingEntity livingEntity) {
        return AbstractMinecraftEntity.getInstance(livingEntity);
    }

    public SerializableEntity getSerializableEntityApi(){


        return null;
    }

    @Override
    public TileEntityCompoundApi getTileEntityCompoundApi(Block block) {
        return AbstractMinecraftEntityTile.getInstance(block);
    }

    @Override
    public Object getMinecraftItem(ItemStack itemStack) {
        return CraftItemStack.asNMSCopy(itemStack).getMinecraftItemStack();
    }






}
