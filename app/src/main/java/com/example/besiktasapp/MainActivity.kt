package com.example.besiktasapp

import android.accounts.AuthenticatorDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besiktasapp.ui.theme.BesiktasAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()
                .background(Color(0xFFE3DFDE))){
                Column {
                    Row {
                        val painter= painterResource(id = R.drawable.besiktas3)
                        val title: String = "BEŞİKTAŞ APP"
                        Strip(painter = painter, contentDescription = "Besiktas", title = title)
                    }

                    Column {
                        Row {
                            val imageData = listOf(
                                Pair(R.drawable.rafasilva,"Rafa Silva"),
                                Pair(R.drawable.immo,"Ciro Immobile"),

                                )

                            for (data in imageData){
                                val painter = painterResource(id = data.first)
                                val description = "Description for ${data.second}"
                                Box(modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                                ){
                                    Cards(painter = painter, contentDescription = description, title = data.second)
                                }
                            }
                        }

                        Row {
                            val imageData = listOf(
                                Pair(R.drawable.gedson,"Gedson Fernandes"),
                                Pair(R.drawable.semih,"Semih Kılıçsoy")

                            )

                            for (data in imageData){
                                val painter = painterResource(id = data.first)
                                val description = "Description for ${data.second}"
                                Box(modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                                ){
                                    Cards(painter = painter, contentDescription = description, title = data.second)
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun Strip(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    title: String
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(Color.Black)
        ){

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    contentScale = ContentScale.Crop
                )

            Box (
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
            ){
                val myCustomFont = FontFamily(
                    Font(R.font.customfont)
                )
                Text(
                    title,
                    style = TextStyle(fontFamily = myCustomFont,
                        color = Color.White,
                        fontSize = 36.sp),
                        textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}

@Composable
fun Cards(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){
    val screenHeight = (LocalConfiguration.current.screenHeightDp).dp
    val imageHeight = screenHeight - 80.dp
    val myCustomFont = FontFamily(
        Font(R.font.customfont)
    )

    Card(modifier = modifier
        .fillMaxWidth()
        .height(imageHeight / 2),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(50.dp)
    ){
      Box(modifier = Modifier.fillMaxSize()){
          Image(
              painter = painter,
              contentDescription = contentDescription,
              contentScale = ContentScale.Crop
          )
          Box(modifier = Modifier
              .fillMaxSize()
              .background(
                  Brush.verticalGradient(
                      colors = listOf(
                          Color.Transparent,
                          Color.Black
                      ),
                      startY = 300f
                  )
              )
          )
          Box(modifier = Modifier
              .fillMaxSize()
              .padding(12.dp),
              contentAlignment = Alignment.BottomCenter
          ){
              Text(title, style = TextStyle(fontFamily = myCustomFont , color = Color.White, fontSize = 16.sp))
          }
      }
    }
}
