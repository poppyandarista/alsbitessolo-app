package com.luthfiana.alsbitessolo_

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)

        // Pindah ke MainActivity setelah 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, 1000L) // 3000L = 3 detik

        // Handle window insets untuk edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi untuk berpindah ke MainActivity
    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Tutup splash screen agar tidak kembali saat menekan tombol back
    }
}
