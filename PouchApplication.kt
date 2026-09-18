package com.abhishek.pouchaitracker

import android.app.Application
import com.abhishek.pouchaitracker.data.database.AppDatabase
import com.abhishek.pouchaitracker.repository.TransactionRepository

class PouchApplication : Application() {

    val database by lazy {
        AppDatabase.getDatabase(this)
    }

    val transactionRepository by lazy {
        TransactionRepository(database.transactionDao())
    }
}