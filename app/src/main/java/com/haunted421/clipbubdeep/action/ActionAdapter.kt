package com.haunted421.clipbubdeep.action

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haunted421.clipbubdeep.databinding.ItemActionBinding

class ActionAdapter(
private var actions: MutableList<Action>,
private val onListChanged: (List<Action>) -> Unit
) : RecyclerView.Adapter<ActionAdapter.ViewHolder>() {

}
