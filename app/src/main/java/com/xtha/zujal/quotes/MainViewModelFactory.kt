package com.example.retrofittest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xtha.zujal.quotes.MainViewModel
import com.xtha.zujal.quotes.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}