package app.playme.com.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Yellow800,
    onPrimary = Color.Black,
    secondary = Yellow800,
    onSecondary = Color.Black,
    error = Red300,
    onError = Color.Black
)

@Composable
fun PlaymeTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
