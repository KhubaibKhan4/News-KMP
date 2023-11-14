package org.newskmp.app.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import org.newskmp.app.data.model.Multimedia
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.Result

@Composable
fun TopNews(news: News) {
    Column {
        LatestNewsText()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 8.dp, top = 8.dp)
        ) {
            items(news.results) { result ->
                TopNewsCard(result)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}


@Composable
fun TopNewsCard(result: Result) {

    Card(
        modifier = Modifier
            .width(345.dp)
            .height(240.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors()
    ) {
        Box {
            result.multimedia?.let { NewImage(it) }

            Text(
                text = result.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 4.dp, end = 4.dp, bottom = 4.dp),
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

@Composable
fun NewImage(multimedia: List<Multimedia>) {

    Image(
        painter = rememberImagePainter(multimedia[0].url),
        contentDescription = multimedia[0].caption,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )

}

@Composable
fun LatestNewsText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
        // .padding(start = 2.dp, end = 2.dp),
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.75f).pointerHoverIcon(
                icon = PointerIcon.Hand
            ),
            text = "Latest News",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 20.8.sp,
                fontWeight = FontWeight(700),
            )
        )
        Text(
            text = "See All",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF0080FF),
            ),
            modifier = Modifier.pointerHoverIcon(
                icon = PointerIcon.Hand
            )
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Sharp.KeyboardArrowRight,
                contentDescription = "forward",
                tint = Color(0xFF0080FF),
                modifier = Modifier.pointerHoverIcon(
                    icon = PointerIcon.Hand
                )
            )
        }


    }
}