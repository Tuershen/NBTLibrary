package com.tuershen.nbtlibrary.minecraft;


import com.tuershen.nbtlibrary.api.NBTTagCompoundApi;
import com.tuershen.nbtlibrary.common.AbstractNBTTagCompound;
import com.tuershen.nbtlibrary.minecraft.item.AbstractMinecraftItem;
import com.tuershen.nbtlibrary.minecraft.nbt.AbstractMinecraftNBTTag;

import java.lang.reflect.Field;

public class MinecraftItemStack {

    private static Class<?> minecraftItemStackClass;

    private static Class<?> nbtTagCompoundClass;

    private static Field setTag;

    private static Field getTag;

    private Object minecraftItemStack;

    public static AbstractMinecraftItem item;

    public <T> MinecraftItemStack(T obj){
        if (obj == null){
            throw new NullPointerException("[NBTLibrary] "+MinecraftItemStack.class.getPackage().getName()+".MinecraftItemStack T null");
        }
        this.minecraftItemStack = obj;
    }

    public <T> void setMinecraftItemStack(T obj){
        if (obj == null){
            throw new NullPointerException("[NBTLibrary] "+MinecraftItemStack.class.getPackage().getName()+".setMinecraftItemStack T null");
        }
        this.minecraftItemStack = obj;
    }

    public Object getMinecraftItemStack(){
        return this.minecraftItemStack;
    }

    public static void initMinecraftItemStackClass(){
        minecraftItemStackClass = AbstractMinecraftItem.getInstance().classItemStack();
        nbtTagCompoundClass = AbstractMinecraftNBTTag.getInstance().getNBTTagClass((byte) 10);
    }

    public <T> void setMinecraftItemStackTag(T obj){
        if (this.minecraftItemStack == null){
            throw new NullPointerException("[NBTLibrary] "+MinecraftItemStack.class.getPackage().getName()+".minecraftItemStack null");
        }
        this.set(obj);
    }

    public NBTTagCompoundApi getMinecraftItemStackTag(){
        if (this.minecraftItemStack == null){
            throw new NullPointerException("[NBTLibrary] "+MinecraftItemStack.class.getPackage().getName()+".minecraftItemStack null");
        }
        return getCompound();
    }

    <T> void set(T obj){
        try {
            setTag = this.getNMSField();
            setTag.setAccessible(true);
            setTag.set(this.minecraftItemStack , obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    NBTTagCompoundApi getCompound(){
        Object tag = null;
        try {
            getTag = this.getNMSField();
            getTag.setAccessible(true);
            tag = getTag.get(this.minecraftItemStack);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (tag == null){
            tag = AbstractNBTTagCompound.newCompound();
        }
        return AbstractNBTTagCompound.getMinecraftNBTTag(tag);
    }

    Field getNMSField() {
        Field[] fields = this.getMinecraftItemStack().getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getType().getSimpleName().equalsIgnoreCase("NBTTagCompound")) {
                return fields[i];
            }
        }
        return null;
    }

}
