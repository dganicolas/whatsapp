package com.example.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.whatsapp.ui.theme.WhatsappTheme
import com.example.whatsapp.ui.theme.headColor
import com.example.whatsapp.ui.theme.mainColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    primaryScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun primaryScreen(modifier: Modifier) {
    var ventanaModal by remember { mutableStateOf(false) }
    val indices = LocalContext.current.resources.getStringArray(R.array.contactos).toList()
    if (ventanaModal) {
        AlertDialog(
            onDismissRequest = { ventanaModal = false },
            title = {
                Text(text = "No ve ta to guapo esto", fontSize = 20.sp)
            },
            text = {
                Text("esto hasta aqui la desmostracion")
            },
            confirmButton = {
                Button(
                    onClick = { ventanaModal = false }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = { ventanaModal = false }
                ) {
                    Text("Cancelar")
                }
            },
            properties = DialogProperties(
                dismissOnClickOutside = false  // Evita que se cierre al hacer clic fuera
            )
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .background(headColor),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Whatsapp", fontSize = 40.sp)
            Spacer(modifier = Modifier.weight(2f))
            Image(
                painter = painterResource(R.drawable.pngwing),
                contentDescription = "xd",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(45.dp)
            )

            Icon(
                imageVector = Icons.Filled.Search, // Lupa de Material Icons
                contentDescription = "Search icon", // Descripción para accesibilidad
                tint = Color.White, // Color del icono
                modifier = Modifier
                    .size(50.dp)
            )
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "More options icon",
                tint = Color.White,
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.Black)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Button(
                onClick = {ventanaModal = true}
            ) {
                Text("Todos", fontSize = 12.sp)
            }
            Button(
                onClick = {ventanaModal = true}
            ) {
                Text("No leídos", fontSize = 12.sp)
            }
            Button(
                onClick = {ventanaModal = true}
            ) {
                Text("Favoritos", fontSize = 12.sp)
            }
            Button(
                onClick = {ventanaModal = true}
            ) {
                Text("Grupos", fontSize = 12.sp)
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(mainColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(indices.size) { contacto ->
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color.Gray)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.LightGray),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "More options icon",
                        tint = Color.Black,
                        modifier = Modifier.size(50.dp)
                    )
                    Column {

                        Text(text = indices[contacto], fontSize = 20.sp)
                        Row {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = "More options icon",
                                tint = Color.Black,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(text = "Texto de ejemplo")
                        }
                    }
                    Spacer(modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .background(Color.Gray))
                    Column {
                        Text("11:22")
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "More options icon",
                            tint = Color.Black,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .weight(0.1f)
                .background(Color.Gray)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "More options icon",
                    tint = Color.Black,
                    modifier = Modifier.size(45.dp)

                )
                Text(text = "Chats", fontSize = 15.sp)
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "More options icon",
                    tint = Color.Black,
                    modifier = Modifier.size(45.dp)

                )
                Text(text = "Novedades", fontSize = 15.sp)
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "More options icon",
                    tint = Color.Black,
                    modifier = Modifier.size(45.dp)

                )
                Text(text = "Comunidades", fontSize = 15.sp)
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "More options icon",
                    tint = Color.Black,
                    modifier = Modifier.size(45.dp)

                )
                Text(text = "Llamadas", fontSize = 15.sp)
            }
        }
    }
}