package com.lukaklacar.binaryrepository.model;

import java.io.Serializable;

public class AbstractModel implements Serializable {

    private long id;

    private boolean isSaved = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
