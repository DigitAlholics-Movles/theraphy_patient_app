package pe.edu.upc.digitalholics.appmobile.data.remote

import pe.edu.upc.digitalholics.appmobile.data.model.Appointment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientAppointment {
        private const val API_BASE_URL = "https://backendproyectotheraphy-production.up.railway.app/api/v1/"
        private var appointmentInterface: AppointmentInterface? = null

        //esto llama al API
        fun build(): AppointmentInterface{
            val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            appointmentInterface = retrofit.create(AppointmentInterface::class.java)
            return appointmentInterface as AppointmentInterface
        }
    }