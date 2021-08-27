package com.vxsoftware.quickgeometry.ui.rectangular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RectangleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Rectangular Geometry"
    }
    val text: LiveData<String> = _text
}