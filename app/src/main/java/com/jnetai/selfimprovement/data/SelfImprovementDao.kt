package com.jnetai.selfimprovement.data

import androidx.room.*
import com.jnetai.selfimprovement.model.Improvement
import com.jnetai.selfimprovement.model.Lesson
import com.jnetai.selfimprovement.model.ErrorLog

@Dao
interface SelfImprovementDao {
    @Query("SELECT * FROM improvements ORDER BY createdAt DESC") suspend fun getAllImprovements(): List<Improvement>
    @Query("SELECT * FROM improvements WHERE id = :id") suspend fun getImprovement(id: Long): Improvement?
    @Insert suspend fun insertImprovement(improvement: Improvement): Long
    @Update suspend fun updateImprovement(improvement: Improvement)
    @Delete suspend fun deleteImprovement(improvement: Improvement)

    @Query("SELECT * FROM lessons ORDER BY createdAt DESC") suspend fun getAllLessons(): List<Lesson>
    @Query("SELECT * FROM lessons WHERE id = :id") suspend fun getLesson(id: Long): Lesson?
    @Insert suspend fun insertLesson(lesson: Lesson): Long
    @Update suspend fun updateLesson(lesson: Lesson)
    @Delete suspend fun deleteLesson(lesson: Lesson)

    @Query("SELECT * FROM errors ORDER BY createdAt DESC") suspend fun getAllErrors(): List<ErrorLog>
    @Query("SELECT * FROM errors WHERE id = :id") suspend fun getError(id: Long): ErrorLog?
    @Insert suspend fun insertError(error: ErrorLog): Long
    @Update suspend fun updateError(error: ErrorLog)
    @Delete suspend fun deleteError(error: ErrorLog)
}