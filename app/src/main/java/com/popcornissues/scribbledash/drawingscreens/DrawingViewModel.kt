package com.popcornissues.scribbledash.drawingscreens

import android.util.Log
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.popcornissues.scribbledash.domain.Constants.Companion.MAX_UNDOS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DrawingViewModel: ViewModel() {

    private val _state = MutableStateFlow(DrawingState())
    val state = _state.asStateFlow()

    fun onAction(action: DrawingAction) {
        when (action) {
            DrawingAction.OnClearCanvasClick -> onClearCanvasClick()
            is DrawingAction.OnDraw -> onDraw(action.offset)
            DrawingAction.OnNewPathStart -> onNewPathStart()
            DrawingAction.OnPathEnd -> onPathEnd()
            is DrawingAction.OnSelectColor -> onSelectColor(action.color)
            is DrawingAction.OnRedoClick -> onRedoClick()
            is DrawingAction.OnUndoClick -> onUndoClick()
        }
    }

    private fun onUndoClick() {
        if (_state.value.paths.isEmpty()) {
            Log.d("viewmodel error", "undo clicked, no paths to undo")
            return
        }

        val movePath = state.value.paths.last() // in case drop happens first
        _state.update {
            it.copy(
                undoList = it.undoList + movePath,
                paths = it.paths.dropLast(1)
            )
        }
        if (state.value.undoList.size > MAX_UNDOS) {
            _state.update {
                it.copy(
                    undoList = it.undoList.takeLast(MAX_UNDOS)
                )
            }
        }
    }

    private fun onRedoClick() {
        if (_state.value.undoList.isEmpty()) {
            Log.d("viewmodel error", "redo clicked, nothing in undo list")
            return
        }
        val movePath = _state.value.undoList.last()
        _state.update {
            it.copy(
                paths = it.paths + movePath,
                undoList = it.undoList.dropLast(1),
            )
        }
    }

    private fun onSelectColor(color: Color) {
        _state.update { it.copy(selectedColor = color) }
    }

    private fun onPathEnd() {
        val currentPathData = state.value.currentPath ?: return
        _state.update {
            it.copy(currentPath = null,
                paths = it.paths + currentPathData
            )
        }
    }

    private fun onNewPathStart() {
        _state.update { it.copy(
            currentPath = PathData(
                id = System.currentTimeMillis().toString(),
                color = it.selectedColor,
                path = emptyList()
            )
        ) }
    }

    private fun onDraw(offset: Offset) {
        val currentPathData = state.value.currentPath ?: return
        _state.update {
            it.copy(currentPath = currentPathData.copy(
                path = currentPathData.path + offset
            ))
        }
    }

    private fun onClearCanvasClick() {
        _state.update { it.copy(
            currentPath = null,
            paths = emptyList(),
            undoList = emptyList()
        ) }
    }
}