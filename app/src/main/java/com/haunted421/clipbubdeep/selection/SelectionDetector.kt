package com.haunted421.clipbubdeep.selection

import android.graphics.Rect
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class SelectionDetector(
private val onTextSelected: (node: AccessibilityNodeInfo, text: String, packageName: String) -> Unit,
private val onSelectionCleared: () -> Unit
) {
private var lastSelectionTime = 0L
private var lastSelectedText = ""
private val debounceMs = 300L

}
