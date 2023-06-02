package pe.edu.upc.digitalholics.appmobile.ui.srceens.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.digitalholics.appmobile.data.model.Appointment
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiClient
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.AppointmentResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.PhysiotherapistResponse
import pe.edu.upc.digitalholics.appmobile.data.remote.TreatmentResponse
import pe.edu.upc.digitalholics.appmobile.ui.srceens.AppointmentList.AppointmentList
import pe.edu.upc.digitalholics.appmobile.ui.srceens.FindYourPhysiotherapist.FindYourPhysiotherapist
import pe.edu.upc.digitalholics.appmobile.ui.srceens.HomePatient.FirstHome
import pe.edu.upc.digitalholics.appmobile.ui.srceens.HomePatient.HomePatient
import pe.edu.upc.digitalholics.appmobile.ui.srceens.HomePatient.LongCard
import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientList.PatientList
//import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.Patient
import pe.edu.upc.digitalholics.appmobile.ui.srceens.PatientsDetails.PatientDetails
import pe.edu.upc.digitalholics.appmobile.ui.srceens.Payment.Payment
import pe.edu.upc.digitalholics.appmobile.ui.srceens.PhysiotherapistList
import pe.edu.upc.digitalholics.appmobile.ui.srceens.Schedule.Schedule
import pe.edu.upc.digitalholics.appmobile.ui.srceens.TreatmentList.Treatments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FindYourPhysiotherapist") {

        composable("Payment") {
            Payment()
        }

        composable("Schedule") {
            val physiotherapist = remember {
                mutableStateOf(
                    Physiotherapist(
                        id = "",
                        firstName = "",
                        paternalSurname = "",
                        maternalSurname = "",
                        age = 0,
                        rating = "",
                        location = "",
                        photoUrl = "",
                        birthdayDate = "",
                        consultationsQuantity = "",
                        specialization = "",
                        email = "",
                        userId = ""
                    )
                )
            }

            val driverInterface = ApiClient.buildPhysiotherapistInterface()
            val getDriver = driverInterface.getPhysiotherapistById(1)

            getDriver.enqueue(object : Callback<Physiotherapist> {
                override fun onResponse(call: Call<Physiotherapist>, response: Response<Physiotherapist>) {
                    if (response.isSuccessful) {
                        physiotherapist.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Physiotherapist>, t: Throwable) {
                }
            })


            Schedule(
                physiotherapist = physiotherapist.value
            )

        }

        composable("AppointmentList") {

            val appointments = remember {
                //mutableStateOf(Appointment("1","Jose","Del Carpio","20","30","jose@gmail.com","2"))
                mutableStateOf(emptyList<Appointment>())
            }

            AppointmentList(
                //patients = patients.value,
                size=appointments.value.size,
                appointments = appointments.value,
                selectAppointment = {
                    //navController.navigate("appointment/$index")
                }
            )

            //AppointmentList(0, appointments = appointments.value)

            val appointmentInterface = ApiClient.buildAppointmentInterface()
            val getAllAppointment = appointmentInterface.getAllAppointments()

            getAllAppointment.enqueue(object : Callback<AppointmentResponse> {
                override fun onResponse(
                    call: Call<AppointmentResponse>,
                    response: Response<AppointmentResponse>
                ) {
                    if (response.isSuccessful) {
                        appointments.value = response.body()?.appointments!!

                    }
                }

                override fun onFailure(call: Call<AppointmentResponse>, t: Throwable) {
                }
            })
            //appointments.value. +=
        }

        composable("PhysiotherapistList") {
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

            PhysiotherapistList(
                physiotherapists = physiotherapists.value,
                selectPhysiotherapist = { index ->
                    //navController.navigate("physiotherapist/$index")
                }
            )

        }
        composable("FindYourPhysiotherapist") {
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

            FindYourPhysiotherapist(
                physiotherapists = physiotherapists.value,
                selectPhysiotherapist = { index ->
                    //navController.navigate("physiotherapist/$index")
                }
            )

        }




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



        composable(
            "patient/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) {
            val index = it.arguments?.getString("index") as String

            val patients = remember {
                mutableStateOf(
                    Patient(
                        "1",
                        "Jose",
                        "Del Carpio",
                        "20",
                        "30",
                        "jose@gmail.com",
                        "2",
                        "https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"
                    )
                )
            }

            val driverInterface = ApiClient.build()
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
            FirstHome(patient = patients.value)
            LongCard(patient = patients.value)
        }

        //treatmentList
        composable("TreatmentList") {
            val treatments = remember {
                //mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
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
                }
            )
        }

        composable("HomePatient"){
//            val patients = remember {
//                mutableStateOf(emptyList<Patient>())
//            }
            val treatments = remember {
                //mutableStateOf(Patient("1","Jose","Del Carpio","20","30","jose@gmail.com","2","https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"))
                mutableStateOf(emptyList<Treatment>())
            }
            val patientInterface = ApiClient.build()
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

//            val index = it.arguments?.getString("index") as String

            val patients = remember {
                mutableStateOf(
                    Patient(
                        "1",
                        "Jose",
                        "Del Carpio",
                        "20",
                        "30",
                        "jose@gmail.com",
                        "2",
                        "https://img.europapress.es/fotoweb/fotonoticia_20081004164743_420.jpg"
                    )
                )
            }

            val driverInterface = ApiClient.build()
            val getDriver = driverInterface.getPatientById("1")

            getDriver.enqueue(object : Callback<Patient> {
                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                    if (response.isSuccessful) {
                        patients.value = response.body()!!
                    }
                }

                override fun onFailure(call: Call<Patient>, t: Throwable) {
                }
            })
//            HomePatient(
//               treatment = treatments.value
//            )

            val physiotherapists = remember {
                mutableStateOf(emptyList<Physiotherapist>())
            }

            //PatientDetails(patient = patients.value)

            val physiotherapist = remember {
                mutableStateOf(
                    Physiotherapist(
                        id = "",
                        firstName = "",
                        paternalSurname = "",
                        maternalSurname = "",
                        age = 0,
                        rating = "",
                        location = "",
                        photoUrl = "",
                        birthdayDate = "",
                        consultationsQuantity = "",
                        specialization = "",
                        email = "",
                        userId = ""
                    )
                )
            }

            val physiotherapistInterface = ApiClient.buildPhysiotherapistInterface()
            val getPhysiotherapistById = physiotherapistInterface.getPhysiotherapistById(1)

            getPhysiotherapistById.enqueue(object : Callback<Physiotherapist> {
                override fun onResponse(call: Call<Physiotherapist>, response: Response<Physiotherapist>){
                    if (response.isSuccessful) {
                        physiotherapist.value = response.body()!!

                    }
                }

                override fun onFailure(call: Call<Physiotherapist>, t: Throwable) {

                }
            })

//            getDriver.enqueue(object : Callback<Physiotherapist> {
//                override fun onResponse(call: Call<Physiotherapist>, response: Response<Physiotherapist>) {
//                    if (response.isSuccessful) {
//                        physiotherapist.value = response.body()!!
//                    }
//                }
//
//                override fun onFailure(call: Call<Physiotherapist>, t: Throwable) {
//                }
//            })

//            getDriver.enqueue(object : Callback<Patient> {
//                override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
//                    if (response.isSuccessful) {
//                        patients.value = response.body()!!
//                    }
//                }
//
//                override fun onFailure(call: Call<Patient>, t: Throwable) {
//                }
//            })

            HomePatient(
                treatments = treatments.value,
                selectTreatment = { index ->
                    navController.navigate("treatment/$index")
                },
                patient = patients.value,
                physiotherapist = physiotherapist.value
            )

        }


    }
}

