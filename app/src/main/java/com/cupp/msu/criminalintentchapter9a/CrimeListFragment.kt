package com.cupp.msu.criminalintentchapter9a

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cupp.msu.criminalintentchapter9a.databinding.FragmentCrimeListBinding


private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {


    private var _binding: FragmentCrimeListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

  private val crimeListViewModel :CrimeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "total Crimes : ${crimeListViewModel.crimes.size}")

    }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
           _binding = FragmentCrimeListBinding.inflate(inflater, container, false)

            binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)

            val crimes = crimeListViewModel.crimes
            val adapter = CrimeHolder.CrimeListAdapter(crimes)
            binding.crimeRecyclerView.adapter = adapter

            return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}