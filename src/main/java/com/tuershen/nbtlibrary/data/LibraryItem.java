package com.tuershen.nbtlibrary.data;

import com.tuershen.nbtlibrary.minecraft.nbt.TagCompound;

import java.io.Serializable;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public class LibraryItem implements Serializable {

    private static final long serialVersionUID = -7580195158921149018L;

    private String id;

    private TagCompound tagCompound;

    public LibraryItem(String id, TagCompound tagCompound) {
        this.id = id;
        this.tagCompound = tagCompound;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TagCompound getTagCompound() {
        return tagCompound;
    }

    public void setTagCompound(TagCompound tagCompound) {
        this.tagCompound = tagCompound;
    }


    @Override
    public String toString() {
        return "LibraryItem{" +
                "id='" + id + '\'' +
                ", tagCompound=" + tagCompound +
                '}';
    }




}
