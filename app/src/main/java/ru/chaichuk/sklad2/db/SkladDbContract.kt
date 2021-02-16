package ru.chaichuk.sklad2.db

import android.provider.BaseColumns

object SkladDbContract {

    const val DATABASE_NAME = "sklad.db"

    object Barcodes {
        const val TABLE_NAME = "barcodes"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_CODE = "code"
    }
}
