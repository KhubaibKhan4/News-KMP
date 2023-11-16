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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SmsFailed
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
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import org.newskmp.app.data.model.news.Multimedia
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.Result
import org.newskmp.app.isAndroid
import org.newskmp.app.ui.screen.smallscreen.detail.DetailScreen
import org.newskmp.app.ui.screen.smallscreen.detail.DetailScreenLarge
import kotlin.time.Duration

@Composable
fun NewsList(news: News) {
    LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
        items(news.results) { news ->
            NewsArticleCard(news)
        }
    }
}

@Composable
fun NewsArticleCard(article: Result) {
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
                    if (isAndroid()) {
                        navigator!!.push(DetailScreen(article))
                    } else {
                        navigator!!.push(DetailScreenLarge(article))
                    }
                }
                .padding(16.dp)
        ) {
            article.multimedia?.let { NewsImage(it) }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = article.abstract,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${article.byline}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )


            Text(
                text = "Published ${formatDateTime(article.publishedDate)}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun NewsImage(multimedia: List<Multimedia>) {
    val painterRes = asyncPainterResource(multimedia[0].url)
    KamelImage(
        resource = painterRes,
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop,
        onLoading = {
            CircularProgressIndicator(it)
        },
        onFailure = {
            Image(imageVector = Icons.Default.SmsFailed, contentDescription = null)
        }
    )
}

fun formatDateTime(dateTimeString: String): String {
    try {
        val now = Clock.System.now()
        // Remove the extra colon in the offset part
        val correctedDateTimeString = dateTimeString.replaceFirst(":(\\d{2})$", "$1")
        val instantInThePast: Instant = Instant.parse(correctedDateTimeString)
        val durationSinceThen: Duration = now - instantInThePast

        return when {
            durationSinceThen.inWholeDays > 365 -> "${durationSinceThen.inWholeDays / 365} years ago"
            durationSinceThen.inWholeDays > 30 -> "${durationSinceThen.inWholeDays / 30} months ago"
            durationSinceThen.inWholeDays > 0 -> "${durationSinceThen.inWholeDays} days ago"
            durationSinceThen.inWholeHours > 0 -> "${durationSinceThen.inWholeHours} hours ago"
            durationSinceThen.inWholeMinutes > 0 -> "${durationSinceThen.inWholeMinutes} minutes ago"
            else -> "Just now"
        }
    } catch (e: Exception) {
        // Handle parsing exception
        return "Invalid date-time format"
    }
}



