package com.abhishek.pouchaitracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val amount: Double,

    val type: String,              // DEBIT or CREDIT

    val category: String,          // Food, Travel, Shopping, etc.

    val merchant: String? = null,

    val dateTime: Long,            // Unix timestamp

    val source: String,            // CASH or UPI

    val accountLast4: String? = null,

    val upiReference: String? = null,

    val bank: String? = null,

    val confidence: Double = 1.0,

    val isManuallyCorrected: Boolean = false,

    val createdAt: Long = System.currentTimeMillis()
)