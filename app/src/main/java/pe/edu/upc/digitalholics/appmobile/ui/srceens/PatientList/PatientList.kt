package pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.edu.upc.digitalholics.appmobile.data.model.Patient

@Composable
fun PatientList(patients: List<Patient>, selectPatient: (String)-> Unit){
    LazyColumn(){
        itemsIndexed(patients){ index, item ->
            PatientItem(item){

                selectPatient("${index + 1}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PatientItem(patient: Patient, selectPatient: () -> Unit){
    Card(
        onClick = {
            selectPatient ()
        }) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            //Text(text = patient.id)
            Column{
                Text(text = "Name: ${patient.firstName}")
                Text(text = "LastName: ${patient.lastName}")
                Text(text = "Email: ${patient.email}")
                Text(text = "birthdat: ${patient.birthdayDate}")
            }
        }
    }
}