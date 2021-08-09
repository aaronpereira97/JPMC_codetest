package com.aaron.jpmc.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.aaron.jpmc.database.DatabaseAlbum

@JsonClass(generateAdapter = true)
data class NetworkAlbumContainer(val value: List<ValueItem>)

data class ValueItem(

    @Json(name="id") val id: Int,
    @Json(name="userId") val userId: Int,
    @Json(name="title") val title: String
)

fun NetworkAlbumContainer.asDatabaseModel() : List<DatabaseAlbum> {
    return value.map {
        DatabaseAlbum(
            id = it.id,
            userId = it.userId,
            title = it.title
        )
    }
}
