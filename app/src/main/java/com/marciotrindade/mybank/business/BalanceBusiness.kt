package com.marciotrindade.mybank.business

import com.marciotrindade.mybank.api.model.UserAccountX
import com.marciotrindade.mybank.api.service.ResponseApi

class BalanceBusiness {


    private val repository by lazy {
        BalanceRepository()
    }

    suspend fun post(user: String, password: String): ResponseApi {

      return when(repository.post(user,password)){

          is ResponseApi.Success ->{

              ResponseApi.Success(
                  UserAccountX("012314564",3.3445,
                      "2050","Jose da Silva Teste",1)
              )          }
          else -> ResponseApi.Error("erro ao carregar!")
      }



    }

    suspend fun loadBalance(id: Int):ResponseApi {
      return repository.loadBalance(id)
    }
}