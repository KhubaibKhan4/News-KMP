package org.newskmp.app.ui.screen.largescreen.search.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Subject
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.newskmp.app.data.model.search.Doc
import org.newskmp.app.ui.components.formatDateTime

class SearchDetailLarge(
    val doc: Doc
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Image with Fade-in Animation
            Card(
                modifier = Modifier
                    .width(420.dp)
                    .fillMaxHeight(),
                elevation = CardDefaults.cardElevation(8.dp),
                content = {
                    Box {
                        val imageUrl =if (doc.multimedia.isNullOrEmpty())"https://static01.nyt.com/vi-assets/images/share/1200x675_nameplate.png" else "https://static01.nyt.com/${doc?.multimedia?.get(0)?.url ?: "vi-assets/images/share/1200x675_nameplate.png"}"
                        println("Image URL: $imageUrl")
                        val painterResource = asyncPainterResource(data = imageUrl)
                        KamelImage(
                            resource = painterResource,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        IconButton(
                            onClick = {
                                navigator!!.pop()
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color.DarkGray)
                                .align(alignment = Alignment.TopStart)
                                .pointerHoverIcon(icon = PointerIcon.Hand)

                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            )

            // Vertical Divider
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                thickness = 3.dp,
                color = Color.LightGray
            )


            // Scrollable Details
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),
                elevation = CardDefaults.cardElevation(8.dp),
                content = {
                    DetailContent(doc)
                }
            )
        }
    }

}

@Composable
fun DetailContent(doc: Doc) {
    val navigator = LocalNavigator.current
    val uriHandler = LocalUriHandler.current


    Row(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Right side: Text content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Box for Title, Date, and Published By
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Date
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Timer,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${formatDateTime(doc?.pubDate!!)}",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        }

                        // Title
                        Text(
                            text = "${doc.abstract}",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )

                        // Published by
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Published by ${doc.byline}",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        }
                    }
                }
            }

            // Section
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Section: ${doc.sectionName}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // Sub- Section
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Subject,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sub-Section: ${doc.subsectionName}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // Category
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.LocalOffer,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Category: ${doc.keywords ?: "N/A"}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // Type
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Type: ${doc.typeOfMaterial}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // Tags
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Label,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Tags: ${doc.keywords!!.joinToString()}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // geoFacet
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Label,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Tags: ${doc.newsDesk}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // CopyRight
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Link,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "CopyRight : ${doc.multimedia?.get(0)?.credit}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                )
            }

            // Card for Content Text (News Article)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Content Text (News Article)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Detail: ${doc.abstract}",
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Justify
                            )
                        )
                    }
                }
            }

            // URL
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().clickable {
                    uriHandler.openUri(doc.webUrl!!)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.OpenInNew,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Official URL : ${doc.webUrl}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}