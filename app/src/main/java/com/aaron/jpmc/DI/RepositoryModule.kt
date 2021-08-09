package com.aaron.jpmc.DI


import com.aaron.jpmc.database.AlbumDatabase
import com.aaron.jpmc.network.ApiServices
import com.aaron.jpmc.repository.AlbumRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideRepository(api: ApiServices, dao: AlbumDatabase): AlbumRepository {
        return AlbumRepository(api, dao)
    }

    single {
        provideRepository(get(), get())
    }
}