package com.haunted421.textcommandoverlay

import android.content.Context
import androidx.preference.PreferenceManager

/**

· Helper object to access user preferences.
  */
  object Preferences {
  fun getAutoHideTimeout(context: Context): Long {
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  return prefs.getString("auto_hide_timeout", "15000")?.toLongOrNull() ?: 15000L
  }
  fun getMenuRadius(context: Context): Float {
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  return prefs.getString("menu_radius", "180")?.toFloatOrNull() ?: 180f
  }
  fun getMenuSize(context: Context): Float {
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  return prefs.getString("menu_size", "460")?.toFloatOrNull() ?: 460f
  }
  fun isActionEnabled(context: Context, actionKey: String): Boolean {
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  return prefs.getBoolean(actionKey, true)
  }
  }
