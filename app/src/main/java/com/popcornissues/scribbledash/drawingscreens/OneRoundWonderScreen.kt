package com.popcornissues.scribbledash.drawingscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.popcornissues.scribbledash.ui.components.CloseButton
import com.popcornissues.scribbledash.ui.components.DrawingCanvas
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.components.BrightTextButton
import com.popcornissues.scribbledash.ui.components.Gridlines
import com.popcornissues.scribbledash.ui.components.RoundedSquareBoxButton
import com.popcornissues.scribbledash.ui.theme.LightBackground
import com.popcornissues.scribbledash.ui.theme.LightOnSurfaceVariant
import com.popcornissues.scribbledash.ui.theme.LightSurfaceHigh
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme
import com.popcornissues.scribbledash.ui.theme.Success
import org.koin.androidx.compose.koinViewModel

@Composable
fun OneRoundWonderRoot(
    closeClick: () -> Unit,
    paddingValues: PaddingValues,
    viewModel: DrawingViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    OneRoundWonderScreen(
        state = state.value,
        closeClick = closeClick,
        onAction = {action ->
            viewModel.onAction(action)
        },
        paddingValues = paddingValues
    )
}

@Composable
fun OneRoundWonderScreen(
    state: DrawingState,
    closeClick: () -> Unit,
    onAction: (DrawingAction)-> Unit,
    paddingValues: PaddingValues
) {

    val undoInteractionSource = remember { MutableInteractionSource() }
    val redoInteractionSource = remember { MutableInteractionSource() }
    var canvasSize by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = paddingValues.calculateTopPadding()),
            horizontalArrangement = Arrangement.End
        ) {
            CloseButton(onClick = closeClick)
        }
        Spacer(modifier = Modifier.Companion.height(50.dp))
        Row(modifier = Modifier.Companion.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.time_to_draw),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.Companion.fillMaxWidth(),
                textAlign = TextAlign.Companion.Center
            )
        }
        Spacer(modifier = Modifier.Companion.height(40.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f, matchHeightConstraintsFirst = false)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(20.dp),
                )
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = LightSurfaceHigh)
                .padding(8.dp)

        )
        {
            DrawingCanvas(
                paths = state.paths,
                currentPath = state.currentPath,
                onAction = onAction,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .aspectRatio(
                        ratio = 1f,
                        matchHeightConstraintsFirst = false
                    )
                    .onGloballyPositioned {
                        canvasSize = it.size.height
                    }
                    .clip(shape = RoundedCornerShape(20.dp))
                    .border(
                        width = 1.dp,
                        color = LightOnSurfaceVariant,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
            Gridlines(
                canvasSize = canvasSize,
                numSlices = 3,
            )
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(bottom = paddingValues.calculateBottomPadding())
            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // undo, redo, clear canvas
            RoundedSquareBoxButton(
                contentDescription = stringResource(R.string.undo),
                interactionSource = undoInteractionSource,
                enabled = !state.paths.isEmpty(),
                onClick = { onAction(DrawingAction.OnUndoClick) },
                iconId = R.drawable.reply,
            )
            RoundedSquareBoxButton(
                contentDescription = stringResource(R.string.redo),
                interactionSource = redoInteractionSource,
                enabled = !state.undoList.isEmpty(),
                onClick = { onAction(DrawingAction.OnRedoClick) },
                iconId = R.drawable.forward,
            )
            BrightTextButton(
                label = stringResource(R.string.clear_canvas),
                enabled = !state.paths.isEmpty(),
                enabledColor = Success,
                contentColor = LightSurfaceHigh,
                onClick = { onAction(DrawingAction.OnClearCanvasClick) },
            )
        }
    }
}



@Preview
@Composable
fun OneRoundWonderScreenPreview() {
    val paddingValues = PaddingValues(
        horizontal = 0.dp,
        vertical = 20.dp
    )
    val state by remember { mutableStateOf(DrawingState()) }
    ScribbledashTheme {
        OneRoundWonderScreen(
            state = state,
            closeClick = {},
            onAction = {},
            paddingValues = paddingValues
        )
    }
}