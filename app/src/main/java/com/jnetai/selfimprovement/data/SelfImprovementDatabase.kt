package com.jnetai.selfimprovement.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jnetai.selfimprovement.model.*

@Database(entities = [Improvement::class, Lesson::class, ErrorLog::class], version = 1, exportSchema = false)
abstract class SelfImprovementDatabase : RoomDatabase() {
    abstract fun dao(): SelfImprovementDao
    companion object {
        @Volatile private var INSTANCE: SelfImprovementDatabase? = null
        fun getInstance(context: Context): SelfImprovementDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, SelfImprovementDatabase::class.java, "selfimprovement.db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}