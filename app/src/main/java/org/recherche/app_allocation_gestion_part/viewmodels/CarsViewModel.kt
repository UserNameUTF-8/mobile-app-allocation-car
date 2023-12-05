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
import org.recherche.app_allocation_gestion_part.repos.CarRepo


@RequiresApi(Build.VERSION_CODES.O)
class CarsViewModel(application: Application): AndroidViewModel(application) {

    val token_time_exp = SessionManagement(application).getToken().split("_T_")
    val token = "Bearer ${token_time_exp[0]}"
    val time_exp = token_time_exp[1]
    val listCars = MutableLiveData<List<CarResponse>>(null)
    val listModels =  MutableLiveData<List<String>>(null)
    val carRepo = CarRepo()
    val errorMessage = MutableLiveData("")
    fun getAllCars() {
        viewModelScope.launch {
            val response = carRepo.getAllCars(token)

            if (response.body() != null && response.code() == 200) {
                listCars.postValue(response.body())
                getModels()
            }else
                errorMessage.postValue("Error ${response.code()}")
        }
    }

    fun getAllAvailableCars() {
        viewModelScope.launch {
            val response = carRepo.getAvailableCars(token)

            if (response.body() != null && response.code() == 200) {
                listCars.postValue(response.body())
            }else
                errorMessage.postValue("Error ${response.code()}")
        }
    }


    fun getModels() {
        viewModelScope.launch {
            val response = carRepo.getModels(token)

            if (response.body() != null && response.code() == 200) {
                listModels.postValue(response.body())
            }else
                errorMessage.postValue("Error ${response.code()}")
        }
    }










}