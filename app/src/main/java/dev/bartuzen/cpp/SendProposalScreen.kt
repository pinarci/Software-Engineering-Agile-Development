package dev.bartuzen.cpp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch

object SendProposalScreen: Screen {
    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Text(text = "Write Your Proposal", style = MaterialTheme.typography.displayMedium)
                Spacer(modifier = Modifier.height(32.dp))

                var title by remember { mutableStateOf("") }
                var comment by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    label = {Text (text = "Proposal Title")},
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = comment,
                    onValueChange = { comment = it },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 4,
                    label = {Text (text = "Proposal Details")},
                )
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Thanks for your participation! Your proposal will be available after evaluation.")
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 4.dp),
                    enabled = title.isNotBlank() && comment.isNotBlank()
                ) {
                    Text("Submit")
                }
            }
        }
    }
}
