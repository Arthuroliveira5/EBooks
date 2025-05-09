package com.ebookc.bookapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Category
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ebookc.bookapp.presentation.AllBookScreen.AllBookScreen
import com.ebookc.bookapp.presentation.CategoryScreen.CategoryScreen
import kotlinx.coroutines.launch

@Composable
fun TabScreen(navHostController: NavHostController) {
    val tabs = listOf(
        TabItem("Category", Icons.Default.Category),
        TabItem("Books", Icons.Default.Book)
    )

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text( tab.title)

                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState
        ){ page ->
            when(page){
                0 -> CategoryScreen(navHostController=navHostController)
                1 -> AllBookScreen(navHostController=navHostController)


            }


        }
    }
}

data class TabItem(val title: String, val icon: ImageVector)
