package com.example.getpostapi.mvvm.ui.main.view

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.getpostapi.R
import com.example.getpostapi.databinding.FragmentRecyclerBinding
import com.example.getpostapi.databinding.FragmentRegisterBinding
import com.example.getpostapi.mvvm.data.model.UserModel
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api.ApiHelper
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api.ApiService
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api.RetrofitBuilder
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.ui.base.ViewModelFactory
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.ui.main.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit()
    }

    private fun submit(){
        binding.buttonPOST.setOnClickListener {
//            postData()
        }
    }

    private fun postData(){
        var addData = com.example.getpostapi.mvvm.data.model.Data()
        addData.username = binding.inputUsername.text.toString()
        addData.fullName = binding.inputUsername.text.toString()
        addData.email = binding.inputUsername.text.toString()
        addData.gender = binding.inputUsername.text.toString()

        val retro = RetrofitBuilder.getParentingHubService()
        retro.register(addData).enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}