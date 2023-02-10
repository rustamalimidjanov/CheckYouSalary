package com.example.checkyousalary.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.checkyousalary.data.MonthData
import com.example.checkyousalary.databinding.FragmentMonthBinding
import java.util.*

private const val ARG_MONTH_ID = "month_id"

class MonthFragment: Fragment() {
    private lateinit var binding: FragmentMonthBinding
    private lateinit var month: MonthData
    private val monthViewModel: MonthViewModel by lazy {
        ViewModelProvider(this)[MonthViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        month = MonthData()
        val monthId: UUID = arguments?.getSerializable(ARG_MONTH_ID) as UUID
        monthViewModel.loadMonth(monthId = monthId)

    }
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
        monthViewModel.monthLiveData.observe(
            viewLifecycleOwner,
            Observer { month ->
                month?.let {
                    this.month = month
                    updateUI()
                }
            }
        )
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                month.title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        }
        binding.editToTest.addTextChangedListener(titleWatcher)

    }

    fun updateUI() {
        binding.editToTest.setText(month.title).toString()
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