package com.wings.android.bookmanagementapp.util

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.wings.android.bookmanagementapp.view.model.BookList
import kotlinx.serialization.SerializationException
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object BookListSerializer : Serializer<BookList> {
    override val defaultValue: BookList
        get() = BookList.Default

    private val stringFormat: StringFormat = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    override suspend fun readFrom(input: InputStream): BookList {
        try {
            val bytes = input.readBytes()
            val string = bytes.decodeToString()
            return stringFormat.decodeFromString(string)
        } catch (e: SerializationException) {
            throw CorruptionException("Cannot read stored data", e)
        }
    }

    override suspend fun writeTo(t: BookList, output: OutputStream) {
        val string = stringFormat.encodeToString(t)
        val bytes = string.encodeToByteArray()
        output.write(bytes)
    }
}
