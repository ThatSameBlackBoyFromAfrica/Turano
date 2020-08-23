package com.ampaschal.soilinfo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.PlacesAdapter
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.databinding.FragmentPlacesBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class PlacesFragment : Fragment() {
    lateinit var rvPlaces: RecyclerView
    var places: ArrayList<PlaceSummary>? = null
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        val placesBinding =
            FragmentPlacesBinding.inflate(
                inflater,
                container,
                false
            )

        rvPlaces = placesBinding.listPlaces

        val placesLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        val placesAdapter = PlacesAdapter()
        rvPlaces.layoutManager = placesLayoutManager
        rvPlaces.adapter = placesAdapter

        mainViewModel.getPlacesList().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            placesAdapter.setData(it)
        })

        val tvAddPlace = placesBinding.tvAddPlace
        tvAddPlace.setOnClickListener {
            val intent = Intent(activity, AddPlaceActivity::class.java)
            startActivity(intent)
        }

        return placesBinding.root
    }
}