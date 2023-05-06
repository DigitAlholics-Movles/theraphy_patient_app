package pe.edu.upc.digitalholics.appmobile.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Patient")
class PatientEntity (
    @PrimaryKey
    val id: String
)
