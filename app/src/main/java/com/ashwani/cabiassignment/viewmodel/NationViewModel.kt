package com.ashwani.cabiassignment.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ashwani.cabiassignment.model.Nations
import com.ashwani.cabiassignment.repository.CabiRepository

class NationViewModel(application: Application): BaseViewModal(application) {

    fun getNations() {
        appRepository.getCabiNationData()
    }
}