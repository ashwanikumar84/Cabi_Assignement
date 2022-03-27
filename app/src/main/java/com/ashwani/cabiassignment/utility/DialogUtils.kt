package com.ashwani.cabiassignment.utility

import android.view.View
import android.widget.LinearLayout
import com.ashwani.cabiassignment.R
import com.ashwani.cabiassignment.base.CabiApplication
import com.google.android.material.snackbar.Snackbar

class DialogUtils {
    companion object {
        fun showSnackBar(view: View) {
            val snackbar: Snackbar = Snackbar.make(view,
                CabiApplication.applicationContext().getString(R.string.NETWORK_ERROR),
                Snackbar.LENGTH_LONG
            )
            val snackbarLayout = snackbar.view
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            //      Layout must match parent layout type
            lp.setMargins(0, 0, 0, 0)

            snackbarLayout.layoutParams = lp
            snackbarLayout.setBackgroundColor(
                CabiApplication.applicationContext().getResources()
                    .getColor(R.color.red_light)
            )
            snackbar.setActionTextColor(
                CabiApplication.applicationContext().getResources().getColor(R.color.white)
            )
            snackbar.show()
        }
    }
}