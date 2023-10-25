package com.example.elsol.ui.theme

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elsol.R

data class Picture(
    @DrawableRes var photo: Int,
    var comment: String
)

fun getPicture(): List<Picture> {
    return listOf(
        Picture(
            R.drawable.corona_solar,
            comment = "Corona solar"
        ),
        Picture(
            R.drawable.erupcionsolar,
            comment = "Erupción solar"
        ),
        Picture(
            R.drawable.espiculas,
            comment = "Espiculas"
        ),
        Picture(
            R.drawable.filamentos,
            comment = "Filamentos"
        ),
        Picture(
            R.drawable.magnetosfera,
            comment = "Magnetosfera"
        ),
        Picture(
            R.drawable.manchasolar,
            comment = "Mancha solar"
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemPicture() {
    Scaffold(
        bottomBar = { MyBottomAppBar() }) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding())
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    content = {
                        items(getPicture().size) { indice ->
                            var ph = getPicture()
                            Card(
                                modifier = Modifier
                                    .padding(10.dp),
                                onClick = {}
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .size(175.dp),
                                    painter = painterResource(id = ph[indice].photo),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                                MyTopAppBar(ph[indice].comment)
                            }
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(comment: String) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xC0C0C0)),
        title = {
            Text(
                comment,
                fontSize = 17.sp
            )
        },
        /*colors = TopAppBarDefaults.topAppBarColors(
            background = Color.White, // Establece el color de fondo a blanco
        ),*/
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menú")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(100.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Copiar") },
                    onClick = { /*TODO*/ },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Copia"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Eliminar") },
                    onClick = { /*TODO*/ },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Eliminar"
                        )
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar() {
    var showMenu by remember { mutableStateOf(false) }
    var countFav by remember{ mutableStateOf(0) }

    BottomAppBar(
        containerColor = Purple40,
        /*colors = TopAppBarDefaults.topAppBarColors(
            background = Color.White, // Establece el color de fondo a blanco
        ),*/
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
            IconButton(onClick = {
                //Esto lo he hecho opcional! :)
                if(countFav != 6){
                    countFav++
                }}) {
                BadgedBox(
                    badge = {Text(text = "$countFav")} ) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false },
                        Modifier.width(100.dp)
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Copiar") },
                            onClick = { /*TODO*/ },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Copia"
                                )
                            }
                        )

                        DropdownMenuItem(
                            text = { Text(text = "Eliminar") },
                            onClick = { /*TODO*/ },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "Eliminar"
                                )
                            }
                        )
                    }
                }

                Row {
                    FloatingActionButton(onClick = { /*TODO*/ },
                        containerColor = Purple80) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = Color.White)
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer() {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painterResource(id = R.drawable.planetasa),
            contentDescription = "Sol",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )

        Card(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "Build")
                Text(text = "Build")
            }
        }

        Card(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)){ //colors = CardDefaults.cardColors(Color.Transparent))
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "Info")
                Text(text = "Info")
            }
        }

        Card(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
                Text(text = "Email")
            }
        }
    }
}
