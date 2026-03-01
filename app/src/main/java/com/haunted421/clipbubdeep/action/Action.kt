package com.haunted421.clipbubdeep.action

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Action(
val id: String,
val titleResId: Int,
val iconResId: Int,
var enabled: Boolean = true,
var order: Int = 0
) : Parcelable {
companion object {
val DEFAULT_ACTIONS = listOf(
Action("share", R.string.share, R.drawable.ic_share),
Action("copy", R.string.copy, R.drawable.ic_copy),
Action("append", R.string.append, R.drawable.ic_append),
Action("paste", R.string.paste, R.drawable.ic_paste),
Action("tasker", R.string.tasker, R.drawable.ic_tasker),
Action("history", R.string.history, R.drawable.ic_history)
)
}
}
