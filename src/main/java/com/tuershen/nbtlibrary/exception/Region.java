package com.tuershen.nbtlibrary.exception;

import java.io.File;

/**
 * @auther Tuershen Create Date on 2020/12/30
 */
public class Region {

    private File region;

    public Region(File region) {
        this.region = region;
    }

    public File getRegion() {
        return region;
    }

    public void setRegion(File region) {
        this.region = region;
    }
}
