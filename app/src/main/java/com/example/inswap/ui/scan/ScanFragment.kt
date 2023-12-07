package com.example.inswap.ui.scan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.inswap.R
import com.example.inswap.databinding.FragmentHomeBinding
import com.example.inswap.databinding.FragmentScanBinding
import com.example.inswap.ui.home.HomeViewModel

class ScanFragment : Fragment() {

    companion object {
        fun newInstance() = ScanFragment()
    }

    private var _binding: FragmentScanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val scanViewModel =
            ViewModelProvider(this).get(ScanViewModel::class.java)

        _binding = FragmentScanBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textScan
//        scanViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        // TODO: Use the ViewModel
//    }

}