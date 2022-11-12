package com.dev.hackchange2022.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.hackchange2022.MainViewModel
import com.dev.hackchange2022.R
import com.dev.hackchange2022.data.Message
import com.dev.hackchange2022.data.UserAuth
import com.dev.hackchange2022.ui.theme.HackChange2022Theme

@Composable
fun LoginScreen(onNavigateToChat: () -> Unit, navController: NavController, viewModel: MainViewModel) {




    var login by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var showProgress: Boolean by remember {
        mutableStateOf(false)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 35.dp, end = 35.dp)
    ) {

        val (
            logo, loginTextField, passwordTextField, btnLogin, progressBar
        ) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.index),
            contentDescription = "Logo",
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .constrainAs(logo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 100.dp)
                }
        )
        OutlinedTextField(
            value = login,
            onValueChange = { newValue -> login = newValue },
            label = { Text(text = "Enter Login") },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(loginTextField) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(logo.bottom, margin = 32.dp)
                },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            label = { Text(text = "Enter Password") },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(passwordTextField) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(loginTextField.bottom, margin = 32.dp)
                },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )



        Button(
            onClick =  onNavigateToChat
//                viewModel.Auth(login.text,password.text)
//                val User = viewModel.Usera.value
//                println(User)
            ,



                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(btnLogin) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(passwordTextField.bottom, margin = 16.dp)
                    }
                ) {
                Text(text = "Login")
            }

                if (showProgress) {
                    CircularProgressIndicator(
                        modifier = Modifier.constrainAs(progressBar) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(btnLogin.bottom, margin = 16.dp)
                        }
                    )
                }
            }
    }


