package com.daviddev.passwordmanager.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.daviddev.passwordmanager.room.accountDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddAccountViewModel  @Inject constructor(private val repository: accountDataRepository) : ViewModel() {
    init{
        Log.i("Seguimiento","desde el constructor de AddAccountViewModel ." )
    }
  // var accountData = mutableStateOf(KeyValueAccountData())



}