package com.example.bajralibrary.ui.pagination

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bajralibrary.network.NetworkResult
import com.example.bajralibrary.network.PicSumClient
import com.example.bajralibrary.ui.pagination.data_source.ItemsDataSource
import com.example.bajralibrary.ui.pagination.dto.PicSumDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PaginationViewModel : ViewModel() {

    private val repository by lazy {
        val picSumApiService = PicSumClient.getInstance()
        PaginationRepository.getInstance(picSumApiService = picSumApiService)
    }

    val items: Flow<PagingData<PicSumDto>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = {
                val picSumApiService = PicSumClient.getInstance()
                ItemsDataSource(service = picSumApiService)
            }
        ).flow.cachedIn(viewModelScope)

    fun getList(): MutableLiveData<NetworkResult<List<PicSumDto>>> {

        var items = MutableLiveData<NetworkResult<List<PicSumDto>>>()

        viewModelScope.launch {

            items = repository.getList()

        }

        return items

    }

}