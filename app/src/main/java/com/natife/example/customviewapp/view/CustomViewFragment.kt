package com.natife.example.customviewapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natife.example.customviewapp.R
import com.natife.example.customviewapp.databinding.FragmentCustomViewBinding

class CustomViewFragment private constructor(): Fragment() {
    private lateinit var binding: FragmentCustomViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            activity?.apply {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, CustomLayoutFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        fun newInstance() = CustomViewFragment()
    }
}