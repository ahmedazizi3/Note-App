# NoteApp

A clean Android note-taking app built with Kotlin, Jetpack Compose, Room, and Hilt.

## About

NoteApp is a native Android application that helps users create, edit, delete, and store notes locally on their device. It uses a modern Jetpack Compose UI, Material 3 components, Room Database for persistence, and Hilt for dependency injection.

## Problem It Solves

Many note apps are either too heavy or require online accounts. NoteApp focuses on a simple offline-first experience where users can quickly save their thoughts, update them later, and keep everything stored locally on the device.

## Demo

[![Watch the NoteApp demo](https://img.youtube.com/vi/oQVuAbQ4lEo/hqdefault.jpg)](https://www.youtube.com/shorts/oQVuAbQ4lEo)

## Screenshots

| Notes | Add Note | Edit Note |
|---|---|---|
| ![Notes screen](https://github.com/user-attachments/assets/f23d2a11-4488-4c6b-b5fb-3b77eeeb4cbe) | ![Add note screen](https://github.com/user-attachments/assets/9a0565ae-b34d-458d-865b-cd2525f865c6) | ![Edit note screen](https://github.com/user-attachments/assets/b69de932-4339-4baf-add9-c381e43313b7) |

| Note Details | Delete Note | Splash / App UI |
|---|---|---|
| ![Note details](https://github.com/user-attachments/assets/ee9a3e2b-72d7-4f62-8417-3a35d2a5933f) | ![Delete note](https://github.com/user-attachments/assets/591fdc79-6d11-482a-b530-164c51d26cbb) | ![App UI](https://github.com/user-attachments/assets/2e4f1679-e891-4166-8e52-30bf431db96a) |

## Features

- Create notes with a title and details.
- View saved notes in a clean Compose list.
- Edit existing notes.
- Delete notes from the notes list.
- Store notes locally using Room Database.
- Navigate between screens with Navigation Compose.
- Manage UI state with ViewModel, Coroutines, and Flow.
- Use dependency injection with Hilt.
- Material 3 interface with a splash screen and custom app icon.

## Tech Stack

| Category | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose, Material 3 |
| Architecture | MVVM-style structure |
| Database | Room |
| Dependency Injection | Hilt / Dagger |
| Async | Kotlin Coroutines, Flow |
| Navigation | Navigation Compose |
| Splash Screen | AndroidX Splash Screen |
| Build System | Gradle Kotlin DSL |

## Release

Download the APK directly:

[Download NoteApp v1.0.1 APK](https://github.com/ahmedazizi3/Note-App/releases/download/v1.0.1/app-release-unsigned.apk)

Release page:

[GitHub Release v1.0.1](https://github.com/ahmedazizi3/Note-App/releases/tag/v1.0.1)

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
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
