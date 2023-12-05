package org.recherche.app_allocation_gestion_part.viewmodels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.recherche.app_allocation_gestion_part.SessionManagement
import org.recherche.app_allocation_gestion_part.models.CarResponse
import org.recherche.app_allocation_gestion_part.models.HistoryResponse
import org.recherche.app_allocation_gestion_part.models.UserResponse
import org.recherche.app_allocation_gestion_part.repos.AllocateRepo
import org.recherche.app_allocation_gestion_part.repos.CarRepo
import org.recherche.app_allocation_gestion_part.repos.UserRepo


@RequiresApi(Build.VERSION_CODES.O)
class HistoryDetailsViewModel(application: Application): AndroidViewModel(application) {

    val token_exptime = SessionManagement(application).getToken().split("_T_")
    val token = "Bearer ${token_exptime[0]}"
    val historyFullData = MutableLiveData<HistoryResponse>(null)
    val error = MutableLiveData("")
    val historyRepo = AllocateRepo()

    fun getHistoryFullData(id_: Int) {

        viewModelScope.launch {
            val response = historyRepo.getHistoryById(token, id_)
            if (response.body() != null && response.code() == 200) {
                historyFullData.postValue(response.body())
            }else
                error.postValue("Error ${response.code()}")
        }
    }

    fun disActiveHistory(id: Int) {
        viewModelScope.launch {
        }
    }



}