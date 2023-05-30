package pe.edu.upc.digitalholics.appmobile.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://backendproyectotheraphy-production-41c2.up.railway.app/api/v1/"
    private var patientInterface: PatientInterface? = null
    private var treatmentInterface: TreatmentInterface? = null
    private var reviewInterface: ReviewInterface? = null

    //esto llama al API
    fun buildPatientInterface(): PatientInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        patientInterface = retrofit.create(PatientInterface::class.java)
        return patientInterface as PatientInterface
    }

    fun buildTreatmentInterface(): TreatmentInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        treatmentInterface = retrofit.create(TreatmentInterface::class.java)
        return treatmentInterface as TreatmentInterface
    }

    fun buildReviewInterface(): ReviewInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        reviewInterface = retrofit.create(ReviewInterface::class.java)
        return reviewInterface as ReviewInterface
    }
}