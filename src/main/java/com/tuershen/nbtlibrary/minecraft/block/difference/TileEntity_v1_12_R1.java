package com.tuershen.nbtlibrary.minecraft.block.difference;

import org.bukkit.block.Block;
import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.block.AbstractMinecraftEntityTile;
import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TileEntity_v1_12_R1 extends AbstractMinecraftEntityTile {

    private static Class<?> CraftBlockEntityStateClass;

    private static Class<?> TileEntityClass;

    private static Method getTileEntity;

    private static Method save;

    private static Method load;

    private static Constructor craftBlockEntityStateConstructor;

    private Object craftBlockEntityTile;

    private Object tileEntity;

    public TileEntity_v1_12_R1(Block block) {
        super(block);
    }

    public static void init(String version){
        try {
            CraftBlockEntityStateClass = Class.forName("org.bukkit.craftbukkit."+ version +".block.CraftBlockEntityState");
            TileEntityClass            = Class.forName("net.minecraft.server."+ version +".TileEntity");
            NBTTagCompound             = Class.forName("net.minecraft.server."+ version +".NBTTagCompound");
            getTileEntity = CraftBlockEntityStateClass.getDeclaredMethod("getTileEntity");
            //保存tile的NBT数据
            save = TileEntityClass.getDeclaredMethod("save",NBTTagCompound);
            //从NBT中加载数据至tile
            load = TileEntityClass.getDeclaredMethod("load",NBTTagCompound);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NBTTagCompoundApi getNBTTagCompound() {
        try {
            this.nbtTagCompound = NBTTagCompound.newInstance();
            craftBlockEntityStateConstructor = CraftBlockEntityStateClass.getConstructor(Block.class,Class.class);
            this.craftBlockEntityTile = craftBlockEntityStateConstructor.newInstance(this.block,TileEntityClass);
            getTileEntity.setAccessible(true);
            this.tileEntity = getTileEntity.invoke(this.craftBlockEntityTile);
            if (tileEntity == null) return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
            this.nbtTagCompound = save.invoke(this.tileEntity,this.nbtTagCompound);
            return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
    }

    @Override
    public void saveNBTTag(NBTTagCompoundApi tagCompoundApi) {
        try {
            TagCompound nbtTagCompoundApi = tagCompoundApi.getNBTTagCompoundApi();
            if (nbtTagCompoundApi.getMap().size() <= 0) return;
            this.nbtTagCompound = tagCompoundApi.getNMSCompound();
            if (this.nbtTagCompound == null || this.tileEntity == null) return;
            load.invoke(this.tileEntity,this.nbtTagCompound);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
