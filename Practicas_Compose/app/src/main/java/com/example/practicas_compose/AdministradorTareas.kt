package com.example.practicas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas_compose.ui.theme.Practicas_ComposeTheme

class AdministradorTareas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practicas_ComposeTheme {
                TaskAdministrator()
            }
        }
    }
}

@Composable
fun TaskAdministrator() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OkImage()
            FirstText()
            SecondText()
        }
    }
}

@Composable
fun OkImage() {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun FirstText() {
    Text(
        text = "All tasks completed",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun SecondText() {
    Text(
        text = "Nice work!",
        fontSize = 16.sp
    )
}

@Preview(showBackground = true)
@Composable
fun TaskAdministratorPreview() {
    Practicas_ComposeTheme {
        TaskAdministrator()
    }
}

