package com.example.inswap.ui.upload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inswap.R

class UploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        supportActionBar?.hide()
    }
}