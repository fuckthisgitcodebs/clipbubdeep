package com.haunted421.textcommandoverlay

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.preference.PreferenceManager
import com.haunted421.textcommandoverlay.selection.SelectionDetector
import com.haunted421.textcommandoverlay.ui.FloatingMenuManager

/**

· Main accessibility service that listens for text selection events
· and coordinates the floating menu.
  */
  class TextCommandService : AccessibilityService() {
  private lateinit var selectionDetector: SelectionDetector
  private lateinit var menuManager: FloatingMenuManager
  private lateinit var actionHandler: ActionHandler
  private var currentSelectedText: String = ""
  private var currentSourcePackage: String = ""
  private var selectedNode: AccessibilityNodeInfo? = null
  override fun onCreate() {
  super.onCreate()
  val prefs = PreferenceManager.getDefaultSharedPreferences(this)
  actionHandler = ActionHandler(this, prefs)
  menuManager = FloatingMenuManager(this, actionHandler)
  selectionDetector = SelectionDetector(
  onTextSelected = { node, text, packageName ->
  selectedNode = node
  currentSelectedText = text
  currentSourcePackage = packageName
  val bounds = node?.let { SelectionDetector.getNodeBounds(it) }
  if (bounds != null) {
  menuManager.showMenu(bounds, text, packageName)
  }
  },
  onSelectionCleared = {
  menuManager.hideMenu()
  selectedNode?.recycle()
  selectedNode = null
  }
  )
  }
  override fun onAccessibilityEvent(event: AccessibilityEvent) {
  when (event.eventType) {
  AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED,
  AccessibilityEvent.TYPE_VIEW_FOCUSED,
  AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
  selectionDetector.handleEvent(event, rootInActiveWindow)
  }
  }
  }
  override fun onInterrupt() {
  menuManager.hideMenu()
  }
  override fun onDestroy() {
  menuManager.hideMenu()
  selectedNode?.recycle()
  super.onDestroy()
  }
  // Called by menu actions to perform operations
  fun getSelectedText() = currentSelectedText
  fun getSourcePackage() = currentSourcePackage
  fun getSelectedNode() = selectedNode
  companion object {
  const val ACTION_TASKER_BROADCAST = "com.haunted421.textcommandoverlay.TEXT_SELECTED"
  }
  }
