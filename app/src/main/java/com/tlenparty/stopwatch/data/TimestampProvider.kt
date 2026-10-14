package com.tlenparty.stopwatch.data

interface TimestampProvider {
    fun getMilliseconds():Long
}