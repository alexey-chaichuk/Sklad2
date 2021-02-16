package ru.chaichuk.sklad2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.chaichuk.sklad2.db.daos.BarcodesDao
import ru.chaichuk.sklad2.db.entities.BarcodeEntity

@Database(entities = [BarcodeEntity::class], version = 1)
abstract class SkladDataBase : RoomDatabase() {

    abstract val barcodesDao : BarcodesDao

    companion object {

        fun create(applicationContext: Context): SkladDataBase = Room.databaseBuilder(
            applicationContext,
            SkladDataBase::class.java,
            SkladDbContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}