package com.ashwani.cabiassignment.base

import android.app.Application
import android.content.Context
import android.widget.Toast

class CabiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: CabiApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}