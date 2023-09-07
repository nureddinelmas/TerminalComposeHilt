package com.nureddinelmas.navigationexample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Transaction::class], version = 1, exportSchema = false)

abstract class TransactionDatabase : RoomDatabase(){

    abstract fun transactionDao() : TrasactionDao

}