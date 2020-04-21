package com.example.kliqrdemoapplication.screens

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.kliqrdemoapplication.R
import com.example.kliqrdemoapplication.databinding.FragmentOverViewBinding
import com.example.kliqrdemoapplication.model.Account
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


/**
 * A simple [Fragment] subclass.
 */
class OverViewFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AccountDetailsAdapter
    lateinit var binding: FragmentOverViewBinding
     var  value = arrayListOf<PieEntry>()
    var arrayAccount = arrayListOf<Account>()
    var num = 0
    var totalAmount:Long = 0
    private var dispalyArray = arrayListOf<Account>()
    private val myViewModel by viewModels<ViewModel> {
       ViewModelFactory()
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        totalAmount = myViewModel.getTotalAmount()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_over_view,container,false)

        (activity as MainActivity).supportActionBar?.title = getString(R.string.overview)

        recyclerView = binding.recyID


        adapter = AccountDetailsAdapter(dispalyArray){
            num = it
        }

        myViewModel.getAll().observeForever {allDetails ->

            arrayAccount.addAll(allDetails)

            if(arrayAccount.size > 3){
                dispalyArray.add(arrayAccount[0])
                dispalyArray.add(arrayAccount[1])
                dispalyArray.add(arrayAccount[2])
                 adapter.notifyDataSetChanged()


                 binding.showMore.setOnClickListener {
                    dispalyArray.clear()
                    dispalyArray.addAll(arrayAccount)




                   // checkRecyleView()
                    adapter.notifyDataSetChanged()
                }
            }

            adapter = AccountDetailsAdapter(dispalyArray){
              //  Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                del(it)
                adapter.notifyDataSetChanged()
            }
         recyclerView.adapter = adapter
        }

        binding.totalAmount.text = "₦${totalAmount}"
        val total = myViewModel.getTotalAmount().toFloat()
        val expenses = myViewModel.getExpenses().toFloat()
        chart(total,expenses)
        return binding.root
    }



    private fun chart(income:Float,expenses:Float){
        val pieChart = binding.graph
        pieChart.setUsePercentValues(true)
        value.add(PieEntry(income,"Income"))
        value.add(PieEntry(expenses,"Expenses"))
        val dataSet = PieDataSet(value,"")
        val desc = Description()
        desc.text = "Investment"
        pieChart.description = desc
        val pieData = PieData(dataSet)
        pieChart.data = pieData
        val colour = mutableListOf(Color.GREEN,Color.RED)
        dataSet.colors = colour
        pieChart.animateXY(1400,1400)
    }



    private fun del(num:Int){
        var a = dispalyArray.filter {
            it.id == num
        }
        Log.e("AOne",a.toString())
        dispalyArray.remove(a[0])

           var updatedArray = myViewModel.delete(a)


            totalAmount = myViewModel.getTotalAmount()
            binding.totalAmount.text = "₦${totalAmount}"

        if(dispalyArray.size == 1){
            dispalyArray.clear()
            for(i in updatedArray){
                Log.e("check",i.toString())

                dispalyArray.add(i)
            }
            binding.showMore.visibility = GONE
       }
        checkRecyleView()

    }


    private fun checkRecyleView(){
        if(dispalyArray.isEmpty()) {
            binding.recyID.visibility = GONE
            binding.cardHolder.visibility = GONE
        }
    }

    fun up(arr:ArrayList<Account>,updateArray: updateArray):ArrayList<Account>{
        return updateArray.update(arr)
    }
}

interface updateArray{
    fun update(arr:ArrayList<Account>):ArrayList<Account>{
        return arr
    }
}