package com.nureddinelmas.navigationexample

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "transaction_table")
data class Transaction (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val city : String
)