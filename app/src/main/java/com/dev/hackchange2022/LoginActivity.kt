package com.dev.hackchange2022

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import com.dev.hackchange2022.ui.theme.HackChange2022Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackChange2022Theme {
                        LoginScreen()

            }
        }
    }

    @Composable
    fun LoginScreen(){

        var login by remember{
            mutableStateOf(TextFieldValue(""))
        }

        var password by remember{
            mutableStateOf(TextFieldValue(""))
        }

        var showProgress: Boolean by remember {
            mutableStateOf(false)
        }

        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .padding(start = 35.dp, end = 35.dp)
        ) {

            val(
            logo, loginTextField, passwordTextField,btnLogin, progressBar
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
                onValueChange ={newValue -> login = newValue},
                label = {Text(text = "Enter Login")},
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
                onValueChange ={newValue -> password = newValue},
                label = {Text(text = "Enter Password")},
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
                onClick = {
                   TODO()
                },
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

            if (showProgress){
                CircularProgressIndicator(
                    modifier = Modifier.constrainAs(progressBar){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(btnLogin.bottom, margin = 16.dp)
                    }
                )
            }
        }
    }
}





