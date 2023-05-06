package pe.edu.upc.digitalholics.appmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.digitalholics.appmobile.ui.screens.Navigation.Navigation
import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientList.SuperHeroes
import pe.edu.upc.digitalholics.appmobile.ui.screens.ViewModel.PatientViewModel
import pe.edu.upc.digitalholics.appmobile.ui.theme.AppmobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppmobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = applicationContext
                    val viewModel: PatientViewModel by viewModels()
                    SuperHeroes(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppmobileTheme {
        Greeting("Android")
    }
}