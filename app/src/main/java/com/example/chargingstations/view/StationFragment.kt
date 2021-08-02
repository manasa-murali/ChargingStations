package com.example.chargingstations.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.chargingstations.R
import com.example.chargingstations.model.MyUIData
import com.example.chargingstations.utils.UserLocation
import com.example.chargingstations.viewmodel.MyUIState
import com.example.chargingstations.viewmodel.StationViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.collect
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class StationFragment : Fragment(R.layout.fragment_station) {

    private val viewModel: StationViewModel by viewModels()
    private val userLocation = UserLocation(52.526, 13.415)
    private val distance = 5

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.station_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = recyclerView.adapter
        if (adapter == null) {
            adapter = StationAdapter(arrayListOf())
            recyclerView.adapter = adapter
        }

        lifecycleScope.launchWhenCreated {
            viewModel.uiDataFlow.collect {
                when (it) {
                    is MyUIState.Failure -> {
                        //TODO handle error ui according to error code

                        view.findViewById<SwipeRefreshLayout>(R.id.refresh_layout).isRefreshing =
                            false
                        recyclerView.visibility = View.GONE
                        view.findViewById<TextView>(R.id.error_text).visibility = View.VISIBLE
                    }
                    MyUIState.Initial -> {
                        viewModel.loadStationData(distance, userLocation)
                        startRefreshTimer()
                    }
                    MyUIState.Loading -> {
                        view.findViewById<SwipeRefreshLayout>(R.id.refresh_layout).isRefreshing =
                            true
                    }
                    is MyUIState.Success -> {
                        view.findViewById<SwipeRefreshLayout>(R.id.refresh_layout).isRefreshing =
                            false
                        recyclerView.visibility = View.VISIBLE
                        view.findViewById<TextView>(R.id.error_text).visibility = View.GONE
                        (adapter as StationAdapter).submitList(it.myUIDataList as ArrayList<MyUIData>)
                    }
                }
            }
        }
        view.findViewById<SwipeRefreshLayout>(R.id.refresh_layout).setOnRefreshListener {
            viewModel.refreshLayout(distance, userLocation)
        }
    }

    private fun startRefreshTimer() {
        Observable.interval(30, TimeUnit.SECONDS)
            .subscribe {
                viewModel.loadStationData(distance, userLocation)
            }
    }
}