package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.CompoundLibraryManager;
import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TagList<T extends TagBase> extends TagBase implements Serializable {

    private static final long serialVersionUID = 2185262442682894234L;

    private List<T> data = new ArrayList<>();

    private byte type = 0;

    public TagList(List<T> data){
        this.data = data;
    }

    public TagList(){ }

    public List<T> getData() {
        return data;
    }

    @TagAnnotation( tagType = "list" )
    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagList{" +
                "data=" + data +
                ", type=" + type +
                '}';
    }

    public void remove(int i){
        this.data.remove(i);
    }

    public T getCompound(int i){
        if (i >= 0 && i < this.data.size()) {
            T tag = this.getData().get(i);
            if (tag.getTypeId() == 10) {
                return tag;
            }
        }
        return (T)new TagCompound();
    }

    @Override
    public Object data() {
        return this.data;
    }

    @Override
    public byte getTypeId() {
        return 9;
    }

    public void add(T tagBase){
        if (tagBase.getTypeId() == 0){
            CompoundLibraryManager.server.getLogger().info("NBTTagList不能集合内不能添加NBTTagList");
            return;
        }
        if (this.type == 0){
            this.type = tagBase.getTypeId();
        }else if (this.type != tagBase.getTypeId()){
            CompoundLibraryManager.server.getLogger().info("当前集合内只能添加类型为"+ getNBTTag(this.type)+"的数据");
            return;
        }
        this.data.add(tagBase);
    }

    public byte getType(){
        return this.type;
    }
}
