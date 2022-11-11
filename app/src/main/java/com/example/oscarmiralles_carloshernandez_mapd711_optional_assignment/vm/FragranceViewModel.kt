package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.data.FragranceResponse
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.service.FragranceService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel class to retrieve information from a service.
 * Store information in FragranceResponse data class.
 */
class FragranceViewModel: ViewModel() {
    var firstProductLiveData: MutableLiveData<FragranceResponse>? = null
    var secondProductLiveData: MutableLiveData<FragranceResponse>? = null
    var thirdProductLiveData: MutableLiveData<FragranceResponse>? = null
    var fourthProductLiveData: MutableLiveData<FragranceResponse>? = null
    var fifthProductLiveData: MutableLiveData<FragranceResponse>? = null

    init {
        if (firstProductLiveData == null) {
            firstProductLiveData = MutableLiveData()
        }

        if (secondProductLiveData == null) {
            secondProductLiveData = MutableLiveData()
        }

        if (thirdProductLiveData == null) {
            thirdProductLiveData = MutableLiveData()
        }

        if (fourthProductLiveData == null) {
            fourthProductLiveData = MutableLiveData()
        }

        if (fifthProductLiveData == null) {
            fifthProductLiveData = MutableLiveData()
        }
    }

    //Get first product from service
    fun getFirstProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = FragranceService.retrofit.getProductOne()
            firstProductLiveData?.postValue(data)
        }
    }

    //Get second product from service
    fun getSecondProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = FragranceService.retrofit.getProductTwo()
            secondProductLiveData?.postValue(data)
        }
    }

    //Get third product from service
    fun getThirdProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = FragranceService.retrofit.getProductThree()
            thirdProductLiveData?.postValue(data)
        }
    }

    //Get fourth product from service
    fun getFourthProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = FragranceService.retrofit.getProductFour()
            fourthProductLiveData?.postValue(data)
        }
    }

    //Get fifth product from service
    fun getFifthProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = FragranceService.retrofit.getProductFive()
            fifthProductLiveData?.postValue(data)
        }
    }
}