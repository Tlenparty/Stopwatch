package com.tlenparty.stopwatch.data.calculates

import com.tlenparty.stopwatch.data.TimestampProvider
import com.tlenparty.stopwatch.states.StopwatchState

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