package com.geekbrains.stopwatch.data.calculates

import com.geekbrains.stopwatch.data.TimestampProvider
import com.geekbrains.stopwatch.states.StopwatchState

class ElapsedTimeCalculator(private val timestampProvider: TimestampProvider) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}