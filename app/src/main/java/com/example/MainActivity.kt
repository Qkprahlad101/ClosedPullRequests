package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.closedpullrequests.ui.PullRequestViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PullRequestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[PullRequestViewModel::class.java]

        viewModel.pullRequests.observe(this) {
            // update UI
        }

        viewModel.loadClosedPullRequests("Qkprahlad101", "repo")
    }

}