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
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Review
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiClient
import pe.edu.upc.digitalholics.appmobile.data.remote.PatientResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.PhysiotherapistResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.ReviewResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.TreatmentResponse
import pe.edu.upc.digitalholics.appmobile.ui.screens.AddRiew.AddReview
import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientList.PatientList
import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientProfile.PatientProfile
//import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.Patient
import pe.edu.upc.digitalholics.appmobile.ui.screens.PatientsDetails.PatientDetails
import pe.edu.upc.digitalholics.appmobile.ui.screens.PhysiotherapistProfile.PhysiotherapistProfile
import pe.edu.upc.digitalholics.appmobile.ui.screens.PhysiotherapistsList.PhysiotherapistList
import pe.edu.upc.digitalholics.appmobile.ui.screens.TreatmentDetails.TreatmentDetails
import pe.edu.upc.digitalholics.appmobile.ui.screens.TreatmentList.Treatments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "physiotherapistList") {
        composable("PatientList") {
            val patients = remember {
                //mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
                mutableStateOf(emptyList<Patient>())
            }

            //PatientDetails(patient = patients.value)

            val patientInterface = ApiClient.buildPatientInterface()
            val getAllPatients = patientInterface.getAllPatients()

            getAllPatients.enqueue(object : Callback<PatientResponse> {
                override fun onResponse(
                    call: Call<PatientResponse>,
                    response: Response<PatientResponse>
                ) {
                    if (response.isSuccessful) {
                        patients.value = response.body()?.patients!!

                    }
                }

                override fun onFailure(call: Call<PatientResponse>, t: Throwable) {

                }
            })
            PatientList(
                patients = patients.value,
                selectPatient = { index ->
                    navController.navigate("patient/$index")
                }
            )
        }

        composable(
            "patient/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) {
            val index = it.arguments?.getString("index") as String

            val patients = remember {
                mutableStateOf(
                    Patient(
                        0,
                        0,
                        " ",
                        "20",
                        0,
                        "jose@gmail.com",
                        0,
                        "https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg",
                        ""
                    )
                )
            }

            val driverInterface = ApiClient.buildPatientInterface()
            val getDriver = driverInterface.getPatientById(index)

            getDriver.enqueue(object : Callback<Patient> {
                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                    if (response.isSuccessful) {
                        patients.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Patient>, t: Throwable) {
                }
            })

            PatientDetails(patient = patients.value)
        }

        //treatmentList
        composable("TreatmentList") {
            val treatments = remember {
                mutableStateOf(emptyList<Treatment>())
            }

            //PatientDetails(patient = patients.value)

            val treatmentInterface = ApiClient.buildTreatmentInterface()
            val getAllTreatments = treatmentInterface.getAllTreatments()

            getAllTreatments.enqueue(object : Callback<TreatmentResponse> {
                override fun onResponse(
                    call: Call<TreatmentResponse>,
                    response: Response<TreatmentResponse>
                ) {
                    if (response.isSuccessful) {
                        treatments.value = response.body()?.treatments!!

                    }
                }

                override fun onFailure(call: Call<TreatmentResponse>, t: Throwable) {

                }
            })
            Treatments(
                treatments = treatments.value,
                selectTreatment = { index ->
                    navController.navigate("treatment/$index")
                },navController
            )
        }

        //treatmentDetail
        composable(
            "treatment/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) {
            val index = it.arguments?.getString("index") as String
            val physiotherapist = Physiotherapist(1, "Roberto","Loza","Perez",45,4,"Lima",
                "","04/05/1994",20,"Neck","roberto@email.com",2)


            val treatment = remember {
                mutableStateOf(
                    Treatment(
                        " "," "," "," ","",physiotherapist
                    )
                )
            }

            val treatmentInterface = ApiClient.buildTreatmentInterface()
            val getTreatment = treatmentInterface.getTreatmentById(index)

            getTreatment.enqueue(object : Callback<Treatment> {
                override fun onResponse(call: Call<Treatment>, response: Response<Treatment>) {
                    if (response.isSuccessful) {
                        treatment.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Treatment>, t: Throwable) {
                }
            })

            TreatmentDetails(treatment = treatment.value,navController)
        }

        composable("patient/{index}",arguments = listOf(navArgument("index") { type = NavType.StringType })){
            val index = it.arguments?.getString("index") as String

            val patient = remember {
                mutableStateOf(
                    Patient(0,0,"","",0,"",0,"", " "
                    )
                )
            }

            val patientInterface = ApiClient.buildPatientInterface()
            val getPatient = patientInterface.getPatientById(index)

            getPatient.enqueue(object : Callback<Patient> {
                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                    if (response.isSuccessful) {
                        patient.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Patient>, t: Throwable) {
                }
            })

            PatientProfile(patient = patient.value,navController)

        }


        composable("physiotherapistList") {
            val physiotherapists = remember {
                mutableStateOf(emptyList<Physiotherapist>())
            }

            //PatientDetails(patient = patients.value)

            val physiotherapistInterface = ApiClient.buildPhysiotherapistInterface()
            val getAllPhysiotherapist = physiotherapistInterface.getAllPhysiotherapist()

            getAllPhysiotherapist.enqueue(object : Callback<PhysiotherapistResponse> {
                override fun onResponse(
                    call: Call<PhysiotherapistResponse>,
                    response: Response<PhysiotherapistResponse>
                ) {
                    if (response.isSuccessful) {
                        physiotherapists.value = response.body()?.physiotherapists!!

                    }
                }

                override fun onFailure(call: Call<PhysiotherapistResponse>, t: Throwable) {

                }
            })

            PhysiotherapistList(navController,
                physiotherapists = physiotherapists.value
            )
        }

        composable("physiotherapistProfile/{index}",  arguments = listOf(navArgument("index") { type = NavType.StringType })){
            val index = it.arguments?.getString("index") as String

            val physiotherapist = remember {
                mutableStateOf(
                    Physiotherapist(
                        0,
                        " ",
                        " ",
                        " ",
                        0,
                        0,
                        " ",
                        "",
                        "",
                        0,
                        " ",
                        " ",
                        0
                    )
                )
            }

            val reviews = remember{
                mutableStateOf(emptyList<Review>())
            }

            val physiotherapistInterface = ApiClient.buildPhysiotherapistInterface()
            val getPhysiotherapist = physiotherapistInterface.getPhysiotherapistById(index.toInt())

            val reviewInterface = ApiClient.buildReviewInterface()
            val getReviews = reviewInterface.getAllReviews()

            getPhysiotherapist.enqueue(object : Callback<Physiotherapist> {
                override fun onResponse(call: Call<Physiotherapist>, response: Response<Physiotherapist>) {
                    if (response.isSuccessful) {
                        physiotherapist.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Physiotherapist>, t: Throwable) {
                }
            })

            getReviews.enqueue(object : Callback<ReviewResponse> {
                override fun onResponse(
                    call: Call<ReviewResponse>,
                    response: Response<ReviewResponse>
                ) {
                    if (response.isSuccessful) {
                        reviews.value = response.body()?.reviews!!

                    }
                }

                override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {

                }
            })

            PhysiotherapistProfile(physiotherapist.value,reviews.value,navController)

        }

        composable("addReview/{physiotherapistId}", arguments = listOf(navArgument("physiotherapistId") { type = NavType.StringType })){
            val physiotherapistId = it.arguments?.getString("physiotherapistId") as String
            val physiotherapist = remember {
                mutableStateOf(
                    Physiotherapist(
                        0,
                        " ",
                        " ",
                        " ",
                        0,
                        0,
                        " ",
                        "",
                        "",
                        0,
                        " ",
                        " ",
                        0
                    )
                )
            }

            val reviews = remember{
                mutableStateOf(emptyList<Review>())
            }

            val physiotherapistInterface = ApiClient.buildPhysiotherapistInterface()
            val getPhysiotherapist = physiotherapistInterface.getPhysiotherapistById(physiotherapistId.toInt())

            val reviewInterface = ApiClient.buildReviewInterface()
            val getReviews = reviewInterface.getAllReviews()

            getPhysiotherapist.enqueue(object : Callback<Physiotherapist> {
                override fun onResponse(call: Call<Physiotherapist>, response: Response<Physiotherapist>) {
                    if (response.isSuccessful) {
                        physiotherapist.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Physiotherapist>, t: Throwable) {
                }
            })

            getReviews.enqueue(object : Callback<ReviewResponse> {
                override fun onResponse(
                    call: Call<ReviewResponse>,
                    response: Response<ReviewResponse>
                ) {
                    if (response.isSuccessful) {
                        reviews.value = response.body()?.reviews!!

                    }
                }

                override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {

                }
            })
            AddReview(physiotherapist = physiotherapist.value, reviews =reviews.value , navController =navController )

        }

    }
}