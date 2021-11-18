package com.geekbrains.stopwatch.viewmodels

import com.geekbrains.stopwatch.data.calculates.ElapsedTimeCalculator
import com.geekbrains.stopwatch.data.calculates.StopwatchStateCalculator
import com.geekbrains.stopwatch.helpers.extension.toStringTime
import com.geekbrains.stopwatch.states.StopwatchState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StopwatchStateHolder(
    private val stopwatchStateCalculator: StopwatchStateCalculator,
    private val elapsedTimeCalculator: ElapsedTimeCalculator
) {
    private val currentStates: MutableMap<Int, StopwatchState> = mutableMapOf()

    fun start(number: Int) {
        val currentState = getCurrentState(number)
        currentStates[number] = stopwatchStateCalculator.calculateRunningState(currentState)
    }

    fun pause(number: Int) {
        val currentState = getCurrentState(number)
        currentStates[number] = stopwatchStateCalculator.calculatePausedState(currentState)
    }

    fun stop(number: Int) {
        currentStates[number] = StopwatchState.Paused(0)
    }

    fun getStringTimeRepresent(number: Int): Flow<String> {
        val elapsedTime = when (val currentState = getCurrentState(number)) {
            is StopwatchState.Paused -> currentState.elapsedTime
            is StopwatchState.Running -> elapsedTimeCalculator.calculate(currentState)
        }
        return flow { emit(elapsedTime.toStringTime()) }
    }

    private fun getCurrentState(number: Int): StopwatchState =
        currentStates[number]?.let {
            return@let it
        } ?: StopwatchState.Paused(0)
}