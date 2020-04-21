package com.example.kliqrdemoapplication.screens


import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (): ViewModelProvider.NewInstanceFactory(){
    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T = (ViewModel() as T)
}