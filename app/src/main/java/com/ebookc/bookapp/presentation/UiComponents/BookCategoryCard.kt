package com.ebookc.bookapp.presentation.UiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Import para height, aspectRatio etc.
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator // Para o loading da imagem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.ebookc.bookapp.presentation.navigation.Routes

@Composable
fun BookCategoryCard(
    imageUrl: String,
    category: String,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(8.dp) // Padding externo para o Card
            .fillMaxWidth() // Faz o card ocupar a largura disponível na grade
            .clickable {
                navHostController.navigate(Routes.BooksByCategory(category))
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            // Removido o .padding(200.dp)! Adicionado um padding interno menor.
            modifier = Modifier
                .fillMaxSize() // Para que o Column dentro do Card use o espaço
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true) // Efeito suave
                    .build(),
                contentDescription = category, // Boa prática adicionar contentDescription
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    // .weight(1f) // Removido weight, usando aspectRatio ou height fixo
                    .aspectRatio(16f / 9f) // Proporção comum para imagens, ajuste se necessário
                    // OU .height(120.dp) // Altura fixa
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator() // Mostra um indicador de loading
                        // Ou seu categoryShimmer() se preferir
                        // categoryShimmer(modifier = Modifier.fillMaxSize())
                    }
                },
                error = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Erro Imagem") // Mensagem de erro mais curta
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp)) // Corrigido para .height()

            Text(
                text = category,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis, // Caso o nome seja muito grande
                color = MaterialTheme.colorScheme.onSurface // Usar cores do tema
            )
        }
    }
}


