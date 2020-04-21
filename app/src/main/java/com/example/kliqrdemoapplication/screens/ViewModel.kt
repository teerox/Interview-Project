package com.example.kliqrdemoapplication.screens

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kliqrdemoapplication.R
import com.example.kliqrdemoapplication.model.Account
import com.example.kliqrdemoapplication.model.Expenses

class ViewModel():ViewModel(){
    private var firstAccount1 = Account(1,R.drawable.send,20000,"0080172623","Access Bank","2 weeks ago",true)
    private var firstAccount2 = Account(2,R.drawable.zenithicon,15000,"0080172623","Zenith Bank","4 days ago",true)
    private var firstAccount3 = Account(3,R.drawable.ubaicon,51545,"0080172623","UBA","6 hours ago",true)
    private var firstAccount4 = Account(4,R.drawable.unionbankicon,2165,"0080172623","Union Bank","1 month ago",true)
    private var firstAccount5 = Account(5,R.drawable.send,26500,"0080172623","Diamond Bank","2 hours ago",true)


    //Expenses Dummy
    private var expenses1 = Expenses(1,3000)
    private var expenses2 = Expenses(2,3000)
    private var expenses3 = Expenses(3,3000)

    private val arr = mutableListOf(firstAccount1,firstAccount2,firstAccount3,firstAccount4,firstAccount5)
    private val arr2 = mutableListOf(expenses1,expenses2,expenses3)

    private val items: MutableLiveData<List<Account>> = MutableLiveData()


    fun getAll(): MutableLiveData<List<Account>> {
        items.postValue(arr)
        return items
    }


    fun getTotalAmount():Long{
        var total:Long = 0
        for (eachAmount in arr){
            total += eachAmount.amount
        }
        return total
    }



    fun delete(id:List<Account>):MutableList<Account>{
        arr.remove(id[0])
        Log.e("All Array",arr.toString())
        Log.e("All Array22",arr.size.toString())
        return arr

    }


    fun getExpenses():Long{
        var total:Long = 0
        for (eachAmount in arr2){
            total += eachAmount.amountSpent
        }
        return total
    }
}