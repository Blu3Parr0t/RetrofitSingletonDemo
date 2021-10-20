package com.example.retrofitsingetondemo.data.network.repo

import com.example.retrofitsingetondemo.data.model.HearthStoneResponse
import com.example.retrofitsingetondemo.data.model.networkmodel.ServiceResult
import com.example.retrofitsingetondemo.data.network.repoImpl.HearthStoneRepoImpl
import kotlinx.coroutines.CoroutineDispatcher

interface HearthStoneRepo {
    suspend fun fetchHearthStoneClasses(viewModelDispatcher: CoroutineDispatcher): ServiceResult<HearthStoneResponse?>

    companion object {
        fun provideHeartStoneRepo(): HearthStoneRepo{
            return HearthStoneRepoImpl()
        }
    }
}
