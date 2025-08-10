package dev.bartuzen.cpp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlin.math.min


object ProposalScreen : Screen {
    @Composable
    override fun Content() {
        var replyLocation by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Example proposal 1", style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text("2758")
                        Icon(imageVector = Icons.Default.Comment, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("2564", color = Color(0xFFFF4500))
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = Color(0xFFFF4500)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("7483")
                        Icon(imageVector = Icons.Default.ArrowDropUp, contentDescription = null)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Comments", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Anonymous User", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "1 hour ago", style = MaterialTheme.typography.bodyMedium)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Example comment")
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                replyLocation = if (replyLocation == 1) 0 else 1
                            }
                    ) {
                        Row(
                            Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(imageVector = Icons.Default.Comment, contentDescription = null)
                            Text(text = "Reply", modifier = Modifier.padding(start = 4.dp))
                        }
                    }

                    AnimatedVisibility(visible = replyLocation == 1) {
                        Column {
                            Spacer(modifier = Modifier.height(8.dp))
                            var comment by remember { mutableStateOf("") }
                            OutlinedTextField(
                                value = comment,
                                onValueChange = { comment = it },
                                modifier = Modifier.fillMaxWidth(),
                                minLines = 4,
                                placeholder = { Text("Write your reply...") },
                            )
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(top = 4.dp),
                                enabled = comment.isNotBlank()
                            ) {
                                Text("Submit")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.let { color ->
                                val a = color.alpha
                                val r = (color.red * 0.9).toFloat()
                                val g = (color.green * 0.9).toFloat()
                                val b = (color.blue * 0.9).toFloat()
                                Color(
                                    alpha = a,
                                    red = min(r, 1f),
                                    green = min(g, 1f),
                                    blue = min(b, 1f)
                                )
                            })
                            .padding(8.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Anonymous User",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "39 minutes ago",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Example sub-comment")

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable {
                                    replyLocation = if (replyLocation == 2) 0 else 2
                                }
                        ) {
                            Row(
                                Modifier.padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(imageVector = Icons.Default.Comment, contentDescription = null)
                                Text(text = "Reply", modifier = Modifier.padding(start = 4.dp))
                            }
                        }

                        AnimatedVisibility(visible = replyLocation == 2) {
                            Column {
                                Spacer(modifier = Modifier.height(8.dp))
                                var comment by remember { mutableStateOf("") }
                                OutlinedTextField(
                                    value = comment,
                                    onValueChange = { comment = it },
                                    modifier = Modifier.fillMaxWidth(),
                                    minLines = 4,
                                    placeholder = { Text("Write your reply...") },
                                )
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .align(Alignment.End)
                                        .padding(top = 4.dp),
                                    enabled = comment.isNotBlank()
                                ) {
                                    Text("Submit")
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Write a Comment", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            var comment by remember { mutableStateOf("") }
            OutlinedTextField(
                value = comment,
                onValueChange = { comment = it },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4,
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 4.dp),
                enabled = comment.isNotBlank()
            ) {
                Text("Submit")
            }
        }
    }
}
