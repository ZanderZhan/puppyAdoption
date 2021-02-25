package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pic = intent.getIntExtra("pic", 0)
        val puppy = datas.find { it.pic == pic }

        setContent {
            MyTheme {
                Detail(puppy = puppy!!)
            }
        }
    }

}

@Composable
fun Detail(puppy: Puppy) {
    Column(
        modifier = Modifier.verticalScroll(ScrollState(0))
    ) {
        val typography = MaterialTheme.typography
        Image(
            painter = painterResource(id = puppy.pic),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = puppy.description,
            style = typography.h6,
            modifier = Modifier.padding(16.dp)
        )
    }
}