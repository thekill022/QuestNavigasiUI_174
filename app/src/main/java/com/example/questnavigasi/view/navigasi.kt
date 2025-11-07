package com.example.questnavigasi.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Formulirku,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang->
            NavHost(
                navController = navController,
                startDestination = Navigasi.Formulirku.name,
                modifier = Modifier.padding(paddingValues = isiRuang),
            ) {
                composable(
                    route = Navigasi.Formulirku.name
                ) {
                    FormIsian(
//                        pilihanJK = jenisK.map{id -> konteks.resouces.getString(id)}
                        OnSubmitOnClick = {
                            navController.navigate(route = Navigasi.Detail.name)
                        }
                    )
                }
                composable(route = Navigasi.Detail.name) {
                    TampilData(
                        onBackBtnClick = {
                            cencelAndBackToFormulir(navController)
                        }
                    )
                }
            }
    }
}

private fun cencelAndBackToFormulir(
    navController : NavHostController
) {
    navController.popBackStack(
        route = Navigasi.Formulirku.name,
        inclusive = false
    )
}