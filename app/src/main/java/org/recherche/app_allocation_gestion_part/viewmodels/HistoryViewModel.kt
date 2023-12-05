package org.recherche.app_allocation_gestion_part.viewmodels

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.recherche.app_allocation_gestion_part.SessionManagement
import org.recherche.app_allocation_gestion_part.models.HistoryResponse
import org.recherche.app_allocation_gestion_part.repos.AllocateRepo


@RequiresApi(Build.VERSION_CODES.O)
class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    val listHistory = MutableLiveData<List<HistoryResponse>>(null)
    val error = MutableLiveData("")
    val token_temp = SessionManagement(application).getToken().split("_T_")
    val token = "Bearer ${token_temp[0]}"
    val hostoryRepo = AllocateRepo()


    fun getHistoryData() {


        viewModelScope.launch {
            val response = hostoryRepo.getAllHistory(token)
            if (response.code() == 200 && response.body() != null) {
                listHistory.postValue(response.body())
                Log.d("TAG", "getHistoryData: ${response.body()}")
            }else
                error.postValue("Error ${response.code()}")
        }
    }








}