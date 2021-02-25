/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.androiddevchallenge.ui.theme.MyTheme

class Puppy(val name: String, val pic: Int, val description: String)

val datas = listOf(
    Puppy("bedlingto", R.mipmap.bedlingto, "The Bellington Terrier is native to England and originated in the 19th century. Originally named the Rosberine Terrier from its origin, it is heavier and has shorter legs than the current breed, and was used to hunt foxes, hares and badgers. The Bedlington Terrier is believed to have been bred by mating with a Bedlington bitch in 1825. In the late 18th and early 19th centuries, breeds such as the Whippet and the Dandy Dingmond terrier were interbred to produce such a tall, beautiful, fast and agile breed, while retaining the original vitality and endurance character. Bedlington miners used as small game hunting dogs and fighting dogs. First exhibited as a separate breed in 1877."),
    Puppy("bichonfr", R.mipmap.bichonfr, "Dog is a diminutive, muscular, white powder-puff dog with a cheerful temperament, which is reflected in his feathered tail and inquisitive eyes. There is nothing heavy or impotent about this breed, so there is no reason for its gait to be unsymmetrical or unsound. Any deviation from the ideal bichon dog with curly hair as described in the standard is a defect and will be penalized according to the degree of deviation. Structural defects in the Bichon are as undesirable as any other breed, although these may not be detailed in the breed's specification. Overall Appearance: A cheerful, playful little dog with a lively gait, a muzzle of medium length, and long, shaggy hair very similar to the coat of a Mongolian goat. The head is high, the eyes are dark, and the expression is lively and expressive."),
    Puppy("chihuahua", R.mipmap.chihuahua, "The smallest of the small breeds of dogs of the genus Chihuahua, the elegant, alert, fast-moving dog is widely admired for its well-proportioned build and petite size. Chihuahuas are not only cute little toy dogs, but also possess the hunting and guarding instincts of large dogs, with a terrier-like temperament. This dog is divided into long-haired and short-haired breeds. This dog is small in size, not shy of other dogs, and extremely monopolistic towards its master. Short-haired species differ from long-haired species in their glossy, close-fitting, silky short coat. Long haired Chihuahuas have a tendency to shiver like short haired Chihuahuas except for their thick back hair, which should not be thought of as a cold."),
    Puppy("lakeland", R.mipmap.lakeland, "Originally in England, it originated in the 18th century. Originally known as the PatterdaleTerrier, it is a Bedlington Terrier bred with an old English Wider Terrier in the lakeside region of northern England. Originally there were a number of branches, which were grouped together in 1912. Similar to the Welsh Terrier but smaller in size, it has a deep and narrow body, allowing it to burrow smoothly into the rock and do its job. It has legs long enough to allow it to adapt to a variety of rugged terrain."),
    Puppy("maltese", R.mipmap.maltese, "The Maltese is a toy dog covered from head to toe in long white silky hair. His manner is gentle and affectionate, eager and lively, and despite his small size he possesses the energy required to be a satisfactory companion dog. Maltese is a gentle little dog that is the pet of the whole family. It can be safely allowed to play with children. Usually in good health and still vigorous towards the end of life. The Maltese is one of the oldest European pet dogs."),
    Puppy("pomerania", R.mipmap.pomerania, "German fox dog, including the poodle and squirrel dog (Pomeranian). The Pomeranian is a compact, short-backed, active toy dog. It has a soft, dense undercoat and a stiff coat. The heavily furred tail is set high and laid flat on the back. It has an alert disposition, an intelligent expression, a brisk manner and a curious nature. The Pomeranian gait is proud, solemn, and lively. Its temperament and actions are healthy."),
    Puppy("pug", R.mipmap.pug, "The charming and elegant pug (or pug) was officially named pug in the late 18th century, with the archaic meaning \"ghost\", \"lion nose\" or \"little monkey\". The pug is a caring, cuddly little dog that does not need exercise or regular grooming, but does need company."),
    Puppy("toypoodl", R.mipmap.toypoodl, "For standard, miniature, or toy poodles, the criteria are the same for everything except height. The Poodle is an active, alert and graceful breed, with good proportions and vigorous movement, showing a confident posture."),
    Puppy("weishcor", R.mipmap.weishcor, "There are two types of Welsh Corgi: the Cardigan Welsh Corgi and the Pembroke Welsh Corgi. The Pembroke Corgi has a shorter body, straighter and lighter leg bones, and the Welsh Corgi has a better back coat. But temperamentally, the Pembroke Corgi is restless, excitable, and less tame than the Cardigan Welsh Corgi."),
    Puppy("yorkshre", R.mipmap.yorkshre, "Cheerful, lively, not very strong or strong, not rustic or rough in appearance. Leg not too short or too long, standing like an alert hunter with wide range of control. It is a type of small pet dog. Personality is smart and confident, alert and friendly but also take a little stubborn, generally like sajiao.")
)


class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        PuppyGrids(datas)
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyGrids(puppys: List<Puppy>) {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Adaptive(100.dp),
    ) {
        items(puppys) { puppy ->
            CardItem(
                puppy = puppy,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        startActivity(context, Intent(context, DetailActivity::class.java).apply {
                            putExtra("pic", puppy.pic)
                        }, null)
                    }
            )
        }
    }
}

@Composable
fun CardItem(puppy: Puppy, modifier: Modifier) {
    Card {
        Column(modifier = modifier) {
            Image(
                painter = painterResource(puppy.pic),
                contentDescription = puppy.name,
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
            )
            Text(text = puppy.name)
        }
    }
}