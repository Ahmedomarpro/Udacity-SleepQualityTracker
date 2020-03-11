package com.ao.sleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ao.sleepquality.database.dao.SleepDatabaseDao

class SleepTrackerViewModel(val database: SleepDatabaseDao, application: Application) : AndroidViewModel(application) {
}