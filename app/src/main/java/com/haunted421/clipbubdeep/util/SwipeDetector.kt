package com.haunted421.clipbubdeep.util

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class SwipeDetector(view: View, private val listener: Listener) {
interface Listener {
fun onSwipe(direction: Direction)
}

}
