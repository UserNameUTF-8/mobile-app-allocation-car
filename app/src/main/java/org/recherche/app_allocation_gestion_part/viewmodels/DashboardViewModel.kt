package org.recherche.app_allocation_gestion_part.viewmodels

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.recherche.app_allocation_gestion_part.SessionManagement
import org.recherche.app_allocation_gestion_part.models.AdminResponse
import org.recherche.app_allocation_gestion_part.models.CountResResponse
import org.recherche.app_allocation_gestion_part.models.UserResponse
import org.recherche.app_allocation_gestion_part.repos.AdminRepo
import java.time.LocalDateTime

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    val sessionManagement = SessionManagement(application)
    val token_ = sessionManagement.getToken().split("_T_")
    val token = token_[0]
    val countResResponse = MutableLiveData<CountResResponse>(null)

    val currentUser = MutableLiveData<AdminResponse>(null)
    val error_ = MutableLiveData(false)
    var errorMessage = ""
    val repo = AdminRepo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAdmin() {
        Log.d("TAG", "getAdmin: ${token_[1]}")

            viewModelScope.launch {
                val response = repo.getCurrentUser(token)
                if (response.body() != null && response.code() == 200) {
                    currentUser.postValue(response.body())
                    getCountRes()
                }else {
                    error_.postValue(true)
                    errorMessage = "Error ${response.code()}"
                }
            }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getCountRes() {

        viewModelScope.launch {
            val response = repo.getCountAll(token)
            if (response.body() != null && response.code() == 200)
                countResResponse.postValue(response.body())

            else {
                errorMessage = "error ${response.message()}"
                error_.postValue(true)
            }
        }
    }

}