package com.example.closedpullrequests.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.closedpullrequests.domain.PullRequestRepository
import com.example.closedpullrequests.model.PullRequest
import kotlinx.coroutines.launch

class PullRequestViewModel : ViewModel() {

    private val repository = PullRequestRepository()

    private val _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>>
        get() = _pullRequests

    fun loadClosedPullRequests(owner: String, repo: String) {
        viewModelScope.launch {
            _pullRequests.value = repository.getClosedPullRequests(owner, repo)
        }
    }

}