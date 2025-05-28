package com.popcornissues.scribbledash.introscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.introscreens.components.CloseButton
import com.popcornissues.scribbledash.introscreens.components.RoundButton
import com.popcornissues.scribbledash.introscreens.ui.components.HeaderAndSubtitleText
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun SelectDifficultyScreen(
    closeClick: () -> Unit,
    difficultyClick: (String) -> Unit,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = 16.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding()),
            horizontalArrangement = Arrangement.End
            ) {
            CloseButton(onClick = closeClick)
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row {
            HeaderAndSubtitleText(
                header = stringResource(R.string.start_drawing),
                subtitle = stringResource(R.string.choose_difficulty)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                RoundButton(
                    iconId = R.drawable.scribbledash_beginner,
                    label = stringResource(R.string.beginner),
                    onClick = { difficultyClick("Beginner") },
                )
            }
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                RoundButton(
                    iconId = R.drawable.scribbledash_challenging,
                    label = stringResource(R.string.challenging),
                    onClick = { difficultyClick("Challenging") }
                )
            }
            Column(modifier = Modifier.padding(top = 16.dp)) {
                RoundButton(
                    iconId = R.drawable.scribbledash_master,
                    label = stringResource(R.string.master),
                    onClick = { difficultyClick("Master") }
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectDifficultyScreenPreview() {
    val paddingValues = PaddingValues(
        horizontal = 0.dp,
        vertical = 20.dp
    )
    ScribbledashTheme {
        SelectDifficultyScreen(
            difficultyClick = {},
            closeClick = {},
            paddingValues = paddingValues
        )
    }
}