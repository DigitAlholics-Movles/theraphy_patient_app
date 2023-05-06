package pe.edu.upc.digitalholics.appmobile.data.remote

import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PatientInterface {

    @GET("patients")
    fun getAllPatients(): Call<ApiResponse>

    @GET("patients/{index}")
    fun getPatientById(@Path("index")index: String): Call<Patient>





}