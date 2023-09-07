package com.nureddinelmas.navigationexample

import androidx.lifecycle.LiveData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject


@ViewModelScoped
class TransactionRepository @Inject constructor(
    private val transactionDao: TrasactionDao
) {

    val getAllTransaction : LiveData<List<Transaction>> = transactionDao.getAllTask()

    suspend fun insertData(transaction: Transaction){
        transactionDao.insertData(transaction)
    }
}