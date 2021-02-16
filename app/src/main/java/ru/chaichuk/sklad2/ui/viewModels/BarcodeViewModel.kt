package ru.chaichuk.sklad2.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BarcodeViewModel  : ViewModel() {

    private val _mutableBarcode = MutableLiveData<Int>()
    val barcode: LiveData<Int> get() = _mutableBarcode
}
