package com.iapp.androidmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iapp.androidmvvm.Injection
import com.iapp.androidmvvm.repo.MainRepository

class VPNViewModel(
    private val repository: MainRepository
) : ViewModel() {

    /** VIEW MODEL FACTORY **/
   /* class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return VPNViewModel(
                Injection.getMainRepository()
            ) as T
        }
    }*/
}
