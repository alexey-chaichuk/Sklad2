package ru.chaichuk.sklad2.db.daos

import androidx.room.*
import ru.chaichuk.sklad2.db.SkladDbContract
import ru.chaichuk.sklad2.db.entities.BarcodeEntity

@Dao
interface BarcodesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(actors: List<BarcodeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(actor: BarcodeEntity)

    @Query("DELETE FROM " + SkladDbContract.Barcodes.TABLE_NAME)
    suspend fun deleteAll()

    @Delete
    suspend fun delete(barcode : BarcodeEntity)

    @Query("SELECT * FROM " + SkladDbContract.Barcodes.TABLE_NAME + " ORDER BY " + SkladDbContract.Barcodes.COLUMN_NAME_CODE + " DESC")
    suspend fun getAll(): List<BarcodeEntity>

    @Query("SELECT * FROM "  + SkladDbContract.Barcodes.TABLE_NAME + " WHERE " + SkladDbContract.Barcodes.COLUMN_NAME_ID +  " = :id")
    suspend fun getById(id: Int): BarcodeEntity
}