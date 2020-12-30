package com.tuershen.nbtlibrary.minecraft.item;

import com.tuershen.nbtlibrary.minecraft.item.difference.*;

public abstract class AbstractMinecraftItem {

    protected Class<?> itemStackClass;

    public static AreaItemEnum areaItemEnum;

    public static void init(String version){
        areaItemEnum = AreaItemEnum.getInstance(version);
        areaItemEnum.init(version);
    }

    public static AbstractMinecraftItem getInstance(){
        return areaItemEnum.getMinecraftItem();
    }

    public abstract Class<?> classItemStack();

}



enum AreaItemEnum implements AreaLoadItem {

    v1_6_R3("v1_6_R3"){
        @Override public void init(String version) {
            Item_v1_6_R3.init();
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return Item_v1_6_R3.getInstance();
        }
        },
    V1_7_R1("v1_7_R1"){
        @Override public void init(String version) {
            Item_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return Item_v1_7_R1_R2_R3.getInstance();
        }
        },
    V1_7_R2("v1_7_R2"){
        @Override public void init(String version) {
            Item_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return new Item_v1_7_R1_R2_R3();
        }
        },
    V1_7_R3("v1_7_R3"){
        @Override public void init(String version) {
            Item_v1_7_R1_R2_R3.init(version);
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return new Item_v1_7_R1_R2_R3();
        }
        },
    V1_7_R4("v1_7_R4"){
        @Override public void init(String version) {
            Item_v1_7_R4.init();
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return new Item_v1_7_R4();
        }
        },
    V1_8_R1("v1_8_R1"){
        @Override public void init(String version) { Item_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_8_R1_R2_R3(); }
    },
    V1_8_R2("v1_8_R2"){
        @Override public void init(String version) { Item_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_8_R1_R2_R3(); }
    },
    V1_8_R3("v1_8_R3"){
        @Override public void init(String version) { Item_v1_8_R1_R2_R3.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_8_R1_R2_R3(); }
    },
    V1_9_R1("v1_9_R1"){
        @Override public void init(String version) { Item_v1_9_R1_R2.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_9_R1_R2(); }
    },
    V1_9_R2("v1_9_R2"){
        @Override public void init(String version) { Item_v1_9_R1_R2.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_9_R1_R2(); }
    },
    V1_10_R1("v1_10_R1"){
        @Override public void init(String version) { Item_v1_10_R1.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_10_R1(); }
    },
    V1_11_R1("v1_11_R1"){
        @Override public void init(String version) { Item_v1_11_R1.init(version); }
        @Override public AbstractMinecraftItem getMinecraftItem() { return new Item_v1_11_R1(); }
    },
    V1_12_R1("v1_12_R1") {
        @Override public void init(String version) {
            Item_v1_12_R1.init(version);
        }
        @Override public AbstractMinecraftItem getMinecraftItem() {
            return new Item_v1_12_R1();
        }
    };

    private String version;

    AreaItemEnum(String version) {
        this.version = version;
    }

    public static AreaItemEnum getInstance(String version){
        AreaItemEnum[] areaTileEntityEnums = AreaItemEnum.values();
        for (AreaItemEnum entityEnum : areaTileEntityEnums){
            if (entityEnum.version.contains(version)) return entityEnum;
        }
        return null;
    }

}
interface AreaLoadItem{

    void init(String version);

    AbstractMinecraftItem getMinecraftItem();

}