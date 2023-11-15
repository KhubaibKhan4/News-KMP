package org.newskmp.app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch
import org.newskmp.app.data.model.News
import org.newskmp.app.data.model.search.SearchNews
import org.newskmp.app.isAndroid
import org.newskmp.app.repository.Repository
import org.newskmp.app.theme.LocalThemeIsDark
import org.newskmp.app.ui.components.NewsList
import org.newskmp.app.ui.components.SearchList
import org.newskmp.app.ui.components.TopNews
import org.newskmp.app.util.NewsState
import org.newskmp.app.util.SearchState
import org.newskmp.app.viewmodel.MainViewModel

class HomeScreen() : Screen {
    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    override fun Content() {
        val repository = Repository()
        val viewModel = MainViewModel(repository)

        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        var newsData by remember { mutableStateOf<News?>(null) }
        var searchData by remember { mutableStateOf<SearchNews?>(null) }
        var title by remember { mutableStateOf<String?>("News KMP") }
        var newsState by remember { mutableStateOf<NewsState>(NewsState.Loading) }
        var searchSate by remember { mutableStateOf<SearchState>(SearchState.Loading) }
        var isHomeNews by remember { mutableStateOf(false) }
        var isSearch by remember { mutableStateOf(false) }
        var text by remember { mutableStateOf("") }

        LaunchedEffect(isHomeNews) {
            viewModel.getHome()
            viewModel.newsHome.collect() { state ->
                newsState = state
            }
        }
        if (isSearch) {
            scope.launch {
                viewModel.getSearchNews(text)
                viewModel.newsSearch.collect() { state ->
                    searchSate = state
                }
            }
        }

        /*

        1. Navigation Rails needs to be integrated on Desktop Version.
        2. Scrollbar need to be added to Web & Desktop Versions.
        3. need to add native UI to Desktop and Web Versions
        4. need to add some features to Mobile Versions.
         */

        // Define a list of categories
        val categories =
            listOf(
                "Home",
                "US",
                "Technology",
                "Politics",
                "World",
                "Sports",
                "Business",
                "Science",
                "Arts",
                "AutoMobiles",
                "Books Review",
                "Fashion",
                "Food",
                "Health",
                "Insider",
                "Magazine",
                "Movies",
                "NY Region",
                "Obituaries",
                "Opinion",
                "Real Estate",
                "Sunday Review",
                "Theater",
                "T-Magazine",
                "Travel",
                "UpShot"
            )

        // Use a state to track the selected category
        var selectedCategory by remember { mutableStateOf(categories.first()) }


        ModalNavigationDrawer(
            modifier = Modifier.fillMaxHeight(),
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                    Divider()
                    NavigationDrawerItem(
                        label = { Text(text = "Setting") },
                        selected = false,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        }
                    )

                }
            },
            gesturesEnabled = true,
        ) {

            Column(
                modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        }
                    ) {
                        Icon(
                            modifier = Modifier.pointerHoverIcon(icon = PointerIcon.Hand)
                                .padding(8.dp)
                                .size(20.dp),
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
                            modifier = Modifier.size(20.dp),
                            imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = null
                        )
                    }
                }

                if (isAndroid()) {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = {
                            Text("Search News...")
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                isSearch = !isSearch
                            }) {
                                Image(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth(0.70f)
                            .clip(shape = RoundedCornerShape(24.dp))
                            .align(alignment = Alignment.CenterHorizontally),
                        maxLines = 1,
                        colors = TextFieldDefaults.colors(
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                } else {
                    if (isSearch){
                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = {
                                Text("Search News...")
                            },
                            trailingIcon = {
                                IconButton(onClick = {
                                    isSearch = !isSearch
                                }) {
                                    Image(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth(0.70f)
                                .clip(shape = RoundedCornerShape(24.dp))
                                .align(alignment = Alignment.CenterHorizontally),
                            maxLines = 1,
                            colors = TextFieldDefaults.colors(
                                disabledTextColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                    }
                }

                // LazyRow for category buttons
                LazyRow {
                    items(categories) { category ->
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .pointerHoverIcon(icon = PointerIcon.Hand)
                        ) {
                            ElevatedButton(
                                onClick = {
                                    scope.launch {
                                        // Handle category-specific logic here, if needed
                                        when (category) {
                                            "Home" -> {
                                                isHomeNews = !isHomeNews
                                                selectedCategory =
                                                    category // Set selectedCategory explicitly for "Home" category
                                            }

                                            "US" -> {
                                                viewModel.getUs()
                                                viewModel.newsUs.collect() { newsState = it }
                                            }

                                            "Technology" -> {
                                                viewModel.getTechnology()
                                                viewModel.newsTechnology.collect() {
                                                    newsState = it
                                                }
                                            }

                                            "Politics" -> {
                                                viewModel.getPolitics()
                                                viewModel.newsPolitics.collect() { newsState = it }
                                            }

                                            "World" -> {
                                                viewModel.getWorld()
                                                viewModel.newWorld.collect() { newsState = it }
                                            }

                                            "Sports" -> {
                                                viewModel.getSports()
                                                viewModel.newsSports.collect() { newsState = it }
                                            }

                                            "Business" -> {
                                                viewModel.getBusiness()
                                                viewModel.newsBusiness.collect() { newsState = it }
                                            }

                                            "Science" -> {
                                                viewModel.getScience()
                                                viewModel.newsScience.collect { newsState = it }
                                            }

                                            "Arts" -> {
                                                viewModel.getArts()
                                                viewModel.newsArts.collect { newsState = it }
                                            }

                                            "AutoMobiles" -> {
                                                viewModel.getAutoMobiles()
                                                viewModel.newsAutoMobiles.collect { newsState = it }
                                            }

                                            "Books Review" -> {
                                                viewModel.getBookReviews()
                                                viewModel.newsBookReviews.collect { newsState = it }
                                            }

                                            "Fashion" -> {
                                                viewModel.getFashion()
                                                viewModel.newsFashion.collect { newsState = it }
                                            }

                                            "Food" -> {
                                                viewModel.getFood()
                                                viewModel.newsFood.collect { newsState = it }
                                            }

                                            "Health" -> {
                                                viewModel.getHealth()
                                                viewModel.newsHealth.collect { newsState = it }
                                            }

                                            "Insider" -> {
                                                viewModel.getInsider()
                                                viewModel.newsInsider.collect { newsState = it }
                                            }

                                            "Magazine" -> {
                                                viewModel.getMagazine()
                                                viewModel.newsMagazine.collect { newsState = it }
                                            }

                                            "Movies" -> {
                                                viewModel.getMovies()
                                                viewModel.newsMovies.collect { newsState = it }
                                            }

                                            "NY Region" -> {
                                                viewModel.getNYRegion()
                                                viewModel.newsNYRegion.collect { newsState = it }
                                            }

                                            "Obituaries" -> {
                                                viewModel.getObituaries()
                                                viewModel.newsObituaries.collect { newsState = it }
                                            }

                                            "Opinion" -> {
                                                viewModel.getOpinion()
                                                viewModel.newsOpinion.collect { newsState = it }
                                            }

                                            "Real Estate" -> {
                                                viewModel.getRealEstate()
                                                viewModel.newsRealEstate.collect { newsState = it }
                                            }

                                            "Sunday Review" -> {
                                                viewModel.getSundayReview()
                                                viewModel.newsSundayReview.collect {
                                                    newsState = it
                                                }
                                            }

                                            "Theater" -> {
                                                viewModel.getTheater()
                                                viewModel.newsTheater.collect { newsState = it }
                                            }

                                            "T-Magazine" -> {
                                                viewModel.getTMagazine()
                                                viewModel.newsTMagazine.collect { newsState = it }
                                            }

                                            "Travel" -> {
                                                viewModel.getTravel()
                                                viewModel.newsTravel.collect { newsState = it }
                                            }

                                            "UpShot" -> {
                                                viewModel.getUpShot()
                                                viewModel.newsUpShot.collect { newsState = it }
                                            }
                                        }

                                    }
                                },
                                // if (selectedCategory == category) MaterialTheme.colorScheme.primaryContainer else
                                //if (selectedCategory == category) Color.Black else
                                //if (selectedCategory == category) Color.Black else
                                modifier = Modifier.padding(4.dp),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = MaterialTheme.colorScheme.outline, // Set the background color for selected and unselected states
                                    contentColor = Color.White, // Set the text color for selected and unselected states
                                )
                            ) {
                                Text(
                                    text = category.uppercase(),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }


                if (isSearch) {
                    when (searchSate) {
                        is SearchState.Loading -> {
                            title = "Loading, Please Wait..."
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        is SearchState.Success -> {

                            title = "News KMP"
                            val response = (searchSate as SearchState.Success).searchNews
                            searchData = response
                            //TopNews(newsData!!)
                            SearchList(searchData!!)
                            FlowRow {
                                Text("$searchData")
                            }
                        }

                        is SearchState.Error -> {
                            val error = (searchSate as SearchState.Error).error
                            Row {
                                Text(error)
                                IconButton(onClick = {
                                    isHomeNews = !isHomeNews
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                } else {
                    when (newsState) {
                        is NewsState.Loading -> {
                            title = "Loading, Please Wait..."
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        is NewsState.Success -> {

                            title = "News KMP"
                            val response = (newsState as NewsState.Success).news
                            newsData = response
                            if (isAndroid()) {
                                NewsList(newsData!!)
                                FlowRow {
                                    Text("$newsData")
                                }
                            } else {
                                TopNews(newsData!!)
                            }
                        }

                        is NewsState.Error -> {
                            val error = (newsState as NewsState.Error).error
                            Row {
                                Text(error)
                                IconButton(onClick = {
                                    isHomeNews = !isHomeNews
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
