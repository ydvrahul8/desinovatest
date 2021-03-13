package com.example.desynovatest.utils

import com.example.desynovatest.databinding.FragmentHomeBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

 fun setPieChart(
     binding: FragmentHomeBinding,
     map: HashMap<String, Int>,
     label: String
 ) {
    val pieEntries = ArrayList<PieEntry>()
    for (type in map.keys) {
        pieEntries.add(PieEntry(map[type]?.toFloat()!!, type))
    }

    val dataSet = PieDataSet(pieEntries, label)

    dataSet.valueTextSize = 13f

    val colors: ArrayList<Int> = ArrayList()
    for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)
    dataSet.colors = colors

    val pieData = PieData(dataSet)
    pieData.setDrawValues(true)
    binding.piechart.data = pieData
    binding.piechart.invalidate()
    binding.piechart.description.isEnabled = false
    binding.piechart.animateXY(5000, 5000)
}