package org.newskmp.app.ui.screen.smallscreen.home.headlines

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.Result

@Composable
fun HeadlineList(news: News) {
    val coroutineScope = rememberCoroutineScope()

    // State to track the current index of the displayed news headline
    var currentIndex by remember { mutableStateOf(0) }

    // Launch the marquee effect when the component is first composed or when the news list changes
    LaunchedEffect(news) {
        // Run the marquee effect indefinitely
        while (true) {
            // Delay for 1 second before moving to the next news headline
            delay(1000)

            // Move to the next news headline
            currentIndex = (currentIndex + 1) % news.results.size
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        // Display the current news headline with the marquee effect
        item {
            HeadlineItem(result = news.results[currentIndex])
        }
    }
}

@Composable
fun HeadlineItem(result: Result) {
    // Adjust the font size as needed
    val fontSize = 18.sp

    // News headline with scrolling inside a Card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(50.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // "Headlines" tag on the left side with a different design
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                Text(
                    text = "Headlines",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = fontSize,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Actual News headline with scrolling on the right side
            Text(
                text = result.abstract,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
                    .scrollable(
                        // Use a custom scroll state for smooth scrolling
                        rememberScrollState(),
                        // Enable horizontal scrolling
                        orientation = Orientation.Horizontal,
                        // Scrolling behavior
                        enabled = true,
                    ),
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = fontSize),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
