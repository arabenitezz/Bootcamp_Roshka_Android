package com.example.practicas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
                    BannerImage(modifier = Modifier.fillMaxSize()

                    )
                }
            }



        }
    }
}

@Composable
fun BannerImage(modifier: Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier = modifier,
        contentAlignment = Alignment.TopStart) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PracticeBannerPreview() {
    Practicas_ComposeTheme {
        BannerImage(modifier = Modifier.fillMaxSize())
    }
}
