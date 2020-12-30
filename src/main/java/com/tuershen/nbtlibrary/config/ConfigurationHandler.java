package com.tuershen.nbtlibrary.config;

import com.tuershen.nbtlibrary.exception.Region;

import java.io.File;
import java.util.List;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public class ConfigurationHandler {

    private List<Region> serverRegion;

    public ConfigurationHandler(List<Region> serverRegion) {
        this.serverRegion = serverRegion;
    }

    public void loadFile(File file){

    }

    public List<Region> getServerRegion() {
        return serverRegion;
    }

    public void setServerRegion(List<Region> serverRegion) {
        this.serverRegion = serverRegion;
    }



}
