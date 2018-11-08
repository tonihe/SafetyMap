package ca.bcit.safetymap.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CrimeLocation.class}, version = 1, exportSchema = false)
public abstract class CrimeLocationDatabase extends RoomDatabase
{
    public abstract CrimeLocationDAO crimeLocationDao();
}
