package com.tuershen.nbtlibrary.data;



import java.io.Serializable;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public class LibraryInventory implements Serializable {

    private static final long serialVersionUID = -2209465401536042278L;

    private int size;

    private String title;

    private int maxStackSize;

    private String[] libraryItems;

    public LibraryInventory() {

    }

    public LibraryInventory(int size, String title, int maxStackSize, String[] libraryItems) {
        this.size = size;
        this.title = title;
        this.maxStackSize = maxStackSize;
        this.libraryItems = libraryItems;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public String[] getLibraryItems() {
        return libraryItems;
    }

    public void setLibraryItems(String[] libraryItems) {
        this.libraryItems = libraryItems;
    }



}
