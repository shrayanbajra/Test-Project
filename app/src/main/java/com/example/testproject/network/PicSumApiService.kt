package com.example.testproject.network

import com.example.testproject.ui.pagination.dto.PicSumDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicSumApiService {

    @GET("v2/list")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<PicSumDto>>

}