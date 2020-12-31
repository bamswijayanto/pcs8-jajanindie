package com.bamswijayanto.jajanindie.ui.manga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamswijayanto.jajanindie.data.model.ActionState
import com.bamswijayanto.jajanindie.data.model.Manga
import com.bamswijayanto.jajanindie.data.repository.MangaRepository
import kotlinx.coroutines.launch

class MangaViewModel : ViewModel() {
    private val repo: MangaRepository by lazy { MangaRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Manga>>()
    val detailResp = MutableLiveData<Manga>()
    val searchResp = MutableLiveData<List<Manga>>()

    val detail = MutableLiveData("")
    val query = MutableLiveData("")

    fun listManga() {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.listManga()
                actionState.value = resp
                listResp.value = resp.data
                loading.value = false
            }
        }

        fun detailManga(detail: String? = this.detail.value) {
            detail?.let {
                viewModelScope.launch {
                    loading.value = true
                    val resp = repo.detailManga(it)
                    actionState.value = resp
                    detailResp.value = resp.data
                    loading.value = false
                }
            }
        }

        fun searchManga(query: String? = this.query.value) {
            query?.let {
                viewModelScope.launch {
                    loading.value = true
                    val resp = repo.searchManga(it)
                    actionState.value = resp
                    searchResp.value = resp.data
                    loading.value = false
                }
            }
        }
    }
