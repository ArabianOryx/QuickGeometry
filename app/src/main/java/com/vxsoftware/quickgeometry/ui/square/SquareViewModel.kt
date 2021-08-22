package com.vxsoftware.quickgeometry.ui.square

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SquareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Square Geometry"
    }
    val text: LiveData<String> = _text
}