package com.example.inswap.di

import android.content.Context
import com.example.inswap.data.Repository
import com.example.inswap.data.pref.UserPreference
import com.example.inswap.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context) : Repository{
        val pref = UserPreference.getInstance(context.dataStore)
        return Repository.getInstance(pref)
    }
}