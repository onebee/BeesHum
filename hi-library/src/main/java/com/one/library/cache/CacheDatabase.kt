package com.one.library.cache

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.one.library.util.AppGlobals

@Database(entities = [Cache::class], version = 1)
abstract class CacheDatabase : RoomDatabase() {

    companion object {
        private var database: CacheDatabase
        fun get(): CacheDatabase {
            return database
        }

        init {
            val context = AppGlobals.get()!!.applicationContext
            database =
                Room.databaseBuilder(context, CacheDatabase::class.java, "howow_cache").build()
        }
    }

    abstract val cacheDao: CacheDao
}