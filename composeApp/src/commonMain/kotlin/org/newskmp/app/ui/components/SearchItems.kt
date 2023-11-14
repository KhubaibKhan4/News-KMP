package org.newskmp.app.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import org.newskmp.app.data.model.Multimedia
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.Result
import org.newskmp.app.data.model.search.Doc
import org.newskmp.app.data.model.search.SearchNews

@Composable
fun SearchList(searchNews: SearchNews) {
    LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
        items(searchNews.response.docs) { doc ->
            SearchArticleCard(doc)
        }
    }
}

@Composable
fun SearchArticleCard(doc: Doc) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle click action */ }
                .padding(16.dp)
        ) {
            SearchImage("https://static01.nyt.com/"+doc.multimedia[0].url)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = doc.abstract,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = doc.leadParagraph,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${doc.byline.original}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )


            Text(
                text = "Published ${formatDateTime(doc.pubDate)}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun SearchImage(multimedia: String) {

    Image(
        painter = rememberImagePainter(multimedia),
        contentDescription = multimedia,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
    )

}