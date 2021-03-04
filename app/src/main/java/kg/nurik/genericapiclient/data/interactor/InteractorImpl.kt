package kg.nurik.genericapiclient.data.interactor

import kg.nurik.genericapiclient.data.model.Generic
import kg.nurik.genericapiclient.data.remote.Service
import retrofit2.Response

interface Interactor {
    suspend fun loadData():Response<List<Generic>>
}

class InteractorImpl(private val service: Service) : Interactor {
    override suspend fun loadData(): Response<List<Generic>> {
        return service.loadData()
    }
}