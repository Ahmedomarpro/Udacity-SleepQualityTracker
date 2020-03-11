package com.ao.sleepquality.sleeptracker

import android.app.Application
 import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
 import com.ao.sleepquality.database.dao.SleepDatabaseDao

class SleepTrackerViewModelFactory(
    private val dataSource : SleepDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     *
     *
     * @param modelClass a `Class` whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
    </T> */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SleepTrackerViewModel::class.java))      {
            return SleepTrackerViewModel(dataSource, application) as T
    }

    throw IllegalArgumentException("Unknown ViewModel class")
}

}