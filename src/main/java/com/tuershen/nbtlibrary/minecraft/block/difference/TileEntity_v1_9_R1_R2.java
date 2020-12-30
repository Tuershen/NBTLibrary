package com.tuershen.nbtlibrary.minecraft.block.difference;

import org.bukkit.block.Block;

/**
 * @auther Tuershen update Date on 2020/12/3
 */
public class TileEntity_v1_9_R1_R2 extends TileEntity_v1_8_R1_R2_R3 {

    public TileEntity_v1_9_R1_R2(Block block) {
        super(block);
    }

    public static void changeInit(String version){
        try {
            init(version);
            save = TileEntity.getDeclaredMethod("save", NBTTagCompound);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
