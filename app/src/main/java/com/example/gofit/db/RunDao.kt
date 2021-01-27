package com.example.gofit.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(run: Run)

    @Delete
    suspend fun delete(run: Run)

    @Query("SELECT * FROM running_table ORDER  BY timeStamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER  BY avgSpeed DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER  BY distanceInMeters DESC")
    fun getAllRunsSortedByDistanceInMeters(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER  BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER  BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters(): LiveData<Int>

    @Query("SELECT AVG(avgSpeed) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}