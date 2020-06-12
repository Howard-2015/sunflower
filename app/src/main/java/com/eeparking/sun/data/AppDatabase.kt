package com.eeparking.sun.data

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import com.eeparking.sun.data.repository.PlantDao
import com.eeparking.sun.utils.DATABASE_NAME

/**
 * @author   linhaidong
 * @datetime 2020-06-12 15:43 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
@Database(entities = [Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
//                            val request = OneTimeWorkRequestBuilder<Seed>()
                        }
                    }
                ).build()

        }
    }
}