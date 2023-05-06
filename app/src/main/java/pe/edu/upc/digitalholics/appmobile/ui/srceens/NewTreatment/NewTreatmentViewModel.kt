package pe.edu.upc.digitalholics.appmobile.ui.srceens.NewTreatment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.appmobile.data.model.Physiotherapist
import pe.edu.upc.digitalholics.appmobile.data.model.Treatment
import pe.edu.upc.digitalholics.appmobile.repository.TreatmentRepository
import retrofit2.Response

class NewTreatmentViewModel(private val treatmentRepository: TreatmentRepository): ViewModel() {
    val myPushTreatment: MutableLiveData<Response<Treatment>> = MutableLiveData()

    fun pushTreatment(id: String, title: String, description: String, photoUrl: String, sessionsQuantity: String, physiotherapist: Physiotherapist){
        viewModelScope.launch {
            val  response = treatmentRepository.pushTreatments(id, title, description, photoUrl, sessionsQuantity, physiotherapist)
            myPushTreatment.value = response
        }
    }
}