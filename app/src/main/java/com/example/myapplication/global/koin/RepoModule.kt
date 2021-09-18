package com.example.myapplication.global.koin

import com.example.myapplication.model.repo.SearchRepository
import org.koin.dsl.module
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
val repoModule = module {
    single { SearchRepository(get()) }
}