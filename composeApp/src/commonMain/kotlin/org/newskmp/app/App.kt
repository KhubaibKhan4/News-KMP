package org.newskmp.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
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

    val scope = rememberCoroutineScope()
    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed)

    var newsData by remember { mutableStateOf<News?>(null) }
    var title by remember { mutableStateOf<String?>("News KMP") }
    var newsState by remember { mutableStateOf<NewsState>(NewsState.Loading) }

    LaunchedEffect(Unit) {
        viewModel.getNewsAll()
        viewModel.newsAll.collect() { state ->
            newsState = state
        }
    }

    ModalNavigationDrawer(
        modifier = Modifier.fillMaxHeight(),
        scrimColor = DrawerDefaults.scrimColor,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(8.dp))

                //Home
                NavigationDrawerItem(
                    label = {
                        Text("Home")
                    },
                    selected = true,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(4.dp))

                //Arts
                NavigationDrawerItem(
                    label = {
                        Text("Arts")
                    },
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(4.dp))
                //Science
                NavigationDrawerItem(
                    label = {
                        Text("Science")
                    },
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(4.dp))

                //All
                NavigationDrawerItem(
                    label = {
                        Text("All")
                    },
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(4.dp))
                //business
                NavigationDrawerItem(
                    label = {
                        Text("business")
                    },
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(4.dp))
                //world
                NavigationDrawerItem(
                    label = {
                        Text("world")
                    },
                    selected = false,
                    onClick = {}
                )


               Box(modifier = Modifier.fillMaxHeight(),
                   contentAlignment = Alignment.BottomCenter) {
                   Divider()
                   Text(text = "Copyright (c) 2023 The New York Times Company",
                       fontSize = MaterialTheme.typography.bodySmall.fontSize,
                       maxLines = 1,
                       overflow = TextOverflow.Ellipsis,
                       fontWeight = FontWeight.SemiBold,
                       modifier = Modifier.align(alignment = Alignment.BottomCenter)
                   )
               }
            }
        },
        gesturesEnabled = true,
        drawerState = drawerState
    ) {
        Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp).size(20.dp),
                        imageVector = Icons.Default.Menu,
                        contentDescription = null
                    )
                }

                Text(
                    text = "$title",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )

                //Spacer(modifier = Modifier.weight(1.0f))

                var isDark by LocalThemeIsDark.current
                IconButton(
                    onClick = { isDark = !isDark },
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
                    Text(error)
                }
            }


        }
    }
}

internal expect fun openUrl(url: String?)