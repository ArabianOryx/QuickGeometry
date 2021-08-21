package com.vxsoftware.quickgeometry.ui.circle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CircleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Circle Geometry"
    }
    val text: LiveData<String> = _text
}