package com.jinyeob.eqt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinyeob.domain.model.MccheyneItem
import com.jinyeob.domain.repository.MccheyneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mccheyneRepository: MccheyneRepository): ViewModel() {
    val mccheyneFlow = mccheyneRepository.getMccheyneItems().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = MccheyneItem()
    )
}
