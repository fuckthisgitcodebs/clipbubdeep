package com.haunted421.textcommandoverlay

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import androidx.preference.PreferenceManager

/**

· Handles actions triggered from the radial menu.
  */
  class ActionHandler(
  private val context: Context,
  private val prefs: android.content.SharedPreferences
  ) {
  private val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
  fun share(text: String) {
  val intent = Intent(Intent.ACTION_SEND).apply {
  type = "text/plain"
  putExtra(Intent.EXTRA_TEXT, text)
  }
  context.startActivity(
  Intent.createChooser(intent, context.getString(R.string.share_via))
  .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
  )
  }
  fun copy(text: String) {
  clipboardManager.setPrimaryClip(ClipData.newPlainText("TextCommand", text))
  Toast.makeText(context, R.string.copied, Toast.LENGTH_SHORT).show()
  }
  fun appendToClipboard(text: String) {
  val existing = clipboardManager.primaryClip?.getItemAt(0)?.text?.toString() ?: ""
  val newText = if (existing.isEmpty()) text else "$existing\n\n$text"
  clipboardManager.setPrimaryClip(ClipData.newPlainText("TextCommand", newText))
  Toast.makeText(context, R.string.appended, Toast.LENGTH_SHORT).show()
  }
  fun paste() {
  // Try to find the currently focused editable node
  val service = (context as? TextCommandService) ?: return
  val node = service.getSelectedNode()
  if (node?.isEditable == true) {
  node.performAction(AccessibilityNodeInfo.ACTION_PASTE)
  } else {
  Toast.makeText(context, R.string.no_editable_field, Toast.LENGTH_SHORT).show()
  }
  }
  fun sendToTasker(text: String, sourcePackage: String) {
  val customAction = prefs.getString("tasker_custom_action", TextCommandService.ACTION_TASKER_BROADCAST)
  val intent = Intent(customAction).apply {
  putExtra("text", text)
  putExtra("source_package", sourcePackage)
  putExtra("timestamp", System.currentTimeMillis())
  // Allow user to add extras via pref? Could be expanded.
  }
  context.sendBroadcast(intent)
  Toast.makeText(context, R.string.sent_to_tasker, Toast.LENGTH_SHORT).show()
  }
  }
