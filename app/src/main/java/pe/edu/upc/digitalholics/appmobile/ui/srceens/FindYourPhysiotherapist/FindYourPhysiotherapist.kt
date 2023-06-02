package pe.edu.upc.digitalholics.appmobile.ui.srceens.FindYourPhysiotherapist

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindYourPhysiotherapist(physiotherapists: List<Physiotherapist>, selectPhysiotherapist: (String)-> Unit){
    var pacientutos: MutableList<Physiotherapist> = physiotherapists.toMutableList()
    var searchedText  by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }
    Column(modifier = Modifier.padding(17.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Find your physiotherapist", fontSize = 25.sp, fontWeight = FontWeight.Bold,
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

            TextField(value = searchedText, onValueChange = { searchedText = it }, Modifier.fillMaxWidth())
            IconButton(onClick = {
                //searchedText = text
                //pacientutos = patients.subList(0,1).toMutableList()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }



        }
        LazyColumn(Modifier.height(500.dp)){
            itemsIndexed(pacientutos){ index, item ->
                PhysiotherapistItem(item, searchedText.text
                ){
                    selectPhysiotherapist("${index + 1}")
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
private fun PhysiotherapistItem(physiotherapist: Physiotherapist, searchedText:String, selectPhysiotherapist: () -> Unit){
    if(physiotherapist.firstName.uppercase().contains(searchedText.uppercase()) || physiotherapist.paternalSurname.uppercase().contains(searchedText.uppercase()))
        Row() {
            Card(onClick = {
                selectPhysiotherapist ()
            },
                modifier = Modifier
                    .absolutePadding(top = 15.dp, bottom = 15.dp)
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0, 122, 240))
                        .fillMaxWidth()) {

                    AsyncImage(
                        model = physiotherapist.photoUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .width(130.dp)
                            .height(130.dp)
                            .padding(20.dp)
                            .border(BorderStroke(5.dp, Color.White)),
                        contentScale = ContentScale.Crop
                    )

                    Column() {
                        Text(text = physiotherapist.firstName + " " + physiotherapist.paternalSurname, fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.absolutePadding(bottom = 15.dp))
                        Row() {
                            repeat(5) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = null
                                        )
                                    }
                            }
                        }

                    }

                }

            }


        }
}