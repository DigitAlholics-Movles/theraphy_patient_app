package pe.edu.upc.digitalholics.appmobile.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.upc.digitalholics.appmobile.data.local.PatientDao
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.PatientInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientRepository (
    private val patientInterface: PatientInterface,
    private val patientDao: PatientDao
){

    private val _patients = MutableLiveData<List<Patient>>(listOf())
    val patients get() = _patients

    fun fetchByName(name: String) {
        val findByName = patientInterface.findByName(name)

        findByName.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    _patients.value = response.body()!!.patients
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//                Log.d("SuperHeroRepository", t.message.toString())
            }
        })
    }

}
