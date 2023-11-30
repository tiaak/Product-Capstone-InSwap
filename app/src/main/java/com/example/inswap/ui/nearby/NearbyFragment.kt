package com.example.inswap.ui.nearby

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.inswap.R
import com.example.inswap.databinding.FragmentHomeBinding
import com.example.inswap.databinding.FragmentNearbyBinding
import com.example.inswap.ui.home.HomeViewModel

class NearbyFragment : Fragment() {

    companion object {
        fun newInstance() = NearbyFragment()
    }

    private var _binding: FragmentNearbyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val nearbyViewModel =
            ViewModelProvider(this).get(NearbyViewModel::class.java)

        _binding = FragmentNearbyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNearby
        nearbyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        // TODO: Use the ViewModel
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}