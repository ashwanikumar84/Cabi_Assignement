package com.ashwani.cabiassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ashwani.cabiassignment.repository.CabiRepository

open class BaseViewModal(application: Application) : AndroidViewModel(application) {

    val appRepository by lazy {
        CabiRepository()
    }
}