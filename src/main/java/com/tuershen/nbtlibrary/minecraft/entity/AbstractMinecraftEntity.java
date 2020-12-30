package com.tuershen.nbtlibrary.minecraft.entity;

import com.tuershen.nbtlibrary.api.EntityNBTTagCompoundApi;
import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import org.bukkit.entity.Entity;
import com.tuershen.nbtlibrary.minecraft.entity.difference.*;


import java.lang.reflect.Method;

public abstract class AbstractMinecraftEntity implements EntityNBTTagCompoundApi {

    //Class           org.bukkit.craftBukkit.xxx.entity.CraftEntity
    protected static Class<?>        CraftEntityClass;

    //Class          org.bukkit.craftBukkit.xxx.entity.CraftEntity.getHandle()
    protected static Method          getHandle;

    //Class          net.minecraft.server.xxx.Entity
    protected static Class<?>        EntityClass;

    //Class          net.minecraft.server.xxx.NBTTagCompound
    protected static Class<?>        NBTTagCompound;

    //保存实体NBT
    protected static Method save;

    //加载实体NBT
    protected static Method load;

    //
    private static AreaEntityEnum areaEntityEnum;

    //NBTTagCompound net.minecraft.server.xxx.NBTTagCompound
    protected Object                 nbtTagCompound;

    //CraftEntity    org.bukkit.craftBukkit.xxx.entity.CraftEntity
    protected Object                 craftEntity;

    //Entity          net.minecraft.server.xxx.Entity
    protected Object                 minecraftEntity;

    //Entity          org.bukkit.entity.Entity
    protected Entity                 entity;

    public AbstractMinecraftEntity(Entity entity){
        this.entity = entity;
    }


    /**
     * 加载类
     * @param version 服务器版本
     */
    public static void init(String version){
        try {
            CraftEntityClass = Class.forName("org.bukkit.craftbukkit."+ version +".entity.CraftEntity");
            getHandle = CraftEntityClass.getDeclaredMethod("getHandle");
            areaEntityEnum = AreaEntityEnum.getInstance(version);
            areaEntityEnum.init(version);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static AbstractMinecraftEntity getInstance(Entity entity){
        return areaEntityEnum.createEntity(entity);
    }

    public abstract NBTTagCompoundApi getNBTTagCompound();

    public abstract void saveNBTTag(NBTTagCompoundApi tagCompoundApi);

}



enum AreaEntityEnum implements AreaLoadEntity {

    v1_6_R3("v1_6_R3"){
        @Override public void init(String version) {
            Entity_v1_6_R3.initClass();
        }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) {
            return new Entity_v1_6_R3(entity);
        }
    },
    V1_7_R1("v1_7_R1"){
        @Override public void init(String version) {
            Entity_v1_7_R1_R2_R3.initClass(version);
        }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) {
            return new Entity_v1_7_R1_R2_R3(entity);
        }
    },
    V1_7_R2("v1_7_R2"){
        @Override public void init(String version) {
            Entity_v1_7_R1_R2_R3.initClass(version);
        }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) {
            return new Entity_v1_7_R1_R2_R3(entity);
        }
    },
    V1_7_R3("v1_7_R3"){
        @Override public void init(String version) {
            Entity_v1_7_R1_R2_R3.initClass(version);
        }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) {
            return new Entity_v1_7_R1_R2_R3(entity);
        }
    },
    V1_7_R4("v1_7_R4"){
        @Override public void init(String version) {
            Entity_v1_7_R4.initClass();
        }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) {
            return new Entity_v1_7_R4(entity);
        }
    },
    V1_8_R1("v1_8_R1"){
        @Override public void init(String version) { Entity_v1_8_R1_R2_R3.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_8_R1_R2_R3(entity); }
    },
    V1_8_R2("v1_8_R2"){
        @Override public void init(String version) { Entity_v1_8_R1_R2_R3.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_8_R1_R2_R3(entity); }
    },
    V1_8_R3("v1_8_R3"){
        @Override public void init(String version) { Entity_v1_8_R1_R2_R3.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_8_R1_R2_R3(entity); }
    },
    V1_9_R1("v1_9_R1"){
        @Override public void init(String version) { Entity_v1_9_R1_R2.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_9_R1_R2(entity); }
    },
    V1_9_R2("v1_9_R2"){
        @Override public void init(String version) { Entity_v1_9_R1_R2.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_9_R1_R2(entity); }
    },
    V1_10_R1("v1_10_R1"){
        @Override public void init(String version) { Entity_v1_10_R1.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_10_R1(entity); }
    },
    V1_11_R1("v1_11_R1"){
        @Override public void init(String version) { Entity_v1_11_R1.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_11_R1(entity); }
    },
    V1_12_R1("v1_12_R1") {
        @Override public void init(String version) { Entity_v1_12_R1.initClass(version); }
        @Override public AbstractMinecraftEntity createEntity(Entity entity) { return new Entity_v1_12_R1(entity); }
    };

    private String version;

    AreaEntityEnum(String version) {
        this.version = version;
    }

    public static AreaEntityEnum getInstance(String version){
        AreaEntityEnum[] areaTileEntityEnums = AreaEntityEnum.values();
        for (AreaEntityEnum entityEnum : areaTileEntityEnums){
            if (entityEnum.version.contains(version)) return entityEnum;
        }
        return null;
    }

}


interface AreaLoadEntity{

    void init(String version);

    AbstractMinecraftEntity createEntity(Entity entity);

}


