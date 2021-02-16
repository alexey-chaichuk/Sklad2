package ru.chaichuk.sklad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.chaichuk.sklad2.ui.fragments.BarcodeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BarcodeFragment())
                    .commitNow()
        }
    }
}