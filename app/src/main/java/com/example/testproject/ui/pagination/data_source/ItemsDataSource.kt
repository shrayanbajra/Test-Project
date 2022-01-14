package com.example.testproject.ui.pagination.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testproject.network.PicSumApiService
import com.example.testproject.ui.pagination.dto.PicSumDto

class ItemsDataSource(private val service: PicSumApiService) : PagingSource<Int, PicSumDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PicSumDto> {

        var pageNumber = params.key ?: 1

        return try {

            val response = service.getList(page = pageNumber, limit = 10)
            val pagedResponse = response.body()

            val nextPageNumber: Int = pageNumber + 1

            LoadResult.Page(
                data = pagedResponse.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (e: Exception) {

            LoadResult.Error(e)

        }

    }

    override fun getRefreshKey(state: PagingState<Int, PicSumDto>): Int? {

        TODO("Not yet implemented")

    }

}