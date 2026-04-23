package com.jnetai.selfimprovement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "improvements", indices = [Index("title")])
data class Improvement(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val category: String = "General",
    val description: String = "",
    val priority: String = "Medium",
    val status: String = "Proposed",
    val impact: String = "Low",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "lessons", indices = [Index("date")])
data class Lesson(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String = "",
    val category: String = "Insight",
    val date: String = "",
    val context: String = "",
    val actionTaken: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "errors", indices = [Index("date")])
data class ErrorLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val errorType: String = "Runtime",
    val description: String = "",
    val stackTrace: String = "",
    val resolution: String = "",
    val status: String = "Open",
    val date: String = "",
    val recurrence: Int = 1,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)