package pe.edu.upc.digitalholics.appmobile.ui.srceens.TreatmentDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

@Composable
fun Treatments(treatments: List<Treatment>){
    LazyColumn(){
        itemsIndexed(treatments){ index, item ->
            //TreatmentDetails(item)
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentDetails(treatment: Treatment, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TreatmentTitle(treatment = treatment)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    item {
                        TreatmentDetailImage(treatment = treatment)
                    }
                    item {
                        TreatmentDescription(treatment = treatment)
                    }
                }
                Footer()
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
    Row(modifier = modifier) {
        Column(modifier = Modifier.weight(7f)) {
            Text(text = treatment.title, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TreatmentDetailImage(
    treatment: Treatment,
    modifier: Modifier = Modifier
) {
    Row {
        Column(
            modifier = Modifier
                .padding(100.dp, 80.dp, 0.dp, 0.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            AsyncImage(
                model = treatment.photoUrl,
                contentDescription = null,
                modifier = modifier
                    .size(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TreatmentDescription(
    treatment: Treatment,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.height(20.dp))
    Row(modifier = modifier) {
        Spacer(modifier = modifier.width(28.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Description ", fontWeight = FontWeight.Bold)
        }
    }

    Spacer(modifier = modifier.height(15.dp))
    Row(modifier = modifier) {
        Spacer(modifier = modifier.width(28.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = treatment.description, fontWeight = FontWeight.Light)
        }
        Spacer(modifier = modifier.width(28.dp))
    }

    Spacer(modifier = modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { /* acción al hacer clic en el botón */ }) {
            Text(text = "Enroll")
        }
    }
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


