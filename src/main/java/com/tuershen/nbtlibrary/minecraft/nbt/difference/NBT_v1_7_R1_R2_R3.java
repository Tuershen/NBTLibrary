package com.tuershen.nbtlibrary.minecraft.nbt.difference;

import com.tuershen.nbtlibrary.minecraft.nbt.AbstractMinecraftNBTTag;

/**
 * @auther Tuershen update Date on 2020/11/13
 * 1.7R1-1.7R3版本
 *
 */
public class NBT_v1_7_R1_R2_R3 extends AbstractMinecraftNBTTag {

    private static NBT_v1_7_R1_R2_R3 nbt_v1_7_r1_r2_r3;

    public NBT_v1_7_R1_R2_R3(String version) {
        try {
            super.nbtMapClass.put( (byte)1,  Class.forName("net.minecraft.server."+ version +".NBTTagByte"));
            super.nbtMapClass.put( (byte)2,  Class.forName("net.minecraft.server."+ version +".NBTTagShort"));
            super.nbtMapClass.put( (byte)3,  Class.forName("net.minecraft.server."+ version +".NBTTagInt"));
            super.nbtMapClass.put( (byte)4,  Class.forName("net.minecraft.server."+ version +".NBTTagLong"));
            super.nbtMapClass.put( (byte)5,  Class.forName("net.minecraft.server."+ version +".NBTTagFloat"));
            super.nbtMapClass.put( (byte)6,  Class.forName("net.minecraft.server."+ version +".NBTTagDouble"));
            super.nbtMapClass.put( (byte)7,  Class.forName("net.minecraft.server."+ version +".NBTTagByteArray"));
            super.nbtMapClass.put( (byte)8,  Class.forName("net.minecraft.server."+ version +".NBTTagString"));
            super.nbtMapClass.put( (byte)9,  Class.forName("net.minecraft.server."+ version +".NBTTagList"));
            super.nbtMapClass.put( (byte)10, Class.forName("net.minecraft.server."+ version +".NBTTagCompound"));
            super.nbtMapClass.put( (byte)11, Class.forName("net.minecraft.server."+ version +".NBTTagIntArray"));
            super.nbtMapClass.put( (byte)-1, Class.forName("net.minecraft.server."+ version +".NBTBase"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void init(String version) {
        nbt_v1_7_r1_r2_r3 = new NBT_v1_7_R1_R2_R3(version);

    }

    public static NBT_v1_7_R1_R2_R3 getInstance(){
        return nbt_v1_7_r1_r2_r3;
    }

    @Override
    public Class<?> getNBTTagClass(byte type) {
        return nbtMapClass.get(type);
    }




}
