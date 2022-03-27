package com.ashwani.cabiassignment.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashwani.cabiassignment.R
import com.ashwani.cabiassignment.base.CabiApplication
import com.ashwani.cabiassignment.model.Nation
import com.ashwani.cabiassignment.utility.DialogUtils
import com.ashwani.cabiassignment.utility.Utility
import com.ashwani.cabiassignment.viewmodel.NationViewModel

class MainActivity: AppCompatActivity(){

    lateinit var nationViewModel: NationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainView = findViewById<ConstraintLayout>(R.id.mainView)
        nationViewModel = ViewModelProvider(this).get(NationViewModel::class.java)
        if (Utility.isInternetAvailable()){
            nationViewModel.getNations()
        }else{
            DialogUtils.showSnackBar(mainView)
        }
        observeLiveData()

    }
    private fun observeLiveData() {
        nationViewModel?.appRepository?.getDBInstance()?.getNationsDao()?.getNations()?.observe(this, Observer {
            it ?: return@Observer
            var nationList: List<Nation> = it
            val nationRecyclerView = findViewById<View>(R.id.nationRecyclerView) as RecyclerView
            val adapter = NationListAdapter(nationList)
            nationRecyclerView.layoutManager = LinearLayoutManager(this)
            nationRecyclerView.adapter = adapter
        })
    }
}