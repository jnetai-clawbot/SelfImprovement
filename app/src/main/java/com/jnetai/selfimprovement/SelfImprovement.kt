package com.jnetai.selfimprovement

import android.app.Application
import com.jnetai.selfimprovement.data.SelfImprovementDatabase

class SelfImprovement : Application() {
    val database by lazy { SelfImprovementDatabase.getInstance(this) }
}