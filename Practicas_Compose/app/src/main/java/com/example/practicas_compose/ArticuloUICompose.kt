package com.example.practicas_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas_compose.ui.theme.Practicas_ComposeTheme

class ArticuloUICompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practicas_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleScreen()
                }
            }
        }
    }
}

@Composable
fun ArticleScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BannerImage()
        TitleText()
        DescriptionText()
        DetailsText()
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun BannerImage() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun TitleText() {
    Text(
        text = stringResource(R.string.jetpack_compose_tutorial_title),
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun DescriptionText() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun DetailsText() {
    Text(
        text = stringResource(R.string.jetpack_compose_tutorial_details),
        fontSize = 14.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PracticeBannerPreview() {
    Practicas_ComposeTheme {
        ArticleScreen()
    }
}


