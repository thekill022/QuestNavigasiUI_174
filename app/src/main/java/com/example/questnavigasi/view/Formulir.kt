package com.example.questnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK : List<String> = listOf("Laki-Laki", "Perempuan"),
    OnSubmitOnClick : () -> Unit
) {

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var genderTerpilih by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {TopAppBar(
            title = { Text(stringResource(id = R.string.home), color = Color.White)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                colorResource(id = R.color.teal_200)
            )
        )}
    ) {
        isiRuang ->
            Column(
                modifier = Modifier.padding(isiRuang),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = nama,
                    singleLine = true,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(250.dp),
                    label = { Text(text = "Nama Lengkap")},
                    onValueChange = {nama = it}
                )
                Divider(
                    modifier = Modifier
                        .padding(20.dp)
                        .width(250.dp),
                    thickness = DividerDefaults.Thickness, color = Color.Red
                )
                Row {
                    jenisK.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (genderTerpilih == item),
                                onClick = { genderTerpilih = item }
                            )
                            Text(text = item)
                        }
                    }
                }
                Divider(
                    modifier = Modifier
                        .padding(20.dp)
                        .width(250.dp), 
                    thickness = 1.dp, 
                    color = Color.Red,
                )
                OutlinedTextField(
                    value = alamat,
                    singleLine = true,
                    modifier = Modifier.width(250.dp),
                    label = { Text(text = "Alamat")},
                    onValueChange = {alamat = it}
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(25.dp),
                    onClick = OnSubmitOnClick) {
                    Text(text = stringResource(id = R.string.submit))
                }
            }
    }
    
}