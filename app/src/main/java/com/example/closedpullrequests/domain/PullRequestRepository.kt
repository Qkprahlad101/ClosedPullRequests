package com.example.closedpullrequests.domain

import com.example.closedpullrequests.model.PullRequestApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PullRequestRepository {

    private val api = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PullRequestApiService::class.java)

    suspend fun getClosedPullRequests(owner: String, repo: String) =
        api.getClosedPullRequests(owner, repo)

}