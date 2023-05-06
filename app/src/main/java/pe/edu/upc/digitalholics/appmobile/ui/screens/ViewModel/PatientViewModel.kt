package pe.edu.upc.digitalholics.appmobile.ui.screens.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import pe.edu.upc.digitalholics.appmobile.data.local.AppDatabase
import pe.edu.upc.digitalholics.appmobile.data.model.Patient
import pe.edu.upc.digitalholics.appmobile.data.remote.ApiClient
import pe.edu.upc.digitalholics.appmobile.repository.PatientRepository


class PatientViewModel(application: Application) : AndroidViewModel(application) {
    private val patientInterface = ApiClient.build()
    private val patientDao = AppDatabase.getInstance(application).patientDao()
    private val patientRepository = PatientRepository(patientInterface, patientDao)

    private var _patients = MutableLiveData<List<Patient>>()
    val patients get() = _patients

    private var _name = MutableLiveData<String>()
    val name get() = _name

    fun update(name: String) {
        _name.value = name
    }

    fun fetchByName() {
        patientRepository.fetchByName(name.value!!)
        _patients.value = patientRepository.patients.value
    }
}