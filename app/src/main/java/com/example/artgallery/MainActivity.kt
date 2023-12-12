package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGallery()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtGalleryPreview() {
    ArtGalleryTheme {
        ArtGallery()
    }
}

@Composable
fun ArtGallery() {
    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ImageSwitcher()
        Spacer(modifier = Modifier.padding(32.dp))
    }
}

@Composable
fun ImageSwitcher(modifier: Modifier = Modifier) {

    val imageIndex = remember { mutableIntStateOf(0) }

    val images = listOf(
        R.drawable._03px_michelangelo___fresco_of_the_last_judgement,
        R.drawable._20px_michelangelo_s_pieta_5450_cropncleaned_edit,
        R.drawable.img_3600,
        R.drawable._200px_michelangelo_buonarroti_tondo_doni,
        R.drawable._00px_michelangelo_s_david_2015
    )

    Image(
        painter = painterResource(images[imageIndex.intValue]),
        contentDescription = "Image",
        modifier = Modifier.size(500.dp)
    )

    Row {
        SwitchButton(
            valueText = "Previous"
        ) {
            if (imageIndex.intValue > 0) {
                imageIndex.intValue--
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        SwitchButton(
            valueText = "Next"
        ) {
            if (imageIndex.intValue < images.size - 1) {
                imageIndex.intValue++
            }
        }
    }
    Spacer(modifier = Modifier.width(16.dp))
}

@Composable
fun SwitchButton(
    valueText: String,
    buttons: () -> Unit = {}
) {
    Row (
        modifier = Modifier,
        horizontalArrangement = Arrangement.End
    ){
        Button(onClick = {
            buttons()
        }) {
            Text(text = valueText)
        }

    }
}

@Composable
fun imageSection() {
    Column(

    ) {

    }
}