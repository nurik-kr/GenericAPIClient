package kg.nurik.genericapiclient.data.remote

import kg.nurik.genericapiclient.data.model.Generic
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("/random_ten")
    suspend fun loadData(): Response<List<Generic>>
}


