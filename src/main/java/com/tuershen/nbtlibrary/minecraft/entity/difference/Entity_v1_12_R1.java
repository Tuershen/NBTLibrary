package com.tuershen.nbtlibrary.minecraft.entity.difference;

import org.bukkit.entity.Entity;

public class Entity_v1_12_R1 extends Entity_v1_6_R3 {

    public Entity_v1_12_R1(Entity entity) {
        super(entity);
    }

    public static void initClass(String version){
        try {
            EntityClass = Class.forName("net.minecraft.server."+version+".Entity");
            NBTTagCompound = Class.forName("net.minecraft.server."+version+".NBTTagCompound");
            save = EntityClass.getDeclaredMethod("save", NBTTagCompound);
            load = EntityClass.getDeclaredMethod("f", NBTTagCompound);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
