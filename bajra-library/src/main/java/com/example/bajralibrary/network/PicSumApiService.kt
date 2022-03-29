package com.example.bajralibrary.network

import com.example.bajralibrary.ui.pagination.dto.PicSumDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicSumApiService {

    @GET("v2/list")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<PicSumDto>>

    @GET("v2/list")
    suspend fun getPictures(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): ApiResponse<List<PicSumDto>>

}