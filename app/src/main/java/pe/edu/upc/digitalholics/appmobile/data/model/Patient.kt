package pe.edu.upc.digitalholics.appmobile.data.model

data class Patient(
    val id: String,
//    userId: String,
    val firstName: String,
    val lastName: String,
    val age: String,
    val birthdayDate: String,
    val email: String,
    val appointmentQuantity: String,
    val photoUrl: String,
)
