package com.example.testproject.ui.sandwich

import com.example.bajralibrary.network.PicSumApiService
import com.example.bajralibrary.ui.pagination.dto.PicSumDto
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SandwichRepository private constructor(private val picSumApiService: PicSumApiService) {

    companion object {

        private const val TAG = "SandwichRepository"

        private var instance: SandwichRepository? = null

        fun getInstance(picSumApiService: PicSumApiService): SandwichRepository {

            if (instance == null) {
                instance = SandwichRepository(picSumApiService = picSumApiService)
            }
            return instance!!

        }

    }

    suspend fun getPictures(): ApiResponse<List<PicSumDto>> {

        return withContext(Dispatchers.IO) {

            return@withContext picSumApiService.getPictures()

        }

    }

}