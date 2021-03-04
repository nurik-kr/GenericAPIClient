package kg.nurik.genericapiclient.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.genericapiclient.data.model.Generic
import kg.nurik.genericapiclient.data.repository.Repository
import kg.nurik.genericapiclient.data.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val data = MutableLiveData<List<Generic>>()

    init {
        loadCategories()
    }

    fun loadCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadData()
                if (result.isSuccessful) data.postValue(result.body())
            }.onFailure {
                Log.d("Error", it.localizedMessage)
            }
        }
    }
}