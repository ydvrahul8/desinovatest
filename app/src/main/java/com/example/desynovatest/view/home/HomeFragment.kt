package com.example.desynovatest.view.home

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.desynovatest.R
import com.example.desynovatest.base.BaseFragment
import com.example.desynovatest.databinding.FragmentHomeBinding
import com.example.desynovatest.di.viewmodel.ViewModelProviderFactory
import com.example.desynovatest.model.GraphModel
import com.example.desynovatest.utils.Status
import com.example.desynovatest.utils.setPieChart
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(), View.OnClickListener {
    private val TAG = "HomeFragment"
    override val layout: Int
        get() = R.layout.fragment_home

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private val viewModel: HomeViewModel by activityViewModels { factory }
    private lateinit var graphModel: GraphModel
    private lateinit var binding: FragmentHomeBinding
    override fun init(bind: FragmentHomeBinding) {
        binding = bind
        observeData()
    }

    private fun observeData() {
        viewModel.observeData().removeObservers(viewLifecycleOwner)
        viewModel.observeData().observe(viewLifecycleOwner, Observer {
            if (it != null)
                when (it.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> setData(it.data)
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.textViewError.visibility = View.GONE
                    }
                }
        })
    }

    private fun setData(graphModel: GraphModel?) {
        binding.progressBar.visibility = View.GONE
        if (graphModel != null) {
            this.graphModel = graphModel
        }

        binding.textViewDay.setOnClickListener(this)
        binding.textViewWeek.setOnClickListener(this)
        binding.textViewMonth.setOnClickListener(this)

        setDays()
    }

    private fun setDays() {
        val days = graphModel.day

        val map = HashMap<String, Int>()

        map[days[0].name] = days[0].processed
        map[days[1].name] = days[1].inprogress
        map[days[2].name] = days[2].pending

        setPieChart(binding, map, "Day History")
    }

    private fun setWeek() {
        val week = graphModel.week

        val map = HashMap<String, Int>()

        map[week[0].name] = week[0].processed
        map[week[1].name] = week[1].inprogress
        map[week[2].name] = week[2].pending

        setPieChart(binding, map, "Week History")
    }

    private fun setMonth() {
        val month = graphModel.month

        val map = HashMap<String, Int>()

        map[month[0].name] = month[0].processed
        map[month[1].name] = month[1].inprogress
        map[month[2].name] = month[2].pending

        setPieChart(binding,map, "Month History")
    }



    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.textView_day -> {
                setDays()
            }
            R.id.textView_Week -> {
                setWeek()
            }
            R.id.textView_month -> {
                setMonth()
            }
        }
    }


}