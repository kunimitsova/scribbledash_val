package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.LightOnBackground
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLow
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLowest


@Composable
fun RoundedSquareBoxButton(
    contentDescription: String,
    interactionSource: MutableInteractionSource,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit,
    iconId: Int? = null,
    text: String? = null
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocussed by interactionSource.collectIsFocusedAsState()

    Box (
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(
                color = if (!enabled) {
                    LightSurfaceLow.copy(alpha = 0.4f)
                } else if (!isPressed && !isFocussed) {
                    LightSurfaceLow
                } else {
                    LightSurfaceLowest
                })
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(),
                enabled = enabled,
                onClick = onClick
            )
            .padding(16.dp)
    )
    {
        if (iconId != null) {
            Icon(imageVector = ImageVector.vectorResource(iconId),
                contentDescription = contentDescription,
                tint = if (enabled) LightOnBackground else LightOnBackground.copy(alpha = 0.4f)
            )
        }
        if (text != null) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun RoundedSquareButtonPreview() {
    val interactionSource = remember { MutableInteractionSource() }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = LightBackground),
        verticalArrangement = Arrangement.Center
    ) {
        RoundedSquareBoxButton(
            contentDescription = "Undo",
            interactionSource = interactionSource,
            enabled = true,
            onClick = {  },
            iconId = R.drawable.reply,
        )
    }
}
