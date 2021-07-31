package com.Mushaf.Quran.RoOm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.ArrayList;
    @Entity(tableName = "Tableforpersons")
    public class Tableforpersons extends ArrayList<Tableforpersons> {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "job")
    String job;
    @ColumnInfo(name = "photo")
    String photo;
    @ColumnInfo(name="rat")
    float rat;
    public Tableforpersons() {
    }
    public Tableforpersons(String name, String job, String photo,float rat) {
        this.name = name;
        this.job = job;
        this.photo = photo;
        this.rat=rat;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public float getRat() {
        return rat;
    }
    public void setRat(float rat) {
        this.rat = rat;
    }
}
