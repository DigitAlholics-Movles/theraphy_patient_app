package pe.edu.upc.digitalholics.appmobile.ui.srceens.NewTreatment

import android.annotation.SuppressLint
import android.net.Uri
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiClient




import pe.edu.upc.digitalholics.appmobile.data.remote.TreatmentInterface
import pe.edu.upc.digitalholics.appmobile.repository.TreatmentRepository

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newTreatment(){

    val treatmentsInterface = ApiClient.buildTreatmentInterface()
    val viewModelT = NewTreatmentViewModel(treatmentInterface = treatmentsInterface)
    val coroutineScope = rememberCoroutineScope()
    val errorMessage = remember { mutableStateOf("") }
    val createMessage = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(40.dp, 0.dp,0.dp, 0.dp),
                title = { Text(text = "New treatment") }
            )
        }
    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(60.dp, 0.dp, 60.dp, 400.dp)){
            playVideo()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 150.dp, 0.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var description = remember { mutableStateOf(TextFieldValue()) }
            var sessionsQuantity = remember { mutableStateOf(TextFieldValue()) }

            val physiotherapist = Physiotherapist(1, "Roberto","Loza","Perez","45","4","Lima",
                "","04/05/1994","20","Neck","roberto@email.com","2")

           // viewModelT.pushTreatment("1", "new", description.value.text, "https://www.redaccionmedica.com/images/enfermedades/dolor-rodilla.jpg", sessionsQuantity.value.text, physiotherapist)

            Spacer(modifier = Modifier.height(200.dp))
            OutlinedTextField(
                value = description.value,
                onValueChange = { description.value = it },
                label = { Text(text = "Description") },
            )

            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = sessionsQuantity.value,
                onValueChange = { sessionsQuantity.value = it },
                label = { Text(text = "Sessions Quantity") },
            )

            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.Center,

                ) {
                Button(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Upload")
                }

                Button(
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    onClick = {


                        val treatment = Treatment("2", "new", description.value.text, "https://www.redaccionmedica.com/images/enfermedades/dolor-rodilla.jpg", 2, physiotherapist)

                        coroutineScope.launch {
                            val response = treatmentsInterface.postNewTreatment(treatment)
                            if (response.isSuccessful) {
                                  createMessage.value="Se guardo el tratamiento"
                            } else {
                                errorMessage.value="No se pudo guardar el tratamiento"
                            }
                        }
                              },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text("Save")
                }
            }

            if (createMessage.value.isNotEmpty()) {
                Text(
                    text = createMessage.value,
                    fontSize = 14.sp,
                    color = Color(0xFF40A42B)
                )
            }
            if (errorMessage.value.isNotEmpty()) {
                Text(
                    text = errorMessage.value,
                    fontSize = 14.sp,
                    color = Color(0xFFF75B60)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Box(modifier = Modifier
                .border(3.dp, Color.Magenta),contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.List, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null)
                    }
                }
            }

        }

    }



}




@Composable
fun playVideo(){

    val context = LocalContext.current
    val videoUrl = "https://www.youtube.com/watch?v=qYhvEJsWH4M"
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = StyledPlayerView(context)
    playerView.player = exoPlayer

    DisposableEffect(AndroidView(factory = { playerView })){
        exoPlayer.prepare()
        exoPlayer.playWhenReady= true
        onDispose {
            exoPlayer.release()
        }
    }
}

