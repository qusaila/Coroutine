package com.example.coroutine.ui.main_page

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.coroutine.R
import com.example.coroutine.base.BaseActivity
import com.example.coroutine.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    var mainViewModel: MainViewModel? = null
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding!!.obj = mainViewModel
        binding!!.lifecycleOwner = this

    }
}