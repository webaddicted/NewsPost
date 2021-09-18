package com.example.myapplication.global.koin


import com.example.myapplication.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
}