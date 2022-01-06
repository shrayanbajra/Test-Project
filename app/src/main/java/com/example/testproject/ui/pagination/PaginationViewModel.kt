package com.example.testproject.ui.pagination

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PicSumClient
import kotlinx.coroutines.launch

class PaginationViewModel : ViewModel() {

    private val repository by lazy {
        val picSumApiService = PicSumClient.getInstance()
        PaginationRepository.getInstance(picSumApiService = picSumApiService)
    }

    fun getList(): MutableLiveData<String?> {

        val items = MutableLiveData<String?>()

        viewModelScope.launch {

            items.value = repository.getList()

        }

        return items

    }

}