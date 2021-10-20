package com.example.retrofitsingetondemo.data.network.repoImpl

import com.example.retrofitsingetondemo.data.model.HearthStoneResponse
import com.example.retrofitsingetondemo.data.model.networkmodel.ServiceResult
import com.example.retrofitsingetondemo.data.network.endpoint.HearthStoneApiEndPoints
import com.example.retrofitsingetondemo.data.network.repo.HearthStoneRepo
import com.example.retrofitsingetondemo.data.network.retrofit.RetrofitFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception

class HearthStoneRepoImpl(): HearthStoneRepo {

    val retroObject = RetrofitFactory.retrofitProvider(
        HearthStoneApiEndPoints::class.java,
        "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
    )

    override suspend fun fetchHearthStoneClasses(viewModelDispatcher: CoroutineDispatcher): ServiceResult<HearthStoneResponse?> {
        return withContext(viewModelDispatcher) {
            val dataResponse = retroObject.getInfo()

            if(dataResponse.isSuccessful) {
                ServiceResult.Success(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }

        }
    }
}

