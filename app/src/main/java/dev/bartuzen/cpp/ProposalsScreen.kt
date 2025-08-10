package dev.bartuzen.cpp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object ProposalsScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.push(ProfileScreen)
                    },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }

            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Ongoing Proposals", style = MaterialTheme.typography.displayMedium)
                    OutlinedButton(onClick = { navigator.push(SendProposalScreen) }) {
                        Text(text = "Send Proposal")
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Card(
                    onClick = {
                        navigator.push(ProposalScreen)
                    }
                ) {
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
                            Text("2758", fontWeight = FontWeight.SemiBold)
                            Icon(imageVector = Icons.Default.Comment, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("2564", color = Color(0xFF0C1E55), fontWeight = FontWeight.SemiBold)
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color(0xFF0C1E55)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("7483", fontWeight = FontWeight.SemiBold)
                            Icon(imageVector = Icons.Default.ArrowDropUp, contentDescription = null)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    onClick = {
                        navigator.push(ProposalScreen)
                    }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Example proposal 2", style = MaterialTheme.typography.headlineLarge)
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
                            Text("326", fontWeight = FontWeight.SemiBold)
                            Icon(imageVector = Icons.Default.Comment, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("217", fontWeight = FontWeight.SemiBold)
                            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("558", color = Color(0xFFFF4500), fontWeight = FontWeight.SemiBold)
                            Icon(
                                imageVector = Icons.Default.ArrowDropUp,
                                contentDescription = null,
                                tint = Color(0xFFFF4500)
                            )
                        }
                    }
                }
            }
        }
    }
}
