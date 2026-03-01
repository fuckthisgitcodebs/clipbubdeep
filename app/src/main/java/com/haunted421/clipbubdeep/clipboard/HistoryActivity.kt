package com.haunted421.clipbubdeep.clipboard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.haunted421.clipbubdeep.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
private lateinit var binding: ActivityHistoryBinding
private lateinit var adapter: HistoryAdapter
private lateinit var manager: ClipboardHistoryManager

}
