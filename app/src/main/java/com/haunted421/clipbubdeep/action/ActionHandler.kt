package com.haunted421.clipbubdeep.action

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.haunted421.clipbubdeep.R
import com.haunted421.clipbubdeep.TextCommandService
import com.haunted421.clipbubdeep.clipboard.ClipboardHistoryManager
import com.haunted421.clipbubdeep.clipboard.HistoryActivity

class ActionHandler(
private val context: Context,
private val prefs: android.content.SharedPreferences,
private val clipboardHistoryManager: ClipboardHistoryManager,
private val actionRepository: ActionRepository
) {
private val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

}
