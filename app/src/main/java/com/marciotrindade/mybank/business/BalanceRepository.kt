package com.marciotrindade.mybank.business

import com.marciotrindade.mybank.api.service.ApiService
import com.marciotrindade.mybank.api.service.ResponseApi

class BalanceRepository {


    suspend fun post(user: String, password: String):ResponseApi {


        return try {
            val response = ApiService.taskApi.postTask(user,password)

            if (response.isSuccessful) {

                ResponseApi.Success(response.body())

            } else {
                ResponseApi.Error("Erro ao carregar os dados")

            }

        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }

    suspend fun loadBalance(id:Int):ResponseApi {
        return try {
            val response = ApiService.taskApi.getBalance(id)

            if (response.isSuccessful) {

                ResponseApi.Success(response.body())

            } else {
                ResponseApi.Error("Erro ao carregar os dados")

            }

        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }

}