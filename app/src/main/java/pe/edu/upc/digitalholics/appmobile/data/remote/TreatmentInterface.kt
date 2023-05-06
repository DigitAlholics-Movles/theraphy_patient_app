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

    @FormUrlEncoded
    @POST("treatments")
    fun postNewTreatment(
        @Field ("id") id: String ,
        @Field ("title") title: String,
        @Field ("description") description: String,
        @Field ("photoUrl") photoUrl: String,
        @Field ("sessionsQuantity") sessionsQuantity: String,
        @Field ("physiotherapist") physiotherapist: Physiotherapist,
    ): Response<Treatment>


}
