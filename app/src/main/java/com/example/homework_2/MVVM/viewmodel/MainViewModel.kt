package com.example.homework_2.MVVM.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.ConnectorContextProvider
import com.example.homework_2.StatusLoad
import com.example.homework_2.MVVM.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val state: SavedStateHandle) : ViewModel()
{
    private val itemsKey = "ITEMS"
    var items: MutableLiveData<ArrayList<Response.Item>> = state.getLiveData(itemsKey, arrayListOf())
    //val items: LiveData<ArrayList<Response.Item>> = _items

    private val itemsStatusKey = "ITEMS_STATUS"
    val itemsStatus: MutableLiveData<ArrayList<StatusLoad>> = state.getLiveData(itemsStatusKey, arrayListOf())
    //val itemsStatus: LiveData<ArrayList<StatusLoad>> = _itemsStatus

    private val statusKey = "STATUS"
    var status: MutableLiveData<StatusLoad> = state.getLiveData(statusKey, StatusLoad.SUCCESS)
    //val status: LiveData<StatusLoad> = _status

    private val provider = ConnectorContextProvider.provider()

    init
    {
        getItems()
    }

    private fun getItems(amount : Int = 100)
    {
        viewModelScope.launch {
            try
            {
                val request = withContext(Dispatchers.IO)
                {
                    provider.getItems(items.value?.size ?: 1, amount)
                }
                items.value = request.data
                status.value = StatusLoad.SUCCESS
            }
            catch (error: Throwable)
            {
                status.value = StatusLoad.ERROR
                error.printStackTrace()
            }
        }
    }
}