package com.example.inswap.ui.maggot

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inswap.R
import com.example.inswap.databinding.ActivityMaggotBinding

class MaggotActivity : AppCompatActivity() {
    private lateinit var rvMaggot: RecyclerView
    private val list = ArrayList<MaggotFarm>()
    private lateinit var binding: ActivityMaggotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaggotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        rvMaggot = binding.rvMaggot
        rvMaggot.setHasFixedSize(true)


        list.addAll(getListMaggot())
        showRecycleList()
    }

    private fun getListMaggot(): Collection<MaggotFarm> {
        val farmName = resources.getStringArray(R.array.farm_name)
        val address = resources.getStringArray(R.array.address)
        val phoneNum = resources.getStringArray(R.array.phone_number)

        val listMaggot = ArrayList<MaggotFarm>()
        for(i in farmName.indices){
            val maggot = MaggotFarm(farmName[i], address[i], phoneNum[i])
            listMaggot.add(maggot)
        }
        return listMaggot
    }

    private fun showRecycleList() {
        rvMaggot.layoutManager = LinearLayoutManager(this)
        val listMaggotAdaptor = ListMaggotAdaptor(list)
        rvMaggot.adapter = listMaggotAdaptor

//        listMaggotAdaptor.setOnItemClickCallback(object: ListMaggotAdaptor.OnItemClickCallback{
//            override fun onItemClicked(data: MaggotFarm) {
//                CallMaggotFarm(data)
//            }
//        })

    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.phoneIcon ->{
//                val phoneNumber = resources.getStringArray(R.array.phone_number)
//                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber[i]"))
//                startActivity(dialPhoneIntent)
//            }
//        }
//    }

}