package com.example.retrofitsingetondemo.ui.homescreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofitsingetondemo.data.model.networkmodel.ServiceResult
import com.example.retrofitsingetondemo.data.network.repo.HearthStoneRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeScreenViewModel(app: Application, val repo: HearthStoneRepo) : AndroidViewModel(app) {

    private val _heartStoneClasses = MutableLiveData<List<String?>?>()
    val heartStoneClasses: LiveData<List<String?>?> = _heartStoneClasses

    fun fetchClassList() {
        val dispatcher = Dispatchers.IO

        viewModelScope.launch(dispatcher) {
            when(val response = repo.fetchHearthStoneClasses(dispatcher)) {
                is ServiceResult.Success -> {
                    _heartStoneClasses.postValue(response.data?.classes)
                }

                is ServiceResult.Error -> {
                    Timber.d("Error was found when calling Heartstone classes :: ${response.exception}")
                }

                else -> {
                    Timber.d("Oh- oh... You've done fucked up...")
                }
            }
        }
    }
}
