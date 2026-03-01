package com.haunted421.clipbubdeep.ui

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
import com.haunted421.clipbubdeep.R
import com.haunted421.clipbubdeep.action.ActionHandler
import com.haunted421.clipbubdeep.action.ActionRepository
import com.haunted421.clipbubdeep.util.SwipeDetector
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class FloatingMenuManager(
private val context: Context,
private val actionHandler: ActionHandler,
private val actionRepository: ActionRepository
) {
private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
private var container: View? = null
private var params: WindowManager.LayoutParams? = null
private var isExpanded = false
private var isDragging = false
private var currentActions = listOf<com.haunted421.clipbubdeep.action.Action>()
private var currentText = ""
private var currentPackage = ""

}
