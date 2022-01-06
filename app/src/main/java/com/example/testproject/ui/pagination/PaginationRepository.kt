package com.example.testproject.ui.pagination

import com.example.testproject.network.PicSumApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PaginationRepository private constructor(private val picSumApiService: PicSumApiService) {

    companion object {

        private var instance: PaginationRepository? = null

        fun getInstance(picSumApiService: PicSumApiService): PaginationRepository {

            if (instance == null) {
                instance = PaginationRepository(picSumApiService = picSumApiService)
            }
            return instance!!

        }

    }

    suspend fun getList(): String? {

        return withContext(Dispatchers.IO) {

            val response = picSumApiService.getList(page = 1, limit = 20)
            val wasNotSuccessful = response.isSuccessful
            if (wasNotSuccessful) {

                return@withContext response.message()

            }

            return@withContext response.body()

        }

    }

}