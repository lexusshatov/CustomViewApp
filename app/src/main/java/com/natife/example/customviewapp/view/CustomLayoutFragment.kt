package com.natife.example.customviewapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natife.example.customviewapp.databinding.FragmentCustomLayoutBinding

class CustomLayoutFragment private constructor(): Fragment() {
    private lateinit var binding: FragmentCustomLayoutBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            binding.customContainer.addItem("item $count")
            count++
        }
    }

    companion object {
        fun newInstance() = CustomLayoutFragment()
    }
}