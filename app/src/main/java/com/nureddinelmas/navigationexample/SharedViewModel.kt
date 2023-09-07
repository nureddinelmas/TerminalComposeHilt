package com.nureddinelmas.navigationexample

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {
    private val getAll = repository.getAllTransaction

    private val _state = mutableStateOf<List<Transaction>>(emptyList<Transaction>())
    val state: State<List<Transaction>> = _state

    init {
        getAll()
    }

    private fun getAll() {
        getAll.observeForever {
            _state.value = it
        }
    }


     fun insertData(transaction: Transaction){
         viewModelScope.launch {
             repository.insertData(transaction)
         }

    }

}