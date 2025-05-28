package com.popcornissues.scribbledash.introscreens.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.LightOnBackground
import com.popcornissues.scribbledash.ui.theme.LightOnSurface
import com.popcornissues.scribbledash.ui.theme.LightSurfaceHigh
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLow
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme
import com.popcornissues.scribbledash.ui.theme.Success

@Composable
fun GameCard(
    gameName: String,
    gameIconId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonColors(
            containerColor = LightSurfaceHigh,
            contentColor = LightOnBackground,
            disabledContainerColor = LightSurfaceLow,
            disabledContentColor = LightOnSurface,
        ),
        border = BorderStroke(width = 8.dp, color = Success),
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(
            horizontal = 0.dp,
            vertical = 0.dp
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 1.dp,
            focusedElevation = 8.dp,
            hoveredElevation = 8.dp,
            disabledElevation = 8.dp
        )
    ) {
        Text(
            text = gameName,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 22.dp)
                .weight(1f)
        )
        Image(
            painter = painterResource(gameIconId),
            contentDescription = "",
            alignment = Alignment.BottomEnd
        )
    }
}

@Preview
@Composable
fun GameCardPreview() {
    ScribbledashTheme {
        Column(
            modifier = Modifier.Companion.fillMaxSize()
                .background(color = LightBackground)
                .padding(16.dp)
        ) {
            GameCard(
                gameName = "One Round Wonder",
                gameIconId = R.drawable.one_round_wonder,
                onClick = {}
            )
        }
    }
}