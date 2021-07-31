package com.Mushaf.Quran.RoOm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TableDao {

@Insert
    void insertdata(ArrayList<Tableforpersons> tableforpersons);
@Update
    void updatadata(Tableforpersons tableforpersons);
@Delete

    void deletetdata(Tableforpersons tableforpersons);

@Query("SELECT *FROM Tableforpersons")
    List<Tableforpersons> getall();

    @Query("DELETE FROM Tableforpersons ")
          void deleteAll();
}
