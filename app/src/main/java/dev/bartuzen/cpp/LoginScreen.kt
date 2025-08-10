package dev.bartuzen.cpp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 256.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var identityNumber by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Text(text = "Login", style = MaterialTheme.typography.displayMedium)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                label = { Text("Identity Number") },
                value = identityNumber,
                onValueChange = {
                    identityNumber = it
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                label = { Text("Password") },
                value = password,
                onValueChange = {
                    password = it
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                OutlinedButton(onClick = { navigator.push(ForgotPasswordScreen) }) {
                    Text("Forgot My Password")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { navigator.push(ProposalsScreen) }) {
                    Text("Login")
                }
            }
        }
    }
}
