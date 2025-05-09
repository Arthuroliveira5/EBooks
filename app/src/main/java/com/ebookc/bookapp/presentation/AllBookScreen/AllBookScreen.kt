package com.ebookc.bookapp.presentation.AllBookScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ebookc.bookapp.presentation.Effects.AnimatedShimmer
import com.ebookc.bookapp.presentation.UiComponents.Bookcart
import com.ebookc.bookapp.presentation.ViewModel

@Composable
fun AllBookScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: ViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.BringAllBooks()
    }

    val res = viewModel.state.value

    when {
        res.isLoading -> {
            Column(modifier = modifier.fillMaxSize()) {
                LazyColumn {
                    items(10) {
                        AnimatedShimmer()
                    }
                }
            }
        }

        res.error.isNotEmpty() -> {
            Text(text = res.error, modifier = modifier)
        }

        res.items.isNotEmpty() -> {
            Column(modifier = modifier.fillMaxSize()) {
                LazyColumn(modifier = modifier.fillMaxSize()) {
                    items(res.items) {
                        Bookcart(
                            imageUrl = it.image,
                            author = it.bookAuthor,
                            title = it.bookname,
                            description = it.bookDescription,
                            bookUrl = it.bookUrl,
                            navHostController = navHostController
                        )


                    }
                }
            }
        }
        else -> Text(text = "No books AVAILABLE", modifier = modifier)
    }





}
