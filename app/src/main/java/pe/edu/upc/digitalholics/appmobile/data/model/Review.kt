package pe.edu.upc.digitalholics.appmobile.data.model

data class Review(
    val id: Int,
    val stars: Int,
    val description: String,
    val patient: Patient,
    val physiotherapist: Physiotherapist

)
