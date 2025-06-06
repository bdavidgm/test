package com.daviddev.passwordmanager.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity(tableName = "KeyValueAccountData")
data class KeyValueAccountData(

    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,

    @ColumnInfo(name = "account_id")
    val accountId : Long =0,

    @ColumnInfo(name = "key")
    val key: String,

    @ColumnInfo(name = "value")
    val value: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "creation_date")
    val creationDate : LocalDateTime = LocalDateTime.now()

    )