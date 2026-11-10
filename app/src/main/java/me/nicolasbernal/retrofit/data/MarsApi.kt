package me.nicolasbernal.retrofit.data

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MarsApi {
    @GET("rovers/curiosity/photos")
    suspend fun getPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") apiKey: String = "DEMO_KEY"
    ): PhotosResponse
}

object RetrofitClient {
    private val json = Json { ignoreUnknownKeys = true }

    val api: MarsApi = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(MarsApi::class.java)
}
