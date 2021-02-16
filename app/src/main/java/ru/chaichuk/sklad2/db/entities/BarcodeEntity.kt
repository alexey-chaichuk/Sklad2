package ru.chaichuk.sklad2.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.chaichuk.sklad2.db.SkladDbContract

@Entity(tableName = SkladDbContract.Barcodes.TABLE_NAME,
    indices = [Index(SkladDbContract.Barcodes.COLUMN_NAME_ID)])
data class BarcodeEntity(

    @PrimaryKey
    @ColumnInfo(name = SkladDbContract.Barcodes.COLUMN_NAME_ID)
    val id: Int,

    @ColumnInfo(name = SkladDbContract.Barcodes.COLUMN_NAME_CODE)
    val code: String,

)