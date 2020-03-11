package com.ao.sleepquality.sleeptracker

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ao.sleepquality.R
import com.ao.sleepquality.database.SleepDatabase
import com.ao.sleepquality.databinding.FragmentSleepTrackerBinding

/**
 * A simple [Fragment] subclass.
 */
class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSleepTrackerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sleep_tracker, container, false)
        val application = requireNotNull(this.activity).application

        val dataSource  = SleepDatabase.getInstance(application).sleepDatabaseDao

        val viewModelFactory = SleepTrackerViewModelFactory(dataSource, application)
        val sleepTrackerViewModel= ViewModelProviders.of(this,viewModelFactory).get(SleepTrackerViewModel::class.java)
        binding.sleepTrackerViewModel = sleepTrackerViewModel

        binding.lifecycleOwner =  (this)


        return binding.root
    }

}
