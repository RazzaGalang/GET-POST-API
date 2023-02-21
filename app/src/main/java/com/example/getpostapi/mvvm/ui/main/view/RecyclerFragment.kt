package com.example.getpostapi.mvvm.ui.main.view

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.getpostapi.databinding.FragmentRecyclerBinding
import com.example.getpostapi.mvvm.ui.main.adapter.ActivityAdapter
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api.ApiHelper
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api.RetrofitBuilder
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.ui.base.ViewModelFactory
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.ui.main.viewmodel.MainViewModel
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.utils.Status

class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var viewModel: MainViewModel
    private var adapter: ActivityAdapter = ActivityAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.getParentingHubService()))
        )[MainViewModel::class.java]
    }

    private fun setupUI() {
        binding.GETRecyclerView.adapter = adapter
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun setupObservers() {
        viewModel.getUser().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { users -> adapter.items = users.data }

                        Log.e(ContentValues.TAG, "setupObservers: SUCCESS")
                    }
                    Status.ERROR -> {
                        Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
                        Log.e(ContentValues.TAG, "setupObservers: " + it.message)
                    }
                    Status.LOADING -> {
                        Log.e(ContentValues.TAG, "setupObservers: LOADING")
                    }
                }
            }
        })
    }
}