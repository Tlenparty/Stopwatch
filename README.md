# Stopwatch

An Android "Stopwatch" app with two independent timers. The logic is split
into layers following clean architecture principles: state and elapsed-time calculation
are separated from the UI, the screen works through a ViewModel and LiveData, and time updates
run on coroutines.

## Features

- Two independent stopwatches on one screen
- Start, pause and reset for each timer
- Time displayed as `mm:ss:ms` (`hh:mm:ss` once it exceeds an hour)

## Tech stack

| Area           | Technologies                            |
|----------------|-----------------------------------------|
| Language       | Kotlin                                  |
| Architecture   | MVVM (ViewModel, LiveData)              |
| Concurrency    | Kotlin Coroutines, Flow                 |
| UI             | ViewBinding, ConstraintLayout, Material |

## Project structure

```
app/src/main/java/com/tlenparty/stopwatch/
├── MainActivity.kt
├── data/            # time source, state and elapsed-time calculators
├── helpers/         # time formatting
├── states/          # StopwatchState: Running / Paused
└── viewmodels/      # StopwatchViewModel, factory, StopwatchStateHolder
```

## Build

Requires JDK 11–17 and Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
