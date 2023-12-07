package com.example.inswap.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.inswap.R
import com.example.inswap.databinding.FragmentHomeBinding
import com.example.inswap.ui.main.MainActivity
import com.example.inswap.ui.upload.UploadActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var fabAdd : FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fabAdd = binding.fabAdd
        fabAdd.setOnClickListener {
            val moveToUpload = Intent(activity, UploadActivity::class.java)
            startActivity(moveToUpload)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}