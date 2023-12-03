package org.recherche.app_allocation_gestion_part.viewmodels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.recherche.app_allocation_gestion_part.SessionManagement
import org.recherche.app_allocation_gestion_part.models.UserResponse
import org.recherche.app_allocation_gestion_part.repos.UserRepo

class UserViewModel(application: Application) : AndroidViewModel(application = application) {
    val sessionManagement = SessionManagement(application)
    val token = sessionManagement.getToken().split("_T_")
    val token_ = token[0]
    val exp_time_ = token[1]


    val mutableLiveDataUsers = MutableLiveData<List<UserResponse>>(null)
    val error_ = MutableLiveData<String>("")


    @RequiresApi(Build.VERSION_CODES.O)
    val userRepo = UserRepo()


    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllUsers() {
        viewModelScope.launch {
            val response = userRepo.getAllUsers(token_)
            if (response.code() == 200 && response.body() != null) {
                mutableLiveDataUsers.postValue(response.body())
            }else {
                error_.postValue("Error ${response.code()}")
            }
        }

    }

}