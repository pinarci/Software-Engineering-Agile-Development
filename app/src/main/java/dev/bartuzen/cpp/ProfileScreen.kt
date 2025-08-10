package dev.bartuzen.cpp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

object ProfileScreen: Screen {
    @Composable
    override fun Content() {
        var isEditing by remember { mutableStateOf(false) }
        var alias by remember { mutableStateOf("AnonymousUser123") }
        var email by remember { mutableStateOf("user@example.com") }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        isEditing = !isEditing
                    },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = if (isEditing) Icons.Filled.Check else Icons.Filled.Edit,
                        contentDescription = if (isEditing) "Confirm" else "Edit"
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Avatar()
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = alias,
                    onValueChange = { alias = it },
                    label = { Text("Alias") },
                    enabled = isEditing,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    enabled = isEditing,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    @Composable
    fun Avatar() {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray, shape = CircleShape)
                .border(width = 4.dp, color = Color.Black, shape = CircleShape), // Add border modifier
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "Avatar",
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .background(MaterialTheme.colorScheme.secondary, CircleShape)
            )
        }

    }
}
