package com.aaron.jpmc.network

import com.aaron.jpmc.database.DatabaseAlbum
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiServices {
    @GET(API_Calls.API_ALBUMS_LIST)
    fun getAlbum(): Deferred<List<DatabaseAlbum>>
}