package com.abhishek.pouchaitracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.abhishek.pouchaitracker.data.entity.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions ORDER BY dateTime DESC")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("""
        SELECT * FROM transactions
        WHERE dateTime BETWEEN :startDate AND :endDate
        ORDER BY dateTime DESC
    """)
    fun getTransactionsBetween(
        startDate: Long,
        endDate: Long
    ): Flow<List<Transaction>>

    @Query("""
        SELECT COALESCE(SUM(amount), 0)
        FROM transactions
        WHERE type = 'DEBIT'
        AND dateTime BETWEEN :startDate AND :endDate
    """)
    fun getTotalSpent(
        startDate: Long,
        endDate: Long
    ): Flow<Double>

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}