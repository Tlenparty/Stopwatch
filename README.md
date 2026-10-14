# Stopwatch

Android-приложение «Секундомер» с двумя независимыми таймерами. Логика разделена
на слои по принципам чистой архитектуры: расчёт состояния и прошедшего времени
вынесен из UI, экран работает через ViewModel и LiveData, обновление времени —
на корутинах.

## Возможности

- Два независимых секундомера на одном экране
- Старт, пауза и сброс для каждого таймера
- Отображение времени в формате `мм:сс:мс` (при превышении часа — `чч:мм:сс`)

## Стек

| Область        | Технологии                              |
|----------------|-----------------------------------------|
| Язык           | Kotlin                                  |
| Архитектура    | MVVM (ViewModel, LiveData)              |
| Асинхронность  | Kotlin Coroutines, Flow                 |
| UI             | ViewBinding, ConstraintLayout, Material |

## Структура

```
app/src/main/java/com/tlenparty/stopwatch/
├── MainActivity.kt
├── data/            # источник времени, калькуляторы состояния и прошедшего времени
├── helpers/         # форматирование времени
├── states/          # StopwatchState: Running / Paused
└── viewmodels/      # StopwatchViewModel, фабрика, StopwatchStateHolder
```

## Сборка

Требуется JDK 11–17 и Android SDK 31.

```bash
./gradlew assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
