package com.abhishek.pouchaitracker.repository

import com.abhishek.pouchaitracker.data.dao.TransactionDao
import com.abhishek.pouchaitracker.data.entity.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepository(
    private val transactionDao: TransactionDao
) {

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    fun getTransactionsBetween(
        startDate: Long,
        endDate: Long
    ): Flow<List<Transaction>> {
        return transactionDao.getTransactionsBetween(startDate, endDate)
    }

    fun getTotalSpent(
        startDate: Long,
        endDate: Long
    ): Flow<Double> {
        return transactionDao.getTotalSpent(startDate, endDate)
    }

    suspend fun updateTransaction(transaction: Transaction) {
        transactionDao.updateTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }
}