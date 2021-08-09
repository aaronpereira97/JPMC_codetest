package com.aaron.jpmc.DI

import com.aaron.jpmc.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel { MainViewModel(get()) }
}