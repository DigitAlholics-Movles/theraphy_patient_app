package pe.edu.upc.digitalholics.appmobile.ui.screens.PatientList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

//import androidx.compose.runtime.livedata.observeAsState
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.ui.screens.ViewModel.PatientViewModel

//@Composable
//fun PatientList(patientViewModel: PatientViewModel,patients: List<Patient>, selectPatient: (String)-> Unit){
//    LazyColumn(){
//        itemsIndexed(patients){ index, item ->
//            PatientItem(item){
//                selectPatient("${index + 1}")
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun PatientItem(patient: Patient, selectPatient: () -> Unit){
//    Card(
//        onClick = {
//            selectPatient ()
//        }) {
//        Row(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = patient.id)
//        }
//    }
//}

@Composable
fun SuperHeroes(viewModel: PatientViewModel) {

    Column {
//        SuperHeroSearch(viewModel = viewModel)
        SuperHeroList(viewModel = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SuperHeroSearch(viewModel: PatientViewModel, modifier: Modifier = Modifier) {
//    val name by viewModel.name.observeAsState("")
//
//    OutlinedTextField(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(4.dp),
//        value = name,
//        onValueChange = {
//            viewModel.update(it)
//        },
//        leadingIcon = {
//            Icon(Icons.Filled.Search, null)
//        },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Text,
//            imeAction = ImeAction.Search
//        ),
//        keyboardActions = KeyboardActions(
//            onSearch = {
//                viewModel.fetchByName()
//            }
//        )
//    )
//
//}

@Composable
fun SuperHeroList(viewModel: PatientViewModel) {
    val superHeroes by viewModel.patients.observeAsState(listOf())

    LazyColumn {

        items(superHeroes) { superHero ->
            SuperHeroCard(superHero)
        }
    }
}

@Composable
fun SuperHeroCard(superHero: Patient, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row {
            SuperHeroImage(superHero)
            SuperHeroItem(superHero)
        }
    }
}

@Composable
fun SuperHeroItem(superHero: Patient, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.width(8.dp))
    Row {
        Column(modifier = modifier.weight(7f)) {
            Text(text = superHero.firstName, fontWeight = FontWeight.Bold)
            Text(text = superHero.lastName)
        }
        IconButton(
            modifier = modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }
    }
}

@Composable
fun SuperHeroImage(superHero: Patient, modifier: Modifier = Modifier) {
    AsyncImage(
        model = superHero.photoUrl,
        contentDescription = null,
        modifier = modifier
            .size(92.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}