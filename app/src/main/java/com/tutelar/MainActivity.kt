package com.tutelar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutelar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Tutelar.init(this@MainActivity, "tutpk_live_ZYoLAPRkDva2")
        setUpUi()
    }

    private fun setUpUi() {
        binding.apply {
            getDetailsButton.setOnClickListener {
                detailsTextView.text = Tutelar.getDeviceDetails(this@MainActivity)
            }
        }
    }
}