package com.haunted421.clipbubdeep

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.preference.PreferenceManager
import com.haunted421.clipbubdeep.action.ActionHandler
import com.haunted421.clipbubdeep.action.ActionRepository
import com.haunted421.clipbubdeep.clipboard.ClipboardHistoryManager
import com.haunted421.clipbubdeep.selection.SelectionDetector
import com.haunted421.clipbubdeep.ui.FloatingMenuManager
import kotlinx.coroutines.*

class TextCommandService : AccessibilityService() {
private lateinit var selectionDetector: SelectionDetector
private lateinit var menuManager: FloatingMenuManager
private lateinit var actionHandler: ActionHandler
private lateinit var clipboardHistoryManager: ClipboardHistoryManager
private lateinit var actionRepository: ActionRepository
private val serviceScope = CoroutineScope(Dispatchers.Main + Job())

}
