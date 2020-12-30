package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.minecraft.nbt.difference.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Tuershen update Date on 2020/11/13
 */
public abstract class AbstractMinecraftNBTTag {


    protected Map<Byte, Class<?>> nbtMapClass;

    public AbstractMinecraftNBTTag() {
        nbtMapClass = new HashMap<>();
    }

    public static AreaNBTTagEnum areaNBTTagEnum;

    public static void init(String version) {
        areaNBTTagEnum = AreaNBTTagEnum.getInstance(version);
        areaNBTTagEnum.init(version);
    }

    public static AbstractMinecraftNBTTag getInstance() {
        return areaNBTTagEnum.getMinecraftNBTTag();
    }

    public Map<Byte, Class<?>> getNbtMapClass() {
        return this.nbtMapClass;
    }

    public abstract Class<?> getNBTTagClass(byte type);

}


enum AreaNBTTagEnum implements AreaLoadNBTTag {

    v1_6_R3("v1_6_R3") {
        @Override public void init(String version) {
            NBT_v1_6_R3.init();
        }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_6_R3.getInstance(); }
        },
    V1_7_R1("v1_7_R1") {
        @Override public void init(String version) {
            NBT_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_7_R1_R2_R3.getInstance(); }
        },
    V1_7_R2("v1_7_R2") {
        @Override public void init(String version) {
            NBT_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_7_R1_R2_R3.getInstance(); }
        },
    V1_7_R3("v1_7_R3"){
        @Override public void init(String version) {
            NBT_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_7_R1_R2_R3.getInstance(); }
        },
    V1_7_R4("v1_7_R4") {
        @Override public void init(String version) { NBT_v_1_7_R4.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v_1_7_R4.getInstance(); }
        },
    V1_8_R1("v1_8_R1") {
        @Override public void init(String version) { NBT_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_8_R1_R2_R3.getInstance(); }
    },
    V1_8_R2("v1_8_R2") {
        @Override public void init(String version) { NBT_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_8_R1_R2_R3.getInstance(); }
    },
    V1_8_R3("v1_8_R3") {
        @Override public void init(String version) { NBT_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_8_R1_R2_R3.getInstance(); }
    },
    V1_9_R1("v1_9_R1") {
        @Override public void init(String version) { NBT_v1_9_R1_R2.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_9_R1_R2.getInstance(); }
    },
    V1_9_R2("v1_9_R2") {
        @Override public void init(String version) { NBT_v1_9_R1_R2.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_9_R1_R2.getInstance(); }
    },
    V1_10_R1("v1_10_R1") {
        @Override public void init(String version) { NBT_v1_10_R1.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_10_R1.getInstance(); }
    },
    V1_11_R1("v1_11_R1") {
        @Override public void init(String version) { NBT_v1_11_R1.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_11_R1.getInstance(); }
    },
    V1_12_R1("v1_12_R1") {
        @Override public void init(String version) { NBT_v1_12_R1.init(version); }
        @Override public AbstractMinecraftNBTTag getMinecraftNBTTag() { return NBT_v1_12_R1.getInstance(); }
    };

    private String version;

    AreaNBTTagEnum(String version) {
        this.version = version;
    }

    public static AreaNBTTagEnum getInstance(String version){
        AreaNBTTagEnum[] areaNBTTagEnums = AreaNBTTagEnum.values();
        for (AreaNBTTagEnum nbtTagEnum : areaNBTTagEnums){
            if (nbtTagEnum.version.contains(version)) return nbtTagEnum;
        }
        return null;
    }
}


interface AreaLoadNBTTag {

    void init(String version);

    AbstractMinecraftNBTTag getMinecraftNBTTag();


}