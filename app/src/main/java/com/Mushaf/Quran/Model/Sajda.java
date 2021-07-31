package com.Mushaf.Quran.Model;

import java.io.Serializable;

public class Sajda implements Serializable {
    private int id;
    private boolean recommended;
    private boolean obligatory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }
}
