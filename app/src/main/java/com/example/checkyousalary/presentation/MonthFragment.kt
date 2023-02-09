package com.example.checkyousalary.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.checkyousalary.data.MonthData
import com.example.checkyousalary.databinding.FragmentMonthBinding
import java.util.*

private const val ARG_MONTH_ID = "month_id"

class MonthFragment: Fragment() {
    private lateinit var binding: FragmentMonthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMonthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val month = MonthData()
        binding.buttonToTest.setOnClickListener {
            month.title = binding.editToTest.text.toString()
            binding.textToTest.text = month.title
        }
    }


    companion object {

        fun newInstance(crimeId: UUID): MonthFragment {
            val args = Bundle().apply {
                putSerializable(ARG_MONTH_ID, crimeId)
            }
            return MonthFragment().apply {
                arguments = args
            }
        }
    }
}