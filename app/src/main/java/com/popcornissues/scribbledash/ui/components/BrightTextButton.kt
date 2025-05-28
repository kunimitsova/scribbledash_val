package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightSurfaceHigh
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLowest
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme
import com.popcornissues.scribbledash.ui.theme.Success

@Composable
fun BrightTextButton(
    label: String,
    enabled: Boolean,
    enabledColor: Color,
    contentColor: Color,
    onClick: ()-> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
        ,
        enabled = enabled,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = enabledColor,
            contentColor = contentColor,
            disabledContainerColor = LightSurfaceLowest,
            disabledContentColor = contentColor
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 3.dp,
            pressedElevation = 1.dp,
            focusedElevation = 3.dp,
            hoveredElevation = 3.dp,
            disabledElevation = 3.dp
        ),
        border = BorderStroke(
            width = 6.dp,
            color = LightSurfaceHigh
        ),
        contentPadding = PaddingValues(16.dp),
    ) {
        Text(text = label.uppercase(),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview
@Composable
fun BrightTextButtonPreview() {

    ScribbledashTheme {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            BrightTextButton(
                label = stringResource( R.string.clear_canvas),
                enabled = true,
                enabledColor = Success,
                contentColor = LightSurfaceHigh,
                onClick = {  },
            )
        }
    }
}