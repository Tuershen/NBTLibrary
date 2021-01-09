package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TagCompound<T extends TagBase> extends TagBase implements Serializable {

    private static final long serialVersionUID = 6962586368452458832L;

    private Map<String, T> map;

    public TagCompound(Map<String, T> map){
        this.map = map;
    }

    public TagCompound(){
        this.map = new HashMap<>();
    }

    public TagCompound (String key, T tagBase) {
        this.map.put(key, tagBase);
    }

    public Map<String, T> getMap() {
        if (this.map == null || this.map.size() == 0){
            this.map = new HashMap<>();
        }
        return map;
    }

    @TagAnnotation( tagType = "Compound" )
    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

    public void remove(Object var){
        this.map.remove(var);
    }

    public boolean hasKey(String key) {
        return this.map.containsKey(key);
    }

    public TagList getList(String key) {
        T list = this.map.get(key);
        if (list.getTypeId() == 9) return (TagList) list;
        return null;
    }

    public TagCompound getCompound(String key){
        T map = this.map.get(key);
        if (map.getTypeId() == 10) return (TagCompound) map;
        return null;
    }

    public TagInt getInt(String key){
        return (TagInt) this.map.get(key);
    }

    public TagString getString(String key){
        return (TagString) this.map.get(key);
    }

    public TagDouble getDouble(String key){
        return (TagDouble) this.map.get(key);
    }

    public TagFloat getFloat(String key){
        return (TagFloat) this.map.get(key);
    }

    public TagShort getShort(String key){
        return (TagShort) this.map.get(key);
    }

    public TagLong getLong(String key){
        return (TagLong) this.map.get(key);
    }

    public TagByte getByte(String key){
        return (TagByte) this.map.get(key);
    }

    public void set(String key, T tag) {
        this.map.put(key, tag);
    }

    public void setInt(String key, T tagInt) {
        this.map.put(key, tagInt);
    }

    public void setString(String key, T data){
        if (data != null) {
            this.map.put(key, data);
        }
    }

    public void setDouble(String key, T data){
        this.map.put(key, data);
    }
    public void setFloat(String key, T data){
        this.map.put(key, data);
    }

    public void setShort(String key, T data){
        this.map.put(key, data);
    }
    public void setLong(String key, T data){
        this.map.put(key, data);
    }

    public void setByte(String key, T data){
        this.map.put(key, data);
    }

    public void put(String key, T tagBase){
        this.map.put(key, tagBase);
    }


    @Override
    public Object data() {
        return this.map;
    }

    @Override
    public byte getTypeId() {
        return 10;
    }


}
