package com.tuershen.nbtlibrary;

import com.tuershen.nbtlibrary.api.CompoundLibraryApi;
import com.tuershen.nbtlibrary.bstats.Metrics;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * @auther Tuershen Create Date on 2020/12/28
 */
public class NBTLibraryMain extends JavaPlugin {

    public static NBTLibraryMain plugin;

    public static CompoundLibraryApi libraryApi;

    @Override
    public void onEnable() {
        plugin = this;
        libraryApi = CompoundLibraryManager.getPluginManager(this);
        Bukkit.getConsoleSender().sendMessage("§eNBT前置库加载成功");
        Bukkit.getConsoleSender().sendMessage("§e作者:兔儿神");
        Bukkit.getConsoleSender().sendMessage("§e插件已开源，发现bug可以加群反馈，感激不尽");
        Bukkit.getConsoleSender().sendMessage("§e插件交流群:978420514");
        Bukkit.getConsoleSender().sendMessage("§e最新版本: v1.0.2");
        registerBStats();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§eNBT前置库卸载");
    }

    public void registerBStats(){
        new Metrics(this,9823);
    }
}
