package com.daviddev.passwordmanager.Model
//com.example.myapplication.Model.RoomTable.kt


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


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