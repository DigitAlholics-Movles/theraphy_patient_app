package pe.edu.upc.digitalholics.appmobile.data.model

data class Appointment(
    val id: String,
//    userId: String,
    val diagnosis: String,
    val done: String,
    val scheduledDate: String,
    val topic: String,
    val patientId: String,
    val physiotherapist: String
)
