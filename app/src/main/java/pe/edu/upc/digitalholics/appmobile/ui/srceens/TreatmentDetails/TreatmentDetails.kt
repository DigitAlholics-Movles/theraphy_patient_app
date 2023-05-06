package pe.edu.upc.digitalholics.appmobile.ui.srceens.TreatmentDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment


@Composable
fun Treatments(treatments: List<Treatment>){
    LazyColumn(){
        itemsIndexed(treatments){ index, item ->
            TreatmentDetails(item)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentDetails(treatment: Treatment) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TreatmentTitle(treatment= treatment)
                },
                navigationIcon = {
                    IconButton(onClick = {/* acción al hacer clic en el botón */ }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = {
            Column {


                TreatmentDetailImage(treatment= treatment)
                TreatmentDescription(treatment= treatment)
                TreatmentNavBar(treatment= treatment)
            }

        }
    )



}


@Composable
fun TreatmentTitle(
    treatment: Treatment,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.width(8.dp))
    Row {
        Column(modifier = modifier.weight(7f)) {
            Text(text = treatment.title, fontWeight = FontWeight.Bold)
        }

    }
}

@Composable
fun TreatmentDetailImage(
    treatment: Treatment,
    modifier: Modifier = Modifier
){
    Spacer(modifier = modifier.height(50.dp))
    Row {
        Spacer(modifier = modifier.width(2.dp))
        Column(modifier = modifier.weight(7f)) {
           /* Image(painter = painterResource(id = R.drawable.lumbar),
                contentDescription = null,
                modifier = Modifier.width(700.dp).height(230.dp).padding(4.dp)

            )*/
        }

    }
}


@Composable
fun TreatmentDescription(
    treatment: Treatment,
    modifier: Modifier = Modifier
) {

    Spacer(modifier = modifier.height(20.dp))
    Row {
        Spacer(modifier = modifier.width(28.dp))
        Column(modifier = modifier.weight(7f)) {

            Text(text = "Description ", fontWeight = FontWeight.Bold)
        }
    }

    Spacer(modifier = modifier.height(15.dp))
    Row {
        Spacer(modifier = modifier.width(28.dp))
        Column(modifier = modifier.weight(7f)) {
            Text(text = treatment.description, fontWeight = FontWeight.Light)
        }
        Spacer(modifier = modifier.width(28.dp))

    }
    Spacer(modifier = modifier.height(15.dp))
    Row( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center){

            Button(onClick = { /* acción al hacer clic en el botón */ }) {
                Text(text = "Enroll")
            }

    }
}

@Composable
fun TreatmentNavBar(
    treatment: Treatment,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.height(120.dp))

    Box(modifier = Modifier
        .fillMaxWidth()
        .border(3.dp, Color.Magenta),contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.List, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            }
        }
    }
}



