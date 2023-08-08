package com.example.sampleapp_mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp_mvvm.data.NetworkResult
import com.example.sampleapp_mvvm.databinding.ActivityMainBinding
import com.example.sampleapp_mvvm.domain.User
import com.example.sampleapp_mvvm.ui.MainViewModel
import com.example.sampleapp_mvvm.ui.MainViewModelFactory
import com.example.sampleapp_mvvm.ui.UserAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as App).appComponent.inject(this@MainActivity)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        initLayout()
    }

    private fun initLayout() {
        binding.apply {
            btnUpdateData.setOnClickListener {
                viewModel.fetchUserData()
                observeUserData()
            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = userAdapter
            }
        }
    }

    private fun observeUserData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect { result ->
                    when (result) {
                        is NetworkResult.Loading -> showProgressBar()
                        is NetworkResult.Success -> {
                            hideProgressBar()
                            if (result.data != null) {
                                displayUserData(result.data)
                            } else {
                                showErrorMessage(result.message.toString())
                            }
                        }
                        is NetworkResult.Fail -> {
                            hideProgressBar()
                            showErrorMessage(result.message.toString())
                        }
                    }
                }
            }
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            btnUpdateData.visibility = View.GONE
            recyclerView.visibility = View.GONE
        }
    }

    private fun displayUserData(users: List<User>) {
        binding.recyclerView.visibility = View.VISIBLE
        userAdapter.listDiffer.submitList(users)
    }

    private fun showErrorMessage(message: String) {
        binding.errorMessage.apply {
            visibility = View.VISIBLE
            text = message
        }
    }
}