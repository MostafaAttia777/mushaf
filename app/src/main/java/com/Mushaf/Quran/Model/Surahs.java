package com.Mushaf.Quran.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Surahs implements Serializable {

    private String number;

    public String getName() {
        return name;
    }

    private String name;
    private String englishName;
    private String englishNameTranslation;
    private String revelationType;
    private List<Ayahs> ayahs;

    private boolean links;

    public Surahs() {

    }

    public Surahs(String number, String name, String englishName, String englishNameTranslation, String revelationType, List<Ayahs> ayahs) {
        this.number = number;
        this.name = name;
        this.englishName = englishName;
        this.englishNameTranslation = englishNameTranslation;
        this.revelationType = revelationType;
        this.ayahs = ayahs;
    }

    public Surahs(ArrayList<Surahs> surahs) {
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEnglishName() {
        return englishName;
    }
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishNameTranslation() {
        return englishNameTranslation;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation = englishNameTranslation;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    public List<Ayahs> getAyahs() {
        return ayahs;
    }

    public void setAyahs(List<Ayahs> ayahs) {
        this.ayahs = ayahs;
    }

    public boolean getLinks() {
        return links;
    }
}
