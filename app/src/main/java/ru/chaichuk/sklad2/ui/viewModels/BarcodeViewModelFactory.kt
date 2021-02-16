package ru.chaichuk.sklad2.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BarcodeViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        BarcodeViewModel::class.java -> BarcodeViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}
