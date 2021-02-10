package com.xtha.zujal.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xtha.zujal.quotes.models.Quote
import retrofit2.Response
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myResponse: MutableLiveData<Response<Quote>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}