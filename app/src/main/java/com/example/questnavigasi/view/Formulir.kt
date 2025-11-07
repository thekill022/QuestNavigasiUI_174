package com.example.questnavigasi.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.questnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK : List<String> = listOf("Laki-Laki", "Perempuan"),
    OnSubmitOnClick : () -> Unit
) {
    
    Scaffold(
        modifier = Modifier,
        topBar = {TopAppBar(
            title = { Text(stringResource(id = R.string.home), color = Color.White)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                colorResource(id = R.color.teal_200)
            )
        )}
    ) {
        
    }
    
}