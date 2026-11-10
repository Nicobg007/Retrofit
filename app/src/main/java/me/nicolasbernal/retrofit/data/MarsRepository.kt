package me.nicolasbernal.retrofit.data

class MarsRepository(private val api: MarsApi = RetrofitClient.api) {
    suspend fun getPhotos(): Result<List<MarsPhoto>> = runCatching {
        api.getPhotos().photos.map { it.copy(imgSrc = it.imgSrc.replace("http://", "https://")) }
    }
}
