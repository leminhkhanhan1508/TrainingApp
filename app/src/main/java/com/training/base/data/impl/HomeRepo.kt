package com.training.base.data.impl

import com.training.base.data.request.LoginRequest
import com.training.base.data.request.User
import com.training.base.data.response.LoginResponse
import retrofit2.Response

interface HomeRepo{
    suspend fun login(userName:String, password:String): LoginResponse
    suspend fun getUsers(): Response<List<User>>
}

class HomeRepoImpl(private val service: Service) : HomeRepo {
    override suspend fun login(userName: String, password: String): LoginResponse {
        return service.login(LoginRequest(userName, password))
    }

    override suspend fun getUsers(): Response<List<User>> {
        return service.getUsers()
    }


}