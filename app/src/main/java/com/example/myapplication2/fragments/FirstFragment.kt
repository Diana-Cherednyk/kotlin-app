package com.example.myapplication2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.Adapter
import com.example.myapplication2.InformationModel
import com.example.myapplication2.Model
import com.example.myapplication2.R

class FirstFragment : Fragment() {
    private val recText: RecyclerView
        get() = recTextList
    private lateinit var textAdapter: Adapter
    private fun getFood(): List<Model> {
        return InformationModel.funText()
    }
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textAdapter = Adapter(requireActivity())
        textAdapter.setData(getFood())
        recText.layoutManager = LinearLayoutManager(requireContext())
        recText.setHasFixedSize(true)
        recText.adapter = textAdapter
    }
}
