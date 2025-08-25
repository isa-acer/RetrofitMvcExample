package com.isaacer.mvc

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

@GET("/posts")
suspend fun  getAllUser():List<UsersItem>


}