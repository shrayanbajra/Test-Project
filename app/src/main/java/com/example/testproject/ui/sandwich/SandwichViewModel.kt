package com.example.testproject.ui.sandwich

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bajralibrary.network.PicSumClient
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.launch

class SandwichViewModel : ViewModel() {

    private val repository by lazy {
        val picSumApiService = PicSumClient.getInstance()
        SandwichRepository.getInstance(picSumApiService = picSumApiService)
    }


    fun getPictures(): LiveData<String> {

        val networkResponse = MutableLiveData<String>()

        viewModelScope.launch {

            repository.getPictures().onSuccess {

                networkResponse.value = "Success"

            }.onError {

                networkResponse.value = response.message()

            }.onException {

                networkResponse.value = message
            }

        }

        return networkResponse

    }

}