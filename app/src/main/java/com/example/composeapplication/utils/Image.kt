package com.example.composeapplication.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.Coil
import coil.size.Scale
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//
//suspend fun calculateDominantColor(context: Context, url: String): Color? {
//    // Otherwise we calculate the swatches in the image, and return the first valid color
//    return calculateSwatchesInImage(context, url).maxByOrNull { swatch -> swatch.population }
//        // If we found a valid swatch, wrap it in a [DominantColors]
//        ?.let { swatch ->
//            Color(swatch.rgb)
//        }
//}

suspend fun calculateDominantColor(
        context: Context,
        imageUrl: String,
        onFinish: (Color) -> Unit
    ) {
    val r = ImageRequest.Builder(context)
        .data(imageUrl)
        // We scale the image to cover 128px x 128px (i.e. min dimension == 128px)
        .size(128).scale(Scale.FILL)
        // Disable hardware bitmaps, since Palette uses Bitmap.getPixels()
        .allowHardware(false)
        .build()

    val bitmap = when (val result = Coil.execute(r)) {
        is SuccessResult -> (result.drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        else -> null
    }

    Palette.from(bitmap!!).generate { palette ->
        palette?.dominantSwatch?.rgb?.let { colorValue ->
            onFinish(Color(colorValue))
        }
    }

//        return bitmap?.let {
//            withContext(Dispatchers.Default) {
//                val palette = Palette.Builder(bitmap)
//                    // Disable any bitmap resizing in Palette. We've already loaded an appropriately
//                    // sized bitmap through Coil
//                    .resizeBitmapArea(0)
//                    // Clear any built-in filters. We want the unfiltered dominant color
//                    .clearFilters()
//                    // We reduce the maximum color count down to 8
//                    .maximumColorCount(8)
//                    .generate()
//
//                palette.swatches
//            }
//        } ?: emptyList()
}