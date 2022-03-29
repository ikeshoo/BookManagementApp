package com.wings.android.bookmanagementapp.util

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.serialization.SerializationException
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class BookSerializer(
    private val stringFormat: StringFormat = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }
) : Serializer<Book> {
    // ToDo: デフォルト値を追加する
    override val defaultValue: Book
        get() = Book.TEST

    override suspend fun readFrom(input: InputStream): Book {
        try {
            val bytes = input.readBytes()
            val string = bytes.decodeToString()
            return stringFormat.decodeFromString(string)
        } catch (e: SerializationException) {
            throw CorruptionException("Cannot read stored data", e)
        }
    }

    override suspend fun writeTo(t: Book, output: OutputStream) {
        val string = stringFormat.encodeToString(t)
        val bytes = string.encodeToByteArray()
        output.write(bytes)
    }
}
