package com.example.navigationdemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.example.navigationdemo.R

// Список мотивационных цитат.
// Из него будем выбирать случайную при каждом входе на экран профиля.
private val motivationalQuotes = listOf(
    "Единственный способ делать великие дела — любить то, что ты делаешь.",
    "Успех — это сумма маленьких усилий, повторяемых день за днём.",
    "Не бойся медленно идти, бойся стоять на месте.",
    "Лучшее время посадить дерево было 20 лет назад. Второе лучшее — сегодня.",
    "Ты не обязан быть великим, чтобы начать, но нужно начать, чтобы стать великим.",
    "Дорогу осилит идущий.",
    "Каждый день — это новый шанс изменить свою жизнь.",
    "Мечтай больше, делай больше, становись больше.",
    "Не откладывай на завтра то, что можно сделать сегодня.",
    "Твоя скорость не важна, важно — не останавливаться."
)

@Composable
fun Profile(name: String, onClearBackStack: () -> Unit) {
    // remember { ... } сохраняет цитату до тех пор, пока экран открыт.
    // При следующем заходе в профиль remember создастся заново — цитата будет новой.
    val quote = remember { motivationalQuotes.random() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Фото профиля — круг с иконкой-силуэтом
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile_avatar),
                    contentDescription = "Фото профиля",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.size(20.dp))

            // Имя пользователя
            Text(
                text = if (name.isBlank()) "Гость" else name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(8.dp))

            // Подпись под именем
            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.size(30.dp))

            // Карточка с мотивационной цитатой
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.secondaryContainer,
                tonalElevation = 4.dp
            ) {
                Text(
                    text = "\"$quote\"",
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            Spacer(modifier = Modifier.size(40.dp))

            // Кнопка возврата на главный экран
            Button(onClick = {
                onClearBackStack()
            }) {
                Text(text = "Go Home")
            }
        }
    }
}