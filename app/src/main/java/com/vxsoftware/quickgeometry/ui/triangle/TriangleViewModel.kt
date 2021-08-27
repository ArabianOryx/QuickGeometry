package com.vxsoftware.quickgeometry.ui.triangle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriangleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Triangle Geometry"
    }
    val text: LiveData<String> = _text
}