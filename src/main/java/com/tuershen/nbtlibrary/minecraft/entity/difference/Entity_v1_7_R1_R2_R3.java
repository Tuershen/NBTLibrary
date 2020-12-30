package com.tuershen.nbtlibrary.minecraft.entity.difference;

import org.bukkit.entity.Entity;

/**
 * @auther Tuershen update Date on 2020/12/2
 */
public class Entity_v1_7_R1_R2_R3 extends Entity_v1_6_R3 {

    public Entity_v1_7_R1_R2_R3(Entity entity) {
        super(entity);
    }

    public static void initClass(String version){
        try {
            EntityClass = Class.forName("net.minecraft.server."+version+".Entity");
            NBTTagCompound = Class.forName("net.minecraft.server."+ version +".NBTTagCompound");
            save = EntityClass.getDeclaredMethod("e",NBTTagCompound);
            load = EntityClass.getDeclaredMethod("f",NBTTagCompound);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
