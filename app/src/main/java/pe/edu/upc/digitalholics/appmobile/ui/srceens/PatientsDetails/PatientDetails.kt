package pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.digitalholics.appmobile.data.model.Patient

@Composable
fun PatientDetails(patient: Patient){
    Column{
        Text(text = "Name: ${patient.firstName}")
        Text(text = "LastName: ${patient.lastName}")
        Text(text = "Email: ${patient.email}")
    }
}