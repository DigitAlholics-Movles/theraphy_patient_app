package pe.edu.upc.digitalholics.appmobile.data.model

data class Physiotherapist(
    val id: Int,
    val firstName: String,
    val paternalSurname: String,
    val maternalSurname: String,
    val age: String,
    val rating: String,
    val location: String,
    val photoUrl: String,
    val birthdayDate: String,
    val consultationsQuantity: String,
    val specialization: String,
    val email: String,
    val userId: String
)
