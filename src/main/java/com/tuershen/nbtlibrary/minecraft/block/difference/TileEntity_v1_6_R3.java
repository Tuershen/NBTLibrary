package com.tuershen.nbtlibrary.minecraft.block.difference;

import org.bukkit.block.Block;
import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.block.AbstractMinecraftEntityTile;
import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther Tuershen update Date on 2020/11/29
 */
public class TileEntity_v1_6_R3 extends AbstractMinecraftEntityTile {

    protected static Class<?> CraftWorld;

    protected static Class<?> TileEntity;

    protected static Method getTileEntityAt;

    protected static Method save;

    protected static Method load;

    protected Object craftWorld;

    protected Object tileEntity;

    public TileEntity_v1_6_R3(Block block) {
        super(block);
    }

    public static void init(String version){
        try {
            TileEntity = Class.forName("net.minecraft.tileentity.TileEntity");
            CraftWorld = Class.forName("org.bukkit.craftbukkit."+ version +".CraftWorld");
            NBTTagCompound = Class.forName("net.minecraft.nbt.NBTTagCompound");
            getTileEntityAt = CraftWorld.getDeclaredMethod("getTileEntityAt", int.class, int.class, int.class);
            //将tile写入NBT
            //原文：func_70310_b,writeToNBT,2,Writes a tile entity to NBT.
            load = TileEntity.getDeclaredMethod("func_70310_b", NBTTagCompound);
            //创建新实体并从指定的NBT加载其数据
            //原文：func_70317_c,createAndLoadEntity, 2 , Creates a new entity and loads its data from the specified NBT.
            //翻译：创建新实体并从指定的NBT加载其数据
            //原文：func_70307_a,readFromNBT,2,Reads a tile entity from NBT.
            //翻译：从NBT数据中读取Tile
            //这里使用的是func_70317_c，也可以使用func_70307_a方法
            save = TileEntity.getDeclaredMethod("func_70317_c", NBTTagCompound);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将tile写入NBT
     * @return NBT接口
     */
    @Override
    public NBTTagCompoundApi getNBTTagCompound() {
        try {
            //创建NBT实例存放tile数据
            this.nbtTagCompound = NBTTagCompound.newInstance();
            //将bukkit的world接口实例转换为obc的World实现类
            craftWorld = CraftWorld.cast(this.block.getWorld());
            //从obc中获取nms中的Tile
            int x = this.block.getX();
            int y = this.block.getY();
            int z = this.block.getZ();
            tileEntity = getTileEntityAt.invoke(craftWorld, x, y, z);
            //如果为空说明该方块不属于tile
            if (tileEntity == null) return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
            //如果是tile就会有nbt数据
            save.invoke(tileEntity,this.nbtTagCompound);
            return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
    }

    /**
     * 创建新实体并从指定的NBT加载其数据
     * @param tagCompoundApi
     */
    @Override
    public void saveNBTTag(NBTTagCompoundApi tagCompoundApi) {
        TagCompound nbtTagCompoundApi = tagCompoundApi.getNBTTagCompoundApi();
        if (nbtTagCompoundApi.getMap().size() <= 0) return;
        this.nbtTagCompound = tagCompoundApi.getNMSCompound();
        if (this.nbtTagCompound == null) return;
        try {
            //创建新实体并从指定的NBT加载其数据
            //数据源this.nbtTagCompound
            load.invoke(this.tileEntity, this.nbtTagCompound);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
