package org.newskmp.app.ui.screen.largescreen.search.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SmsFailed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.newskmp.app.data.model.search.Doc
import org.newskmp.app.data.model.search.SearchNews
import org.newskmp.app.ui.screen.largescreen.search.detail.SearchDetailLarge
import org.newskmp.app.util.Constant.NO_TITLE

@Composable
fun SearchListLarge(searchNews: SearchNews) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(170.dp),
        state = rememberLazyGridState(),
        userScrollEnabled = true, contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(searchNews.response.docs) { result ->
            SearchNewsCard(result!!)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}


@Composable
fun SearchNewsCard(doc: Doc) {
    val navigator = LocalNavigator.current
    Card(
        modifier = Modifier
            .width(345.dp)
            .height(240.dp)
            .clickable {
                navigator!!.push(SearchDetailLarge(doc))
            },
        colors = CardDefaults.cardColors()
    ) {
        Box {
            val imageUrl =if (doc.multimedia.isNullOrEmpty())"https://static01.nyt.com/vi-assets/images/share/1200x675_nameplate.png" else "https://static01.nyt.com/${doc?.multimedia?.get(0)?.url ?: "vi-assets/images/share/1200x675_nameplate.png"}"
            println("Image URL: $imageUrl")
            val painterResource = asyncPainterResource(data = imageUrl)
            KamelImage(
                resource = painterResource,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                onLoading = {
                    CircularProgressIndicator(
                        progress = it,
                        trackColor = if (isSystemInDarkTheme()) Color.Blue else Color.Red
                    )
                },
                onFailure = {
                    Image(imageVector = Icons.Default.SmsFailed, contentDescription = null)
                },
                animationSpec = tween(),
                alpha = DefaultAlpha
            )
            Text(
                text = doc.abstract ?: NO_TITLE,
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
