package pe.edu.upc.digitalholics.appmobile.ui.srceens.PhysiotherapistList

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import pe.edu.upc.digitalholics.appmobile.R

@Composable
fun PhysiotherapistList(){
//    val cards = listOf("Tarjeta 1", "Tarjeta 2", "Tarjeta 3", "Tarjeta 4")
    Column {
        FirstPhysiotherapistList()
        SearchTextField()
        Physiotherapists()
        Footer()
    }
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column {
//            FirstPhysiotherapistList()
//            SearchTextField()
//        }
//        Box(modifier = Modifier.align(Alignment.TopCenter)) {
//            Physiotherapists()
//        }
//        Footer()
//    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField() {
    TextField(
        value = "",
        onValueChange = { },
        textStyle = TextStyle(color = Color.Black),
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
//            Text(text = stringResource(id = androidx.compose.ui.R.string.tab))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(id = androidx.compose.ui.R.string.dropdown_menu)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedSupportingTextColor = Color.Transparent
        )
    )
}

@Composable
fun FirstPhysiotherapistList(){
    Text("Find your physiotherapist", modifier = Modifier.padding(12.dp))
}

@Composable
fun Physiotherapists(){

    Box() {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(4) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Unspecified
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.lumbar),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(70.dp)
                                        .height(70.dp)
                                        .padding(3.dp)
                                )
                                Spacer(modifier = Modifier.padding(start = 12.dp))
                                Text(text = "Physiotherapist name")
                            }
                        }
                    }
                }
            }
        }
    }
    Footer()
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
