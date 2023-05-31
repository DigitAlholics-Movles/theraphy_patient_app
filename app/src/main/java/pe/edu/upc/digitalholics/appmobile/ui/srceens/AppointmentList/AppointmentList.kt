package pe.edu.upc.digitalholics.appmobile.ui.srceens.AppointmentList

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.data.model.Appointment
import pe.edu.upc.digitalholics.appmobile.data.model.Patient

var searchedText: String = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentList(size: Number, appointments: List<Appointment>, selectAppointment: (String)-> Unit){


    Column(modifier = Modifier.padding(17.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "My Appointments", fontSize = 25.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .absolutePadding(bottom = 20.dp)
        )
        Box(
            contentAlignment = Alignment.CenterEnd, modifier = Modifier
                .absolutePadding(bottom = 25.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .border(
                    BorderStroke(1.dp, Color.Magenta)
                )
                .fillMaxWidth()
        ) {
            var text by remember {
                mutableStateOf(searchedText)
            }
            TextField(value = text, onValueChange = { text = it }, Modifier.fillMaxWidth())
            IconButton(onClick = {searchedText = text.toString()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }



        }
        //Text(text = patients.size.toString())
        //Text(text = appointments.size.toString())
        LazyColumn(Modifier.height(500.dp)){
            itemsIndexed(appointments){ index, item ->
                AppointmentItem(item){
                    selectAppointment("${index + 1}")

                }

                AppointmentItem(item){
                    selectAppointment("${index + 1}")

                }
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Magenta, shape = RoundedCornerShape(14.dp))

            ,contentAlignment = Alignment.Center
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

}


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppointmentItem(appointment: Appointment, selectAppointment: () -> Unit) {
    var name = " "
    //var patient = appointment.patient.to(Patient)
   /* for(patient in patients){
        //Text(text = appointment.physiotherapistId)
        //Text(text = appointment.patient)
        if(patient.id == appointment.patient)
            name = patient.firstName + " " + patient.lastName
    }*/
    

    Row() {
        Card(modifier = Modifier
            .absolutePadding(top = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color(212, 98, 155))
                    .fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.ghost),
                    contentDescription = null,
                    modifier = Modifier
                        .width(130.dp)
                        .height(130.dp)
                        .padding(20.dp)
                        .border(BorderStroke(5.dp, Color.White))
                )
                Column() {
                    Text(text = appointment.patient.firstName + " " +appointment.patient.lastName, fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.absolutePadding(bottom = 15.dp))
                    Row() {
                        Box(contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(25.dp)
                                .width(65.dp)
                                .absolutePadding(right = 8.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(Color(255, 255, 255))
                        ) {
                            Text(text = appointment.topic, fontSize = 10.sp,
                                modifier = Modifier.background(Color(255,255,255)))
                        }
                        Box(contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(25.dp)
                                .width(90.dp)
                                .absolutePadding(right = 10.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(Color(255, 255, 255))
                        ) {
                            Text(text = appointment.scheduledDate, fontSize = 10.sp)

                        }

                        Box(contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(25.dp)
                                .width(60.dp)
                                .absolutePadding(right = 10.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(Color(255, 255, 255))
                        ) {
                            Text(text = "4:00 pm", fontSize = 10.sp)
                        }
                    }

                }

            }

        }
    }

}