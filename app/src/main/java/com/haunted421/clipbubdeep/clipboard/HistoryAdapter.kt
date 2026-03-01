package com.haunted421.clipbubdeep.clipboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.haunted421.clipbubdeep.databinding.ItemHistoryBinding
import java.text.SimpleDateFormat
import java.util.Locale

class HistoryAdapter(private val onItemClick: (ClipboardEntry) -> Unit) :
ListAdapter<ClipboardEntry, HistoryAdapter.ViewHolder>(DiffCallback()) {

}
