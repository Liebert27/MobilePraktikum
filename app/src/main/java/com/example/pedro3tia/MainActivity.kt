package com.example.pedro3tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pedro3tia.databinding.ActivityLoginBinding
import com.example.pedro3tia.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.bumptech.glide.Glide
import com.example.pedro3tia.pertemuan_5.LimaActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        binding.txtUsername.text = user
        binding.txtPassword.setText(pass)

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Keep trying to Suprising me",
                Snackbar.LENGTH_LONG)
                .setAction("Info") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Kembali ke halaman Activity", Toast.LENGTH_LONG).show()
                }
                .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }

        val gift = findViewById<ImageView>(R.id.imageView2)

        Glide.with(this)
            .asGif()
            .load(R.drawable.peanut_butter_dancing_gif)
            .into(gift)


    }

}