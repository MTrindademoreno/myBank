package com.marciotrindade.mybank.api.service

import com.marciotrindade.mybank.api.model.Statement


sealed class ResponseApi{
    class Success(val data:Any?): ResponseApi()
    class Error(val message:String): ResponseApi()
    

}

