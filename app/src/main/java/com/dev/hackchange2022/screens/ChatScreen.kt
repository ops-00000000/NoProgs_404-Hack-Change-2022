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
import com.dev.hackchange2022.MainActivity
import com.dev.hackchange2022.MainViewModel
import com.dev.hackchange2022.MessageData
import com.dev.hackchange2022.R
import com.dev.hackchange2022.data.Message
import com.dev.hackchange2022.ui.theme.HackChange2022Theme



@Composable
fun ChatScreen(navController: NavController, viewModel: MainViewModel) {
//    val viewModel1 = hiltViewModel<MainViewModel>()
//    val allHistory = viewModel1.allMsg.observeAsState(listOf<Message>()).value
    HackChange2022Theme {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            viewModel.getHistory()

            items(MessageData.MessageList) { message ->
                MessageBox(message)
            }
        }
    }
}

@Composable
fun MessageBox(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.otkritie),
            contentDescription = "profile logo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Cyan, CircleShape)
        )


        Spacer(modifier = Modifier.width(8.dp))
        var msgExpanded by remember {
            mutableStateOf(false)
        }

        Column(modifier = Modifier.clickable { msgExpanded = !msgExpanded }) {
            Text(
                text = msg.sender,
                color = Color.Cyan,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.large, color = Color.LightGray) {

                Text(
                    text = msg.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(all = 8.dp),
//                    maxLines = if(msgExpanded) Int.MAX_VALUE else 1)
                )

            }

        }
    }
}