package com.tuershen.nbtlibrary.minecraft.nbt.difference;

import com.tuershen.nbtlibrary.minecraft.nbt.AbstractMinecraftNBTTag;


/**
 * @auther Tuershen update Date on 2020/11/29
 */
public class NBT_v1_6_R3 extends AbstractMinecraftNBTTag {

    public NBT_v1_6_R3(){
        try {
            super.nbtMapClass.put( (byte)-1,Class.forName("net.minecraft.nbt.NBTBase"));
            super.nbtMapClass.put( (byte)1, Class.forName("net.minecraft.nbt.NBTTagByte"));//field_74756_a
            super.nbtMapClass.put( (byte)2, Class.forName("net.minecraft.nbt.NBTTagShort"));//field_74752_a
            super.nbtMapClass.put( (byte)3, Class.forName("net.minecraft.nbt.NBTTagInt")); //field_74748_a
            super.nbtMapClass.put( (byte)4, Class.forName("net.minecraft.nbt.NBTTagLong"));//field_74753_a
            super.nbtMapClass.put( (byte)5, Class.forName("net.minecraft.nbt.NBTTagFloat"));//field_74750_a
            super.nbtMapClass.put( (byte)6, Class.forName("net.minecraft.nbt.NBTTagDouble"));//field_74755_a
            super.nbtMapClass.put( (byte)7, Class.forName("net.minecraft.nbt.NBTTagByteArray"));//field_74754_a
            super.nbtMapClass.put( (byte)8, Class.forName("net.minecraft.nbt.NBTTagString"));//field_74751_a
            super.nbtMapClass.put( (byte)9, Class.forName("net.minecraft.nbt.NBTTagList"));// //field_74747_a
            super.nbtMapClass.put( (byte)10,Class.forName("net.minecraft.nbt.NBTTagCompound"));//field_74784_a
            super.nbtMapClass.put( (byte)11,Class.forName("net.minecraft.nbt.NBTTagIntArray")); //field_74749_a


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static NBT_v1_6_R3 nbt_v1_6_r3;

    public static void init() {
        nbt_v1_6_r3 = new NBT_v1_6_R3();
    }

    public static NBT_v1_6_R3 getInstance(){
        return nbt_v1_6_r3;
    }

    @Override
    public Class<?> getNBTTagClass(byte type) {
        return nbtMapClass.get(type);
    }


}
