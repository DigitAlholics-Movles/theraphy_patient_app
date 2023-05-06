package pe.edu.upc.digitalholics.appmobile.ui.screens.Navigation

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
//import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientList.PatientList
import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientsDetails.PatientDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.Patient

@Composable
fun Navigation() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "PatientList") {
//        composable("PatientList") {
//            val patients = remember {
//                //mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
//                mutableStateOf(emptyList<Patient>())
//            }
//
////            PatientDetails(patient = patients.value)
//
//
//            val patientInterface = ApiClient.build()
//            val getAllPatients = patientInterface.getAllPatients()
//
////            getAllPatients.enqueue(object : Callback<ApiResponse> {
////                override fun onResponse(
////                    call: Call<ApiResponse>,
////                    response: Response<ApiResponse>
////                ) {
////                    if (response.isSuccessful) {
////                        patients.value = response.body()?.patients!!
////
////                    }
////                }
////
////                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
////
////                }
////            })
//            PatientList(
//                patients = patients.value,
//                selectPatient = { index ->
//                    navController.navigate("patient/$index")
//               }
//            )
//        }
//        composable(
//            "patient/{index}",
//            arguments = listOf(navArgument("index") { type = NavType.StringType})
//        ){
//            val index = it.arguments?.getString("index") as String
//
//            val patient = remember {
//                mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
//            }
//
//            val patientInterface = ApiClient.build()
//            val getPatientById = patientInterface.getPatientById(index)
//
////            getPatientById.enqueue(object : Callback<Patient>{
////                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
////                    if (response.isSuccessful) {
////                        patient.value = response.body()!!
////                    }
////                }
////
////                override fun onFailure(call: Call<Patient>, t: Throwable) {
////                }
////            })
//
//            PatientDetails(patient = patient.value)
//        }
//
//    }
}