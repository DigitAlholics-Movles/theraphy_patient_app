package pe.edu.upc.digitalholics.appmobile.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val API_BASE_URL = "https://backendproyectotheraphy-production.up.railway.app/api/v1/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TreatmentInterface by lazy {
        retrofit.create(TreatmentInterface::class.java)
    }

}

