package com.example.hbyssystemmanagement.Interface

import android.view.View

interface itemClickListener {
    fun onClick(view: View?, pozition: Int, isLongClick: Boolean)
}