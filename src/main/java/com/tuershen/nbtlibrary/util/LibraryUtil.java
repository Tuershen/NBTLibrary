package com.tuershen.nbtlibrary.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public class LibraryUtil {

    /**
     * 创建ItemStack实例
     * @param id
     * @return
     */
    public static ItemStack createItem(String... id){
        if (id.length == 1){
            return new ItemStack(Material.valueOf(id[0]),1);
        }
        return new ItemStack(Material.valueOf(id[0]), 1, Short.parseShort(id[1]));
    }

}
