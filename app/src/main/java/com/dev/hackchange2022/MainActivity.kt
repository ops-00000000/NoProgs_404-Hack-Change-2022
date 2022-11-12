package com.dev.hackchange2022

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dev.hackchange2022.ui.theme.HackChange2022Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            HackChange2022Theme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                val allHistory = viewModel.allMsg.observeAsState(listOf()).value
                MyAppNavHost(navController = navController, viewModel = viewModel )

            }
        }
    }



}





