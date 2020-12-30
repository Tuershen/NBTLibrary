package com.tuershen.nbtlibrary.minecraft.block;

import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.api.TileEntityCompoundApi;
import org.bukkit.block.Block;
import com.tuershen.nbtlibrary.minecraft.block.difference.*;


public abstract class AbstractMinecraftEntityTile implements TileEntityCompoundApi {

    private static AreaTileEntityEnum areaTileEntityEnum;

    protected static Class<?> NBTTagCompound;

    protected Block block;

    protected Object nbtTagCompound;

    public AbstractMinecraftEntityTile(Block block){
        this.block = block;
    }

    public static void init(String version){
        areaTileEntityEnum = AreaTileEntityEnum.getInstance(version);
        areaTileEntityEnum.initClass(version);
    }

    public static AbstractMinecraftEntityTile getInstance(Block block){
        return areaTileEntityEnum.createTileEntity(block);
    }

    public abstract NBTTagCompoundApi getNBTTagCompound();

    public abstract void saveNBTTag(NBTTagCompoundApi tagCompoundApi);


}


enum AreaTileEntityEnum implements AreaLoadTileEntity{

    v1_6_R3("v1_6_R3"){
        @Override public void initClass(String version) {
            TileEntity_v1_6_R3.init(version);
        }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_6_R3(block); }
    },
    V1_7_R1("v1_7_R1"){
        @Override public void initClass(String version) { TileEntity_v1_7_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_7_R1_R2_R3(block); }
    },
    V1_7_R2("v1_7_R2"){
        @Override public void initClass(String version) {
            TileEntity_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_7_R1_R2_R3(block); }
    },
    V1_7_R3("v1_7_R3"){
        @Override public void initClass(String version) {
            TileEntity_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_7_R1_R2_R3(block); }
    },
    V1_7_R4("v1_7_R4"){
        @Override public void initClass(String version) {
            TileEntity_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_7_R1_R2_R3(block); }
    },
    V1_8_R1("v1_8_R1"){
        @Override public void initClass(String version) { TileEntity_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_8_R1_R2_R3(block); }
    },
    V1_8_R2("v1_8_R2"){
        @Override public void initClass(String version) { TileEntity_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_8_R1_R2_R3(block); }
    },
    V1_8_R3("v1_8_R3"){
        @Override public void initClass(String version) { TileEntity_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_8_R1_R2_R3(block); }
    },
    V1_9_R1("v1_9_R1"){
        @Override public void initClass(String version) { TileEntity_v1_9_R1_R2.changeInit(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_9_R1_R2(block); }
    },
    V1_9_R2("v1_9_R2"){
        @Override public void initClass(String version) { TileEntity_v1_9_R1_R2.changeInit(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_9_R1_R2(block); }
    },
    V1_10_R1("v1_10_R1") {
        @Override public void initClass(String version) { TileEntity_v1_10_R1.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_10_R1(block); }
    },
    V1_11_R1("v1_11_R1") {
        @Override public void initClass(String version) { TileEntity_v1_11_R1.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_11_R1(block); }
    },
    V1_12_R1("v1_12_R1") {
        @Override public void initClass(String version) { TileEntity_v1_12_R1.init(version); }
        @Override public AbstractMinecraftEntityTile createTileEntity(Block block) { return new TileEntity_v1_12_R1(block); }
    };

    private String version;

    AreaTileEntityEnum(String version) {
        this.version = version;
    }

    public static AreaTileEntityEnum getInstance(String version){
        AreaTileEntityEnum[] areaTileEntityEnums = AreaTileEntityEnum.values();
        for (AreaTileEntityEnum tileEntityEnum : areaTileEntityEnums){
            if (tileEntityEnum.version.contains(version)) return tileEntityEnum;
        }
        return null;
    }


}

interface AreaLoadTileEntity{

    void initClass(String version);

    AbstractMinecraftEntityTile createTileEntity(Block block);

}

