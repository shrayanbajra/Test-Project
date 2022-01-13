package com.example.testproject.ui.pagination

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.NetworkResult
import com.example.testproject.network.PicSumClient
import com.example.testproject.ui.pagination.dto.PicSumDto
import kotlinx.coroutines.launch

class PaginationViewModel : ViewModel() {

    private val repository by lazy {
        val picSumApiService = PicSumClient.getInstance()
        PaginationRepository.getInstance(picSumApiService = picSumApiService)
    }

    fun getList(): MutableLiveData<NetworkResult<List<PicSumDto>>> {

        var items = MutableLiveData<NetworkResult<List<PicSumDto>>>()

        viewModelScope.launch {

            items = repository.getList()

        }

        return items

    }

}