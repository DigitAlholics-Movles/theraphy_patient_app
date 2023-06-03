package pe.edu.upc.digitalholics.appmobile.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Structure( modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Spacer(modifier = modifier.width(8.dp))
                    Row(modifier = modifier) {
                        Column(modifier = Modifier.weight(7f)) {
                            Text(text = "Page Title", fontWeight = FontWeight.Bold)
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*navController.popBackStack()*/ }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = {
            LazyColumn(modifier = Modifier.padding(top = 70.dp)
                .fillMaxHeight()
                .padding(bottom = 100.dp)

               ) {
                item {

                }

            }


        },
       bottomBar = {
        Box(modifier = Modifier.background(Color.White)){
            //FooterStructure()
        }


       }
    )
}


@Composable
fun FooterStructure(navController: NavController){

    val context = LocalContext.current
    val sharedPreferences = remember {
        context.getSharedPreferences("mi_pref", Context.MODE_PRIVATE)
    }
    val id = sharedPreferences.getString("userLogged", "0")

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
        color = Color.White
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(onClick = { navController.navigate("HomePatient/${id}") }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { navController.navigate("physiotherapistList") }) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { navController.navigate("AppointmentList") }) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick =  { navController.navigate("TreatmentList") }) {
                Icon(imageVector = Icons.Default.List, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { navController.navigate("patient") }) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            }
        }
    }

}