package com.haunted421.textcommandoverlay.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.PixelFormat
import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.view.*
import android.view.animation.OvershootInterpolator
import android.widget.ImageButton
import androidx.preference.PreferenceManager
import com.haunted421.textcommandoverlay.ActionHandler
import com.haunted421.textcommandoverlay.R
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**

· Manages the floating radial menu: show, hide, drag, expand/collapse, auto-hide.
  */
  class FloatingMenuManager(
  private val context: Context,
  private val actionHandler: ActionHandler
  ) {
  private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  private var container: View? = null
  private var params: WindowManager.LayoutParams? = null
  private var isExpanded = false
  private var isDragging = false
  private val mainButton: ImageButton? get() = container?.findViewById(R.id.btnMain)
  private val actionButtons: List<ImageButton> by lazy {
  listOf(
  container?.findViewById(R.id.btnShare),
  container?.findViewById(R.id.btnCopy),
  container?.findViewById(R.id.btnAppend),
  container?.findViewById(R.id.btnPaste),
  container?.findViewById(R.id.btnTasker)
  ).filterNotNull()
  }
  private val handler = Handler(Looper.getMainLooper())
  private val autoHideRunnable = Runnable { hideMenu() }
  private var autoHideDelayMs = 15000L
  private var menuRadiusDp = 180f
  private var menuSizeDp = 460f
  // Angles for action buttons (degrees) – starting from top (270) going clockwise
  private val buttonAngles = listOf(270f, 198f, 126f, 54f, 342f)
  init {
  loadPreferences()
  }
  private fun loadPreferences() {
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  autoHideDelayMs = prefs.getString("auto_hide_timeout", "15000")?.toLongOrNull() ?: 15000L
  menuRadiusDp = prefs.getString("menu_radius", "180")?.toFloatOrNull() ?: 180f
  menuSizeDp = prefs.getString("menu_size", "460")?.toFloatOrNull() ?: 460f
  }
  fun showMenu(selectionRect: Rect, selectedText: String, packageName: String) {
  if (container != null) {
  updatePosition(selectionRect)
  resetAutoHideTimer()
  return
  }
  }
  private fun calculateInitialPosition(rect: Rect) {
  val density = context.resources.displayMetrics.density
  val half = (menuSizeDp * density / 2).toInt()
  val screenWidth = context.resources.displayMetrics.widthPixels
  val screenHeight = context.resources.displayMetrics.heightPixels
  }
  private fun updatePosition(rect: Rect) {
  if (container == null || params == null) return
  calculateInitialPosition(rect)
  try {
  windowManager.updateViewLayout(container, params)
  } catch (e: Exception) {
  // Ignore
  }
  }
  private fun setupMainButton() {
  val main = mainButton ?: return
  var initialX = 0
  var initialY = 0
  var initialTouchX = 0f
  var initialTouchY = 0f
  var dragThresholdPassed = false
  }
  private fun setupActionButtons(selectedText: String, packageName: String) {
  actionButtons[0].setOnClickListener {
  actionHandler.share(selectedText)
  collapseAndHide()
  }
  actionButtons[1].setOnClickListener {
  actionHandler.copy(selectedText)
  collapseAndHide()
  }
  actionButtons[2].setOnClickListener {
  actionHandler.appendToClipboard(selectedText)
  collapseAndHide()
  }
  actionButtons[3].setOnClickListener {
  actionHandler.paste()
  collapseAndHide()
  }
  actionButtons[4].setOnClickListener {
  actionHandler.sendToTasker(selectedText, packageName)
  collapseAndHide()
  }
  }
  private fun toggleExpand() {
  if (isExpanded) collapseMenu() else expandMenu()
  }
  private fun expandMenu() {
  if (isExpanded) return
  isExpanded = true
  }
  private fun collapseMenu() {
  if (!isExpanded) return
  isExpanded = false
  }
  fun hideMenu() {
  collapseMenu()
  container?.let {
  try {
  windowManager.removeView(it)
  } catch (_: Exception) { }
  }
  container = null
  isExpanded = false
  handler.removeCallbacks(autoHideRunnable)
  }
  private fun collapseAndHide() {
  collapseMenu()
  handler.postDelayed({ hideMenu() }, 300)
  }
  private fun resetAutoHideTimer() {
  handler.removeCallbacks(autoHideRunnable)
  handler.postDelayed(autoHideRunnable, autoHideDelayMs)
  }
  private fun dpToPx(dp: Int): Int = (dp * context.resources.displayMetrics.density).toInt()
  }
