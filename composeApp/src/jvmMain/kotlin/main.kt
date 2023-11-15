import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.AutoMode
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.ManageHistory
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.OfflinePin
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material.icons.filled.Upcoming
import androidx.compose.material.icons.filled.Usb
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.newskmp.app.App
import java.awt.Dimension

fun main() = application {
    Window(
        title = "News KMP App",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)

        //Menu Icons
        val refreshIcon = rememberVectorPainter(Icons.Default.Refresh)
        val exitIcon = rememberVectorPainter(Icons.Default.ExitToApp)
        val searchIcon = rememberVectorPainter(Icons.Default.Search)
        val homeIcon = rememberVectorPainter(Icons.Default.Home)
        val usIcon = rememberVectorPainter(Icons.Default.Usb)
        val technologyIcon = rememberVectorPainter(Icons.Default.MilitaryTech)
        val politicsIcon = rememberVectorPainter(Icons.Default.Policy)
        val worldIcon = rememberVectorPainter(Icons.Default.Work)
        val sportsIcon = rememberVectorPainter(Icons.Default.Sports)
        val businessIcon = rememberVectorPainter(Icons.Default.Business)
        val scienceIcon = rememberVectorPainter(Icons.Default.Science)
        val artsIcon = rememberVectorPainter(Icons.Default.AreaChart)
        val booksIcon = rememberVectorPainter(Icons.Default.Book)
        val autoIcon = rememberVectorPainter(Icons.Default.AutoMode)
        val fashionIcon = rememberVectorPainter(Icons.Default.Fastfood)
        val foodIcon = rememberVectorPainter(Icons.Default.FoodBank)
        val healthIcon = rememberVectorPainter(Icons.Default.HealthAndSafety)
        val insiderIcon = rememberVectorPainter(Icons.Default.Insights)
        val magazineIcon = rememberVectorPainter(Icons.Default.ManageHistory)
        val moviesIcon = rememberVectorPainter(Icons.Default.LocalMovies)
        val travelIcon = rememberVectorPainter(Icons.Default.TravelExplore)
        val upshotIcon = rememberVectorPainter(Icons.Default.Upcoming)
        val opinionIcon = rememberVectorPainter(Icons.Default.OfflinePin)

        MenuBar {
            Menu(text = "File", mnemonic = 'F', enabled = true) {
                Item(
                    text = "Refresh",
                    mnemonic = 'R',
                    icon = refreshIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.R, ctrl = true)
                ) {

                }

                Item(
                    text = "Search",
                    mnemonic = 'S',
                    icon = searchIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.S, ctrl = true)
                ) {

                }

                Item(
                    text = "Exit",
                    mnemonic = 'E',
                    icon = exitIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.Escape, ctrl = true)
                ) {

                }
            }

            Menu(text = "Categories", mnemonic = 'C', enabled = true) {
                Item(
                    text = "Home",
                    mnemonic = 'H',
                    icon = homeIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.H, ctrl = true)
                ) {

                }

                Item(
                    text = "US",
                    mnemonic = 'U',
                    icon = usIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.U, ctrl = true)
                ) {

                }

                Item(
                    text = "Technology",
                    mnemonic = 'T',
                    icon = technologyIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.T, ctrl = true)
                ) {

                }

                Item(
                    text = "Politics",
                    mnemonic = 'P',
                    icon = politicsIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.P, ctrl = true)
                ) {

                }

                Item(
                    text = "World",
                    mnemonic = 'W',
                    icon = worldIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.W, ctrl = true)
                ) {

                }

                Item(
                    text = "Sports",
                    mnemonic = 'P',
                    icon = sportsIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.P, ctrl = true)
                ) {

                }

                Item(
                    text = "Business",
                    mnemonic = 'B',
                    icon = businessIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.B, ctrl = true)
                ) {

                }

                Item(
                    text = "Science",
                    mnemonic = 'S',
                    icon = scienceIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.E, ctrl = true)
                ) {

                }
                Item(
                    text = "Arts",
                    mnemonic = 'A',
                    icon = artsIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.A, ctrl = true)
                ) {

                }

                Item(
                    text = "AutoMobiles",
                    mnemonic = 'A',
                    icon = autoIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.A, ctrl = true)
                ) {

                }

                Item(
                    text = "Books Reviews",
                    mnemonic = 'B',
                    icon = booksIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.B, ctrl = true)
                ) {

                }

                Item(
                    text = "Fashion",
                    mnemonic = 'F',
                    icon = fashionIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.F, ctrl = true)
                ) {

                }

                Item(
                    text = "Food",
                    mnemonic = 'F',
                    icon = foodIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.F, ctrl = true)
                ) {

                }
                Item(
                    text = "Health",
                    mnemonic = 'H',
                    icon = healthIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.H, ctrl = true)
                ) {

                }

                Item(
                    text = "Insider",
                    mnemonic = 'I',
                    icon = insiderIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.I, ctrl = true)
                ) {

                }
                Item(
                    text = "Magazine",
                    mnemonic = 'M',
                    icon = magazineIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.M, ctrl = true)
                ) {

                }
                Item(
                    text = "Movies",
                    mnemonic = 'M',
                    icon = moviesIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.M, ctrl = true)
                ) {

                }

                Item(
                    text = "Travel",
                    mnemonic = 'T',
                    icon = travelIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.T, ctrl = true)
                ) {

                }

                Item(
                    text = "UpShot",
                    mnemonic = 'U',
                    icon = upshotIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.U, ctrl = true)
                ) {

                }
                Item(
                    text = "Opinion",
                    mnemonic = 'O',
                    icon = opinionIcon,
                    enabled = true,
                    shortcut = KeyShortcut(key = Key.O, ctrl = true)
                ) {

                }
            }
        }
        App()
    }
}