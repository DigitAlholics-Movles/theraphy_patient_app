package pe.edu.upc.digitalholics.appmobile.ui.srceens.NewTreatment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import pe.edu.upc.digitalholics.appmobile.data.remote.TreatmentInterface
import pe.edu.upc.digitalholics.appmobile.repository.TreatmentRepository
import retrofit2.Response

class NewTreatmentViewModel(private val treatmentInterface: TreatmentInterface): ViewModel() {
    fun pushTreatment(treatment: Treatment) {
        viewModelScope.launch {
            try {
                treatmentInterface.postNewTreatment(treatment)
                // Manejar la respuesta o realizar otras operaciones después de guardar el tratamiento
            } catch (e: Exception) {
                // Manejar el error en caso de que ocurra
            }
        }
    }
}