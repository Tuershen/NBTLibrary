package com.tuershen.nbtlibrary.minecraft.entity.difference;

import org.bukkit.entity.Entity;

public class Entity_v1_7_R4 extends Entity_v1_7_R1_R2_R3 {

    public Entity_v1_7_R4(Entity entity) {
        super(entity);
    }

    public static void initClass(){
        try {
            EntityClass = Class.forName("net.minecraft.entity.Entity");
            NBTTagCompound = Class.forName("net.minecraft.nbt.NBTTagCompound");
            save = EntityClass.getDeclaredMethod("e",NBTTagCompound);
            load = EntityClass.getDeclaredMethod("f",NBTTagCompound);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
