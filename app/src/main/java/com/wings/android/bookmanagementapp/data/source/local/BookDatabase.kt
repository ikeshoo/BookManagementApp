package com.wings.android.bookmanagementapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wings.android.bookmanagementapp.view.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
