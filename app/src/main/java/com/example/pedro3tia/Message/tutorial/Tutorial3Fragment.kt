package com.example.pedro3tia.Message.tutorial

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pedro3tia.LoginActivity
import com.example.pedro3tia.R

import com.example.pedro3tia.databinding.FragmentTutorial3Binding
import java.util.zip.Inflater


class Tutorial3Fragment : Fragment() {
    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        val gift = view.findViewById<ImageView>(R.id.imageView3)

        Glide.with(this)
            .asGif()
            .load(R.drawable.rikka)
            .into(gift)
    }


}