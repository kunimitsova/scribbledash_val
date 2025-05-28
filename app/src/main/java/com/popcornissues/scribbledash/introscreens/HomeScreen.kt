package com.popcornissues.scribbledash.introscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.components.AppTitleText
import com.popcornissues.scribbledash.ui.components.GameCard
import com.popcornissues.scribbledash.ui.components.HeaderAndSubtitleText
import com.popcornissues.scribbledash.ui.components.BottomBar
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.LightBgGradient2
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun HomeScreen(
    onOneRoundWonderClick: () -> Unit,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(
                LightBackground, LightBgGradient2)))
    ) {
        Row(modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .padding(horizontal = 16.dp)
        ) {
            AppTitleText(
                title = stringResource(R.string.app_name)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            HeaderAndSubtitleText(
                header = stringResource(R.string.start_drawing),
                subtitle = stringResource(R.string.select_game_mode)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            GameCard(
                gameName = stringResource(R.string.one_round_wonder),
                gameIconId = R.drawable.one_round_wonder,
                onClick = onOneRoundWonderClick
            )
        }
        Row(
            modifier = Modifier.fillMaxSize().weight(1f),
            verticalAlignment = Alignment.Bottom
        ) {
            BottomBar(paddingValues = paddingValues)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val paddingValues = PaddingValues(
        horizontal = 0.dp,
        vertical = 20.dp
    )
    ScribbledashTheme {
        HomeScreen(
            onOneRoundWonderClick = {},
            paddingValues = paddingValues
        )
    }
}