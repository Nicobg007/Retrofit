package me.nicolasbernal.retrofit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(val photos: List<MarsPhoto>)

@Serializable
data class MarsPhoto(
    val id: Int,
    @SerialName("img_src") val imgSrc: String,
    @SerialName("earth_date") val earthDate: String,
    val camera: Camera
)

@Serializable
data class Camera(@SerialName("full_name") val fullName: String)
