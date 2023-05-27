package pe.edu.upc.digitalholics.appmobile.data.remote

import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TreatmentInterface {
    @GET("treatments")
    fun getAllTreatments(): Call<TreatmentResponse>

    @GET("treatments/{index}")
    fun getTreatmentById(@Path("index")index: String): Call<Treatment>
    @POST("treatments")
    suspend fun postNewTreatment(@Body treatment: Treatment): Response<Treatment>


}
