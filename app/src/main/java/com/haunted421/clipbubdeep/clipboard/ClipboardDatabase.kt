package com.haunted421.clipbubdeep.clipboard

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [ClipboardEntry::class], version = 1, exportSchema = false)
abstract class ClipboardDatabase : RoomDatabase() {
abstract fun clipboardDao(): ClipboardDao

}
