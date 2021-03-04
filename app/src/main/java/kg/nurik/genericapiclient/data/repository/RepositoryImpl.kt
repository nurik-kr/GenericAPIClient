package kg.nurik.genericapiclient.data.repository

import kg.nurik.genericapiclient.data.interactor.Interactor
import kg.nurik.genericapiclient.data.model.Generic
import retrofit2.Response

interface Repository {
    suspend fun loadData(): Response<List<Generic>>
}

class RepositoryImpl(private val network: Interactor) : Repository {
    override suspend fun loadData(): Response<List<Generic>> {
        //Если предусмотрено кэширование
        return network.loadData()
    }
}
