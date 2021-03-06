package com.vxsoftware.quickgeometry.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Thank you for downloading the app. Select the polygon shape that you want to calculate its Geometry from the menu"
    }
    val text: LiveData<String> = _text
}