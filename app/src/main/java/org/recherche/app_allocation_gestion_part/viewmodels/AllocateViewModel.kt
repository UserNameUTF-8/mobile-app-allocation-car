package org.recherche.app_allocation_gestion_part.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AllocateViewModel(application: Application): AndroidViewModel(application) {


    val isAllocated = MutableLiveData(false)

}