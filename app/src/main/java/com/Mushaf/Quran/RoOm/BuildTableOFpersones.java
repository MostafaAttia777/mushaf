package com.Mushaf.Quran.RoOm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Tableforpersons.class, exportSchema = false, version = 2)

public abstract class BuildTableOFpersones extends RoomDatabase {

    private static final String DB_NAME = "database";
    private static BuildTableOFpersones instance;

    public static synchronized BuildTableOFpersones getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, BuildTableOFpersones.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract TableDao tableDao();
}
