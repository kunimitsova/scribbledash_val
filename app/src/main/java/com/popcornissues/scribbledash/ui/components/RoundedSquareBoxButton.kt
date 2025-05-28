package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.LightOnBackground
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLow
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLowest
import kotlin.math.abs


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

@Composable
fun RoundedSquareButton(
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
    val density = LocalDensity.current
    var diffInt by remember { mutableIntStateOf(0)}

  Button(
        onClick = {  },
        enabled = enabled,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonColors(
            containerColor = if (!isPressed && !isFocussed) LightSurfaceLow else LightSurfaceLowest,
            contentColor = LightOnBackground,
            disabledContainerColor = LightSurfaceLow.copy(alpha = 0.4f),
            disabledContentColor = LightOnBackground.copy(alpha = 0.4f),
        ),
        interactionSource = interactionSource,
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier.onGloballyPositioned {
            diffInt = abs(it.size.height - it.size.width)
        }

    ) {
        val diffDp = with (density) {
            diffInt.toDp() // this isn't working, idk how to make it a square without starting over
        }
        if (iconId != null) {
            Icon(imageVector = ImageVector.vectorResource(iconId),
                contentDescription = contentDescription,
                modifier = Modifier.padding(vertical  = 4.dp)
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
        RoundedSquareButton(
            contentDescription = "Undo",
            interactionSource = interactionSource,
            enabled = true,
            onClick = {  },
            iconId = R.drawable.reply,
        )
        Spacer(Modifier.height(12.dp))
        RoundedSquareBoxButton(
            contentDescription = "Undo",
            interactionSource = interactionSource,
            enabled = true,
            onClick = {  },
            iconId = R.drawable.reply,
        )
    }
}
