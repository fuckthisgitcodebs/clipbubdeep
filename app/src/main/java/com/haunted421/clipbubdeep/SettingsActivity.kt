package com.haunted421.clipbubdeep

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.haunted421.clipbubdeep.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
val binding = ActivitySettingsBinding.inflate(layoutInflater)
setContentView(binding.root)
supportActionBar?.setDisplayHomeAsUpEnabled(true)

}
