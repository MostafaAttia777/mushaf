package com.Mushaf.Quran.Model;

import java.io.Serializable;
import java.util.List;

public class Data  implements Serializable {
    private List<Surahs> surahs;
    private Edition edition;

    public List<Surahs> getSurahs() {
        return surahs;
    }

    public void setSurahs(List<Surahs> surahs) {
        this.surahs = surahs;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}
