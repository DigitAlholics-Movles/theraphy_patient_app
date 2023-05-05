package pe.edu.upc.digitalholics.appmobile.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.upc.digitalholics.appmobile.data.model.Patient

data class ApiResponse(
    @SerializedName("content")
    val patients : ArrayList<Patient>
)
