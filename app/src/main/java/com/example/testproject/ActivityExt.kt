package com.example.testproject

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showShortToast(@StringRes message: Int) {

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

fun AppCompatActivity.showShortToast(message: String) {

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}