package org.newskmp.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.newskmp.app.data.model.search.Doc
import org.newskmp.app.data.model.search.SearchNews
import org.newskmp.app.isAndroid
import org.newskmp.app.ui.screen.largescreen.search.detail.SearchDetail
import org.newskmp.app.ui.screen.largescreen.search.detail.SearchDetailLarge
import org.newskmp.app.util.Constant.NO_PARAGRAPH
import org.newskmp.app.util.Constant.NO_TITLE

@Composable
fun SearchList(searchNews: SearchNews) {
    LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
        searchNews.response.docs.let {
            items(it) { doc ->
                SearchArticleCard(doc!!)
            }
        }

    }
}

@Composable
fun SearchArticleCard(doc: Doc) {
    val navigator = LocalNavigator.current
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (isAndroid()){
                    navigator!!.push(SearchDetail(doc))
                    }else{
                        navigator!!.push(SearchDetailLarge(doc))
                    }
                }
                .padding(16.dp)
        ) {
            val imageUrl =if (doc.multimedia.isNullOrEmpty())"https://static01.nyt.com/vi-assets/images/share/1200x675_nameplate.png" else "https://static01.nyt.com/${doc?.multimedia?.get(0)?.url ?: "vi-assets/images/share/1200x675_nameplate.png"}"
            println("Image URL: $imageUrl")

            val painterResource = asyncPainterResource(data = imageUrl)

            KamelImage(
                resource = painterResource,
                contentDescription = "Image Description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                onLoading = {
                    CircularProgressIndicator(it)
                },
                onFailure = {
                    Text("No Image Found.")
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            doc.abstract?.let {
                Text(
                    text = it ?: NO_TITLE,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            doc.leadParagraph?.let {
                Text(
                    text = it ?: NO_PARAGRAPH,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                text = "${doc.byline?.original ?: "by KMP News"}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )


//            Text(
//                text = "Published ${doc.pubDate?.let { formatDateTime(it) }}",
//                style = MaterialTheme.typography.labelMedium,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
        }
    }
}
