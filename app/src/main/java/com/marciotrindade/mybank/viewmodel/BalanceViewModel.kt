package com.marciotrindade.mybank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marciotrindade.mybank.api.model.Balance
import com.marciotrindade.mybank.api.model.Statement
import com.marciotrindade.mybank.api.model.UserAccountX
import com.marciotrindade.mybank.api.service.ResponseApi
import com.marciotrindade.mybank.business.BalanceBusiness
import com.marciotrindade.mybank.ui.account.User
import kotlinx.coroutines.launch

class BalanceViewModel:ViewModel() {

    private val business = BalanceBusiness()
    val userReturnLiveData:MutableLiveData<UserAccountX> = MutableLiveData()
    val error:MutableLiveData<String> = MutableLiveData()
    val statmentLiveData:MutableLiveData<Balance> = MutableLiveData()





    fun postUser(user: String, password: String) {

        viewModelScope.launch {
           when(val response =business.post(user,password)){
               is ResponseApi.Success->{
                   userReturnLiveData.postValue(response.data as UserAccountX)

               }
               is ResponseApi.Error->{
                   error.postValue(response.message)

               }
           }
        }


    }

    fun loadBalance(userId: Int) {
        viewModelScope.launch {

            when(val response= business.loadBalance(userId)){
                is ResponseApi.Success->{
                    statmentLiveData.postValue(
                        response.data as? Balance

                    )

                }is ResponseApi.Error->{

                }
            }

        }
    }
}