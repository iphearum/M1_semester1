package edu.itc.gic.m1.semester1.db;


import java.lang.reflect.Constructor;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ContributorDAO {
    @Query("SELECT * FROM contributor")
    List<Constructor> listAll();

    // File: SongDao.java
    @Query("SELECT * FROM contributor  WHERE login IN (:name)")
    List<Comparable> listByLogin(String... name);

    @Insert
    void insertAll(Constructor... constructors);
    @Delete
    void delete(Constructor constructor);
}
