package org.newskmp.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import org.newskmp.app.data.model.News
import org.newskmp.app.repository.Repository
import org.newskmp.app.theme.AppTheme
import org.newskmp.app.theme.LocalThemeIsDark
import org.newskmp.app.ui.components.NewsList
import org.newskmp.app.util.NewsState
import org.newskmp.app.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun App() = AppTheme {
    val repository = Repository()
    val viewModel = MainViewModel(repository)

    var newsData by remember { mutableStateOf<News?>(null) }
    var title by remember { mutableStateOf<String?>("News KMP") }
    var newsState by remember { mutableStateOf<NewsState>(NewsState.Loading) }

    LaunchedEffect(Unit) {
        viewModel.getNewsAll()
        viewModel.newsAll.collect() { state ->
            newsState = state
        }
    }

    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$title",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            var isDark by LocalThemeIsDark.current
            IconButton(
                onClick = { isDark = !isDark }
            ) {
                Icon(
                    modifier = Modifier.padding(8.dp).size(20.dp),
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = null
                )
            }
        }

        when (newsState) {
            is NewsState.Loading -> {
                title = "Loading, Please Wait..."
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is NewsState.Success -> {
                title = "News KMP"
                val response = (newsState as NewsState.Success).news
                newsData = response
                NewsList(newsData!!)
                FlowRow {
                    Text("$newsData")
                }
            }

            is NewsState.Error -> {
                val error = (newsState as NewsState.Error).error
                Text("$error")
            }
        }


    }
}

internal expect fun openUrl(url: String?)