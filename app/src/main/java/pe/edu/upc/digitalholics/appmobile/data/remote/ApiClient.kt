package pe.edu.upc.digitalholics.appmobile.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://backendproyectotheraphy-production.up.railway.app/api/v1/"
    private var patientInterface: PatientInterface? = null

    //esto llama al API
    fun build(): PatientInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        patientInterface = retrofit.create(PatientInterface::class.java)
        return patientInterface as PatientInterface
    }
}