package com.ebookc.bookapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ebookc.bookapp.presentation.Effects.AnimatedShimmer
import com.ebookc.bookapp.presentation.UiComponents.Bookcart
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksByCategoryScreen(
    category: String,
    navHostController: NavHostController,
    viewModel: ViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.BringAllBooksByCategory(category)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = category)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navHostController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val res = viewModel.state.value
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when {
                res.isLoading -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        LazyColumn {
                            items(10) {
                                AnimatedShimmer()
                            }
                        }

                    }
                }

                res.error.isNotEmpty() -> {
                    Text(text = res.error)
                }

                res.items.isNotEmpty() -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(res.items) { item ->
                                Bookcart(
                                    imageUrl = item.image,
                                    author = item.bookAuthor,
                                    title = item.bookname,
                                    description = item.bookDescription,
                                    bookUrl = item.bookUrl,
                                    navHostController = navHostController
                                )
                            }
                        }
                    }
                }

                else -> {
                    Text(text = "No books AVAILABLE")
                }
            }
        }
    }
}
