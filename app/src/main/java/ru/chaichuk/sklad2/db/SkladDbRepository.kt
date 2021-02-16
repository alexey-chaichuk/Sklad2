package ru.chaichuk.sklad2.db

import android.content.Context

class SkladDbRepository(context: Context) {

    private val skladDb = SkladDataBase.create(context)

}