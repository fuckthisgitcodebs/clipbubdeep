package com.haunted421.clipbubdeep.clipboard

import android.content.Context
import kotlinx.coroutines.flow.Flow

class ClipboardHistoryManager private constructor(context: Context) {
private val db = ClipboardDatabase.getInstance(context)
private val dao = db.clipboardDao()
private val maxSizeBytes = 50 * 1024 * 1024 // 50 MB

}
