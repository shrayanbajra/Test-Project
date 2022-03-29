package com.example.bajralibrary.ui.pagination

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bajralibrary.network.PicSumApiService
import com.example.bajralibrary.ui.pagination.dto.PicSumDto
import com.example.bajralibrary.utils.NetworkUtils
import com.example.testproject.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PaginationRepository private constructor(private val picSumApiService: PicSumApiService) {

    companion object {

        private const val TAG = "PaginationRepository"

        private var instance: PaginationRepository? = null

        fun getInstance(picSumApiService: PicSumApiService): PaginationRepository {

            if (instance == null) {
                instance = PaginationRepository(picSumApiService = picSumApiService)
            }
            return instance!!

        }

    }

    suspend fun getList(): MutableLiveData<NetworkResult<List<PicSumDto>>> {

        val result = MutableLiveData<NetworkResult<List<PicSumDto>>>()

        withContext(Dispatchers.IO) {

            val hasNoInternetConnection = NetworkUtils.hasNoInternetConnection()

            if (hasNoInternetConnection) {

                Log.d(TAG, "getList: No Internet Connection")
                result.postValue(NetworkResult.Error("No Internet connection!"))
                return@withContext

            }

            Log.d(TAG, "getList: Loading")
            result.postValue(NetworkResult.Loading())

            try {

                Log.d(TAG, "getList: Making network request")
                val networkResponse = picSumApiService.getList(page = 1, limit = 20)
                if (networkResponse.isSuccessful) {

                    val responseBody = networkResponse.body()
                    if (responseBody == null) {

                        Log.d(TAG, "getList: Error -> ${networkResponse.message()}")
                        result.postValue(NetworkResult.Error(networkResponse.message()))

                    } else {

                        Log.d(TAG, "getList: Success -> $responseBody")
                        result.postValue(NetworkResult.Success(responseBody))

                    }

                } else {

                    Log.d(TAG, "getList: Error -> ${networkResponse.message()}")
                    result.postValue(NetworkResult.Error(networkResponse.message()))

                }

            } catch (e: Exception) {

                Log.d(TAG, "getList: Error -> ${e.message}")
                result.postValue(NetworkResult.Error(e.message))

            }

        }

        return result

    }

}