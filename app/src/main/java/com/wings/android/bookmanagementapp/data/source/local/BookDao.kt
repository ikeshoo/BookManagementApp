package com.wings.android.bookmanagementapp.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert
    suspend fun insert(book: Book): Long

    @Query("SELECT * FROM book_table2 WHERE isbn = :isbn")
    fun getBook(isbn: Long): Flow<Book>

    @Query("SELECT * FROM book_table2")
    fun getAll(): Flow<List<Book>>
}
