package com.daviddev.passwordmanager.Model
//com.example.myapplication.Model.RoomTable.kt


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


/*
@Entity(tableName = "AccountData")
data class AccountData(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,

    @ColumnInfo(name = "account_id")
    val account_id : Long =0,

    @ColumnInfo(name = "user_name")
    val user_name: String="",

    @ColumnInfo(name = "password")
    val password: String="",

    @ColumnInfo(name = "creation_date")
    val creation_date : LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "expiration_date")
    val expiration_date : LocalDateTime = LocalDateTime.now()
)

@Entity(tableName = "AccountName")
data class AccountName(
    @PrimaryKey(autoGenerate = true)
    val account_id : Long = 0,

    @ColumnInfo(name = "account_name")
    val account_name: String
)

*/
@Entity(tableName = "KeyValueAccountData")
data class KeyValueAccountData(


    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,

    @ColumnInfo(name = "account_id")
    val account_id : Long =0,

    @ColumnInfo(name = "key")
    val key: String,

    @ColumnInfo(name = "value")
    val value: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "creation_date")
    val creation_date : LocalDateTime = LocalDateTime.now()
    )