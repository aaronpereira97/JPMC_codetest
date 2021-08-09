package com.aaron.jpmc.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aaron.jpmc.database.AlbumDatabase
import com.aaron.jpmc.database.DatabaseAlbum
import com.aaron.jpmc.database.asDomainModel
import com.aaron.jpmc.network.ApiServices
import com.aaron.jpmc.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepository(private val ApiServices: ApiServices, private val database: AlbumDatabase) {
    suspend fun refresh(){
        // worker thread to perform API request and save data locally
        withContext(Dispatchers.IO){
            val albumList = ApiServices.getAlbum().await()
            database.albums.insertAll(albumList)
        }
    }

    val results: LiveData<List<DatabaseAlbum>> = Transformations.map(database.albums.getLocalDBAlbums()){
        it.asDomainModel()
    }
}