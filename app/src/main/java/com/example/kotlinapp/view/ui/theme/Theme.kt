package com.example.kotlinapp.view.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = YellowDusty,
    onPrimary = Purple40,
    primaryContainer = YellowLight,
    onPrimaryContainer = Purple40,
    secondary = Gray,
    onSecondary = Purple40,
    secondaryContainer = Gray,
    onSecondaryContainer = Purple40,
    tertiary = Purple40,
    onTertiary = Purple40,
    tertiaryContainer = Purple40,
    onTertiaryContainer = Purple40,
    error = Purple40,
    errorContainer = Purple40,
    onError = Purple40,
    onErrorContainer = Purple40,
    background = YellowPastel,
    onBackground = Purple40,
    surface = Gray,
    onSurface = Gray,
    surfaceVariant = Gray,
    onSurfaceVariant = Gray,
    outline = Purple40,
    inverseOnSurface = Gray,
    inverseSurface = Gray,
    inversePrimary = Purple40,
    surfaceTint = Gray,
    outlineVariant = Purple40,
    scrim = Purple40,
)

private val LightColorScheme = lightColorScheme(
    primary = YellowDusty,
    onPrimary = Purple40,
    primaryContainer = YellowLight,
    onPrimaryContainer = Purple40,
    secondary = Gray,
    onSecondary = Purple40,
    secondaryContainer = Gray,
    onSecondaryContainer = Purple40,
    tertiary = Purple40,
    onTertiary = Purple40,
    tertiaryContainer = Purple40,
    onTertiaryContainer = Purple40,
    error = Purple40,
    errorContainer = Purple40,
    onError = Purple40,
    onErrorContainer = Purple40,
    background = YellowPastel,
    onBackground = Purple40,
    surface = Gray,
    onSurface = Gray,
    surfaceVariant = Gray,
    onSurfaceVariant = Gray,
    outline = Purple40,
    inverseOnSurface = Gray,
    inverseSurface = Gray,
    inversePrimary = Purple40,
    surfaceTint = Gray,
    outlineVariant = Purple40,
    scrim = Purple40,
)

@Composable
fun KotlinAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}

