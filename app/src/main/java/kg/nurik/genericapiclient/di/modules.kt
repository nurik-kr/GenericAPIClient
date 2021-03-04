package kg.nurik.genericapiclient.di

import kg.nurik.genericapiclient.data.interactor.Interactor
import kg.nurik.genericapiclient.data.interactor.InteractorImpl
import kg.nurik.genericapiclient.data.remote.RetrofitBuilder
import kg.nurik.genericapiclient.data.remote.Service
import kg.nurik.genericapiclient.data.repository.Repository
import kg.nurik.genericapiclient.data.repository.RepositoryImpl
import kg.nurik.genericapiclient.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule: Module = module {
    single<Repository> { RepositoryImpl(get()) }
}

val apiModule: Module = module {
    single<Service> { RetrofitBuilder.buildRetrofit() }
    single<Interactor> { InteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)