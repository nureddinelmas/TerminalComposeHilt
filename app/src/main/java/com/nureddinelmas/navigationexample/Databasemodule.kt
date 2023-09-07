package com.nureddinelmas.navigationexample

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Databasemodule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, TransactionDatabase::class.java,
        "transaction_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: TransactionDatabase) = database.transactionDao()
}