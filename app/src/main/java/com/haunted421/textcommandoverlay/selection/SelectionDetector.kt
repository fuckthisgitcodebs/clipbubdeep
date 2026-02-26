package com.haunted421.textcommandoverlay.selection

import android.graphics.Rect
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

/**

· Detects text selection events and extracts the selected text and its screen bounds.
· Uses a debounce mechanism to avoid rapid toggling.
  */
  class SelectionDetector(
  private val onTextSelected: (node: AccessibilityNodeInfo, text: String, packageName: String) -> Unit,
  private val onSelectionCleared: () -> Unit
  ) {
  private var lastSelectionTime = 0L
  private var lastSelectedText = ""
  private var debounceMs = 300L
  fun handleEvent(event: AccessibilityEvent, root: AccessibilityNodeInfo?) {
  if (root == null) return
  }
  private fun findSelectedNode(root: AccessibilityNodeInfo): AccessibilityNodeInfo? {
  val queue = ArrayDeque<AccessibilityNodeInfo>()
  queue.add(root)
  while (queue.isNotEmpty()) {
  val node = queue.removeFirst()
  val start = node.textSelectionStart
  val end = node.textSelectionEnd
  if (start >= 0 && end > start) {
  return node
  }
  for (i in 0 until node.childCount) {
  node.getChild(i)?.let { queue.add(it) }
  }
  }
  return null
  }
  companion object {
  fun getNodeBounds(node: AccessibilityNodeInfo): Rect {
  val rect = Rect()
  node.getBoundsInScreen(rect)
  return rect
  }
  }
  }
