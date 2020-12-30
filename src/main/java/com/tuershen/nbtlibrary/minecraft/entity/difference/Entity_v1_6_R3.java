package com.tuershen.nbtlibrary.minecraft.entity.difference;

import org.bukkit.entity.Entity;
import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.entity.AbstractMinecraftEntity;

import java.lang.reflect.InvocationTargetException;

/**
 * @auther Tuershen update Date on 2020/11/28
 */
public class Entity_v1_6_R3 extends AbstractMinecraftEntity {

    public Entity_v1_6_R3(Entity entity) {
        super(entity);
    }

    public static void initClass(){
        try {
            EntityClass = Class.forName("net.minecraft.entity.Entity");
            NBTTagCompound = Class.forName("net.minecraft.nbt.NBTTagCompound");
            save = EntityClass.getDeclaredMethod("func_70109_d", NBTTagCompound);
            load = EntityClass.getDeclaredMethod("func_70020_e", NBTTagCompound);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NBTTagCompoundApi getNBTTagCompound() {
        try {
            this.nbtTagCompound = NBTTagCompound.newInstance();
            this.craftEntity = CraftEntityClass.cast(this.entity);
            this.minecraftEntity = getHandle.invoke(craftEntity);
            save.invoke(minecraftEntity,nbtTagCompound);
            return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return AbstractNBTTagCompound.getMinecraftNBTTag(this.nbtTagCompound);
    }

    @Override
    public void saveNBTTag(NBTTagCompoundApi tagCompoundApi) {
        try {
            this.nbtTagCompound = tagCompoundApi.getNMSCompound();
            load.invoke(this.minecraftEntity, this.nbtTagCompound);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
