package com.example.todoupdate.ui.screens.list.listviewmodel

import androidx.lifecycle.ViewModel
import com.example.todoupdate.data.repository.DataStoreRepository
import com.example.todoupdate.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ToDoRepository,
    private val dataStoreRepository: DataStoreRepository /*( ← Inject DataStore Repository )*/
) : ViewModel() {
}