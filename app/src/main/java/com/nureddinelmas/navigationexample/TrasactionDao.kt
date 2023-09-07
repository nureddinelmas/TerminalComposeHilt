package com.nureddinelmas.navigationexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TrasactionDao {


    @Query("SELECT * FROM transaction_table ORDER BY 'id' ASC")
    fun getAllTask(): LiveData<List<Transaction>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(transaction: Transaction)

}