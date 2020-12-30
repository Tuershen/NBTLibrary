package com.tuershen.nbtlibrary.api;

import org.bukkit.inventory.Inventory;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public interface SerializableInventory extends SerializableTag{

    /**
     *
     * @param data
     * @return
     */
    Inventory deserializeInventory(String data);

    /**
     *
     * @param inventory
     * @return
     */
    String serializeInventory(Inventory inventory);

}
