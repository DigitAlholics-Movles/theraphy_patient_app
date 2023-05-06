package pe.edu.upc.digitalholics.appmobile.data.model

data class Patient(
    val id: String,
//    userId: String,
    val firstName: String,
    val lastName: String,
    val appointmentQuantity: String,
    val email: String,
    val age: String,
    val photoUrl: String,
    val birthdayDate: String,
    )
