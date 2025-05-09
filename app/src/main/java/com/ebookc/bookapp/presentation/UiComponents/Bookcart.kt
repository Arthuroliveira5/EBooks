package com.ebookc.bookapp.presentation.UiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.ebookc.bookapp.presentation.Effects.imageani
import com.ebookc.bookapp.presentation.navigation.Routes

@Composable
fun Bookcart (

    imageUrl:String,
    title:String,
    author:String= null.toString(),
    description:String,
    navHostController: NavHostController,
    bookUrl:String,

) {

    Card(modifier = Modifier.fillMaxWidth()
        .padding(10.dp)
        .clickable {

            navHostController.navigate(Routes.ShowPdfScreen(url = bookUrl))




        }) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .padding(10.dp)


        ) {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
                    .clip(RoundedCornerShape(0.dp)),

                loading = {

                    imageani()

                },
                error = {

                    Text(text = "error in loading image")


                }

                )

            Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,

                        fontSize = 14.sp,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "-${author}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )



                }




        }


    }

}
