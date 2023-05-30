package pe.edu.upc.digitalholics.appmobile.ui.srceens.HomePatients

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.edu.upc.digitalholics.appmobile.R

@Composable
fun HomePatient(){
    Column() {
        FirstHome()
        LongCard()
        MyTreatments()
        MyPhysiotherapists()
        Footer()
    }
}

@Composable
fun FirstHome(){
    Text("Hello, Luis", modifier = Modifier.padding(12.dp))
    Text("Today appointment", modifier = Modifier.padding(start = 12.dp))
}

@Composable
fun MyPhysiotherapists() {
    Text("My physiotherapists", modifier = Modifier.padding(start = 12.dp))
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
                Text(text = "physiotherapists name", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(3f))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
                Text(text = "physiotherapists name", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(3f))
            }
        }
    }
}


@Composable
fun MyTreatments(){
    Text("My treatments", modifier = Modifier.padding(start = 12.dp))
    Surface(
        modifier = Modifier
            .padding(start = 16.dp),
        shape = MaterialTheme.shapes.medium,
        color = Color.Transparent
    ) {
        Row() {
            Column(modifier = Modifier.padding(3.dp)) {
                //image
                Image(painter = painterResource(id = R.drawable.lumbar),
                    contentDescription = null,
                    modifier = Modifier
                        .width(170.dp)
                        .height(170.dp)
                        .padding(3.dp)
                )
//                Spacer(modifier = Modifier.height(80.dp))
                Text(text = "treatment.title", fontWeight = FontWeight.Bold)
                Text(text = "Quantity Sessions:")
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(6.dp)) {
                    Text(text = "Info")
                }
            }
            Column(modifier = Modifier.padding(3.dp)) {
                //image
                Image(painter = painterResource(id = R.drawable.lumbar),
                    contentDescription = null,
                    modifier = Modifier
                        .width(170.dp)
                        .height(170.dp)
                        .padding(3.dp)
                )
//                Spacer(modifier = Modifier.height(80.dp))
                Text(text = "treatment.title", fontWeight = FontWeight.Bold)
                Text(text = "Quantity Sessions:")
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(6.dp)) {
                    Text(text = "Info")
                }
            }
        }
    }

}

@Composable
fun LongCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
                Text(text = "Patient name 1", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(6f))
                Text(
                    text = "00:00",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 8.dp)
                )
            }
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

