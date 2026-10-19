package com.example.pedro3tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pedro3tia.Home.pertemuan_5.LimaActivity
import com.example.pedro3tia.Home.pertemuan_6.EnamActivity
import com.example.pedro3tia.LoginActivity
import com.example.pedro3tia.MainActivity
import com.example.pedro3tia.R
import com.example.pedro3tia.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

//        val user = intent.getStringExtra("username")
//        val pass = intent.getStringExtra("password")

//        binding.txtUsername.text = user
//        binding.txtPassword.setText(pass)

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Keep trying to Suprising me",
                Snackbar.LENGTH_LONG)
                .setAction("Info") {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(requireContext(), "Kembali ke halaman Activity", Toast.LENGTH_LONG).show()
                }
                .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
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
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }

        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(requireContext(), EnamActivity::class.java))
        }

        binding.btnToTujuh.setOnClickListener {
            startActivity(Intent(requireContext(), HomeFragment::class.java))
        }

        binding.btnLogout.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        val gift = view.findViewById<ImageView>(R.id.imageView2)

        Glide.with(this)
            .asGif()
            .load(R.drawable.peanut_butter_dancing_gif)
            .into(gift)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}