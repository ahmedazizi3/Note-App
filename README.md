# Note

Note is a native Android note-taking app built with Kotlin and Jetpack Compose. It lets users create, view, edit, and delete notes, with note data stored locally on the device.

## Links

- Download the APK from the [v1.0.1 GitHub release](https://github.com/ahmedazizi3/Note-App/releases/tag/v1.0.1).
- Watch the app demo on [YouTube Shorts](https://www.youtube.com/shorts/oQVuAbQ4lEo).

## Features

- Create notes with a title and details.
- View saved notes in a Compose `LazyColumn`.
- Tap a note to edit it.
- Delete notes from the note list.
- Local persistence with Room.
- Dependency injection with Hilt.
- Screen navigation with Navigation Compose.
- Material 3 UI with a splash screen and custom app icon assets.

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- AndroidX Navigation Compose
- Room
- Hilt / Dagger
- Kotlin coroutines and Flow
- AndroidX Splash Screen
- Gradle Kotlin DSL

## Project Structure

```text
.
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/azizi/ahmed/noteapp/
│       │   │   ├── MainActivity.kt
│       │   │   ├── NoteApplication.kt
│       │   │   ├── packages/
│       │   │   │   ├── components/
│       │   │   │   ├── data/
│       │   │   │   ├── di/
│       │   │   │   ├── model/
│       │   │   │   ├── navigation/
│       │   │   │   ├── repository/
│       │   │   │   ├── screens/
│       │   │   │   ├── util/
│       │   │   │   └── viewModel/
│       │   │   └── ui/theme/
│       │   └── res/
│       ├── androidTest/
│       └── test/
├── gradle/libs.versions.toml
├── build.gradle.kts
└── settings.gradle.kts
```

## Requirements

- Android Studio with Android Gradle Plugin 8.8 support.
- JDK 17 or newer to run Gradle/AGP. The app source is configured for Java 11 compatibility.
- Android SDK for compile SDK 36.

## Getting Started

1. Open the project in Android Studio.
2. Let Gradle sync dependencies.
3. Select the `app` run configuration.
4. Run the app on an emulator or physical Android device.

From the command line, you can build a debug APK with:

```powershell
.\gradlew.bat assembleDebug
```

## Notes About Local Files

Signing keys, APK/AAB outputs, Gradle build folders, IDE state, local SDK paths, and logs are ignored by Git. Keystore files such as `*.jks` should be stored outside the repository and never committed.
