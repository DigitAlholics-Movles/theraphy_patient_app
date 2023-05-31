package pe.edu.upc.digitalholics.appmobile.ui.srceens.Payment

import android.app.ProgressDialog.show
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.ui.srceens.Schedule.DateForm
import kotlin.math.max

@Composable
fun Payment() {


    val videos = 45
    val appointments = 45
    var showDialog by remember {
        mutableStateOf(
            false
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //Text("Physiotherapist's Profile", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Go back */ },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back",
                    modifier = Modifier
                        .absolutePadding(
                            right = 5.dp,
                            bottom = 8.dp
                        )
                        .size(50.dp)
                )
            }
            Text(
                text = "Physiotherapist's Profile",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .absolutePadding(bottom = 15.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.physiotherapist),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(230.dp)
                .align(Alignment.CenterHorizontally)
                .clip(shape = CircleShape)
                .border(border = BorderStroke(7.dp, Color(0, 40, 122)), shape = CircleShape)

        )
        Text("Dr. Cristhian Gomez", fontSize = 25.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.absolutePadding(top = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            if (appointments > 20) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.absolutePadding(right = 45.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_groups_24),
                        contentDescription = "Appointments",
                        tint = Color(1,72,255),
                        modifier = Modifier
                            .size(48.dp)
                            .absolutePadding(bottom = 5.dp)
                    )
                    Text("20+", color = Color.Gray, fontWeight = FontWeight.Bold,
                        fontSize = 25.sp, modifier = Modifier.absolutePadding(bottom = 5.dp, left = 6.dp))

                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.absolutePadding(right = 45.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_groups_24),
                        contentDescription = "Appointments",
                        tint = Color(1,72,255),
                        modifier = Modifier
                            .size(48.dp)
                            .absolutePadding(bottom = 5.dp)
                    )
                    Text("$appointments", color = Color.Gray, fontWeight = FontWeight.Bold,
                        fontSize = 25.sp, modifier = Modifier.absolutePadding(bottom = 5.dp, left = 6.dp))

                }
            }
            if (videos > 15) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.absolutePadding(right = 45.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_video_library_24),
                        contentDescription = "Videos",
                        tint = Color(255,0,0),
                        modifier = Modifier
                            .size(36.dp)
                            .absolutePadding(right = 4.dp)
                    )
                    Text("15+", color = Color.Gray, fontWeight = FontWeight.Bold,
                        fontSize = 25.sp, modifier = Modifier.absolutePadding(bottom = 5.dp))
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.absolutePadding(right = 45.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_video_library_24),
                        contentDescription = "Videos",
                        tint = Color(255,0,0),
                        modifier = Modifier
                            .size(36.dp)
                            .absolutePadding(right = 2.dp)
                    )
                    Text("$videos", color = Color.Gray, fontWeight = FontWeight.Bold,
                        fontSize = 25.sp, modifier = Modifier.absolutePadding(bottom = 5.dp)
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.baseline_star_24),
                    contentDescription = "Stars",
                    tint = Color(250,200,0),
                    modifier = Modifier
                        .size(48.dp)
                        .absolutePadding(bottom = 5.dp)
                )
                Text("4.5", color = Color.Gray, fontWeight = FontWeight.Bold,
                    fontSize = 25.sp, modifier = Modifier.absolutePadding(bottom = 5.dp))

            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        CardForm()

        Spacer(modifier = Modifier.height(5.dp))


        Button(onClick = {
            showDialog = true
        },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0,122,240)
            )
        ) {
            Text(text = "Pay")

        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(text = "Diálogo de ejemplo")
                },
                text = {
                    Text(text = "Este es un diálogo de ejemplo.")
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Cancelar")
                    }
                },
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(1.dp))

        Footer()

    }

}

@Composable
fun Footer(){
    Spacer(modifier = Modifier.padding(4.dp))
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = MaterialTheme.shapes.medium
            ),
        color = Color.Transparent
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick =  {  }) {
                Icon(imageVector = Icons.Default.List, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardForm(){
    var cardHolder  by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    var cardNumber  by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    var cardExpiration  by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }

    var cvv  by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }


    Row(modifier = Modifier) {
        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Card Number") },
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(bottom = 10.dp)
        )
    }

    Row(modifier = Modifier) {
        OutlinedTextField(
            value = cardHolder,
            onValueChange = { cardHolder = it },
            label = { Text("Card Holder") },
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(bottom = 10.dp)
        )
    }

    Row(modifier = Modifier) {
        OutlinedTextField(
            value = cardExpiration,
            onValueChange = { cardExpiration = it },
            label = { Text("Card Expiration") },
            modifier = Modifier
                .absolutePadding(bottom = 10.dp, right = 10.dp)
        )

        OutlinedTextField(
            value = cvv,
            onValueChange = { cvv = it },
            label = { Text("CVV") },
            modifier = Modifier
                .absolutePadding(bottom = 10.dp)
        )
    }
}

@Composable
fun StyledAlertDialog(
    bodyText: String,
    buttonText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(bodyText)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
            ) {
                Text(text = buttonText)
            }
        },
        shape = RoundedCornerShape(
            topEndPercent = 50,
            bottomStartPercent = 50
        ),
    )
}
