package com.ashwani.cabiassignment.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ashwani.cabiassignment.base.CabiApplication
import com.ashwani.cabiassignment.model.Nation

@Database(entities = [Nation::class], version = CabiRoomDatabase.DB_VERSION, exportSchema = false)
abstract class CabiRoomDatabase: RoomDatabase(){

    companion object {
        const val DB_VERSION = 1
        val DB_NAME = "cabi_db"
        private val cabiRoomDataBaseCallBack = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
            }
        }

        private var DB_INSTANCE: CabiRoomDatabase? = null

        fun getDataBase(): CabiRoomDatabase {

            if (DB_INSTANCE == null) {
                synchronized(CabiRoomDatabase::class) {
                    DB_INSTANCE = Room.databaseBuilder(
                        CabiApplication.applicationContext(),
                        CabiRoomDatabase::class.java,
                        DB_NAME
                    ).addCallback(cabiRoomDataBaseCallBack)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build()
                }
            }
            return DB_INSTANCE!!
        }
    }
    open abstract fun getNationsDao(): CabiNationDao
}

