package pe.edu.upc.digitalholics.appmobile.ui.srceens.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiClient
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiResponse
import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientList.PatientList
//import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.Patient
import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.PatientDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "PatientList") {
        composable("PatientList") {
            val patients = remember {
                //mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
                mutableStateOf(emptyList<Patient>())
            }

            //PatientDetails(patient = patients.value)

            val patientInterface = ApiClient.build()
            val getAllPatients = patientInterface.getAllPatients()

            getAllPatients.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    if (response.isSuccessful) {
                        patients.value = response.body()?.patients!!

                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

                }
            })
            PatientList(
                patients = patients.value,
                selectPatient = { index ->
                    navController.navigate("patient/$index")
               }
            )
        }

    }
}