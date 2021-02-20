package com.marciotrindade.mybank.api.service


import com.marciotrindade.mybank.api.model.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface TaskApi {
    //@Headers("Content-Type: application/json")
   @GET("statements/{id}")
   suspend fun getBalance(
       @Path("id") id: Int
   ): Response<Balance>

  //@Headers("Content-Type: application/json")

    @POST("login")
    suspend fun postTask(
        @Query("user") username: String,
        @Query("password") senha: String,
    ): Response<Result>




}