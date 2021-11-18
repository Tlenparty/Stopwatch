package com.geekbrains.stopwatch.data

class TimestampProviderImpl: TimestampProvider {

    override fun getMilliseconds(): Long = System.currentTimeMillis()
}