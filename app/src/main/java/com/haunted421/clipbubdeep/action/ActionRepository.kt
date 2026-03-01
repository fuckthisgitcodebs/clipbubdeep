package com.haunted421.clipbubdeep.action

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ActionRepository(private val context: Context) {
private val prefs = context.getSharedPreferences("actions", Context.MODE_PRIVATE)
private val gson = Gson()

}
