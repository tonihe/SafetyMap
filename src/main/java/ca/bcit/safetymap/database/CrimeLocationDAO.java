package ca.bcit.safetymap.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CrimeLocationDAO
{
    @Query("SELECT COUNT(*) FROM crimelocation")
    int count();

    @Query("SELECT * FROM crimelocation")
    List<CrimeLocation> getAll();

//    @Query("SELECT id FROM crimelocation")
//    List<String> getAllId();

    @Insert
    void insertAll(CrimeLocation... crimeLocations);

    @Delete
    void delete(CrimeLocation crimeLocation);


    
}
