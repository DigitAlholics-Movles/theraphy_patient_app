package pe.edu.upc.digitalholics.appmobile.ui.srceens.HomePatient


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox

import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment

@Composable
fun HomePatient(
    treatments: List<Treatment>,
    selectTreatment: (String) -> Unit, patient: Patient, physiotherapist: Physiotherapist
) {
    Column() {
        FirstHome(patient)
        LongCard(patient)

//        MyTreatments(treatments)

        LazyRow() {
            itemsIndexed(treatments) { index, item ->
                MyTreatments(item) {
                    selectTreatment("${index + 1}")
                }
            }
        }


//        TreatmentItem(treatments, selectTreatment: () -> Unit)

        MyPhysiotherapists(physiotherapist)
        Footer()
    }

}

@Composable
fun FirstHome(patient: Patient){
    Text("Hello, ${patient.firstName}", modifier = Modifier.padding(12.dp),fontWeight = FontWeight.Bold)
    Text("Today appointments", modifier = Modifier.padding(start = 12.dp),fontWeight = FontWeight.Bold)
}

@Composable
fun MyPhysiotherapists(physiotherapist: Physiotherapist) {
//    con lazy column
    Spacer(modifier = Modifier.padding(top = 50.dp))
    Text("My physiotherapists", modifier = Modifier.padding(start = 12.dp), fontWeight = FontWeight.Bold)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = MaterialTheme.shapes.medium
            ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
                Text(text = "physiotherapists name: ${physiotherapist.firstName}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(3f))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
                Text(text = "physiotherapists name: ${physiotherapist.firstName}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(3f))
            }
        }
    }
}


@Composable
fun MyTreatments(treatments: Treatment, selectTreatment: () -> Unit){

    Surface(
        modifier = Modifier
            .padding(start = 16.dp),
        shape = MaterialTheme.shapes.medium,
        color = Color.Transparent
    ) {
            Row(
                modifier = Modifier.padding(2.dp).clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(132, 170, 255, 255))
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.fillMaxWidth().padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    AsyncImage(
                        model = treatments.photoUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(92.dp)
                            .padding(top = 7.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .border(BorderStroke(5.dp, Color.White)),
                        contentScale = ContentScale.Crop
                    )

                    Text(text = treatments.title, fontWeight = FontWeight.Bold)
                    Text(text = "Quantity Sessions: ${treatments.sessionsQuantity}")
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(6.dp)) {
                        Text(text = "Info")
                    }
                }
            }

    }

}



@Composable
fun LongCard(patient:Patient) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Default.Campaign, contentDescription = "Campaign Icon")
                }
                Text(text = "Patient name: ${patient.firstName}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(6f), fontWeight = FontWeight.Bold)

                Text(
                    text = "00:00",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .weight(1f)


                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 5.dp))
    Text("My treatments", modifier = Modifier.padding(start = 12.dp), fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.padding(bottom = 6.dp))
}

@Composable
fun Footer(){
    Spacer(modifier = Modifier.padding(4.dp))
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = MaterialTheme.shapes.medium
            ),
        color = Color.Transparent
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null, tint = Color.Red)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick =  { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.List, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            }
        }
    }

}

