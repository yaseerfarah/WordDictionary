# Word Dictionary App

This is an Android application built with Kotlin and Jetpack Compose that allows users to search for word definitions and view their search history. It leverages the [Free Dictionary API](https://dictionaryapi.dev/) to fetch word information.

## Features

- **Word Search:** Users can search for words and view their definitions, including phonetics, origin, and different meanings.
- **Search History:** The app maintains a history of searchedwords, allowing users to quickly revisit previous searches.
- **Offline Support:** Word definitions are cached locally, enabling offline access to previously viewed words.
- **Modern UI:** The app is built with Jetpack Compose, providing a sleek and modern user interface.
- **Clean Architecture:** The project follows clean architecture principles, separating concerns into distinct layers for maintainability and testability.

## Technologies Used

- **Kotlin:** The primary programming language for the app.
- **Jetpack Compose:** Modern UI toolkit for building native Android UIs.
- **Hilt:** Dependency injection framework for managing dependencies.
- **Retrofit:** Networking library for making API calls.
- **Room:** Persistence library for storing data locally.
- **DataStore:** Preferences storage solution for storing small amounts of data.
- **Coroutines:** For asynchronous programming and managing background tasks.
- **Flow:** For handling streams of data.
- **MockK:** Mocking library for unit testing.
- **Turbine:** Library for testing Kotlin Flows.

## Project Structure

The project follows a clean architecture approach with a feature-based modularization strategy. This enhances code organization, scalability, and maintainability. Here's a breakdown of the modules:

- **`app`:** The main application module. It orchestrates the different features and handles app-level dependencies and configurations.
- **`common`:** Contains common components and utilities shared across multiple features. It's further divided into:
    - **`common:data`:** Data layer components like data sources, repositories, and networking utilities.
    - **`common:domain`:** Domain layer components like use cases, entities, and business logic.
    - **`common:presentation`:** Presentation layer components like UI themes, composables, and navigation utilities.
- **`features`:** This directoryhouses the individual feature modules, each structured with its own presentation, domain, and data layers:
   
    - **`features:search`:**
        - `presentation`: UI components for displaying search history.
        - `domain`: Use cases for retrieving and managing search history.
        - `data`: Repository for accessing and storing search history data.
   
 
   - **`features:details`:**
        - `presentation`: UI components for word search result, results display, etc.
        - `domain`: Use cases for fetching word definitions, managing search history, etc.
        - `data`: Repositories for interacting with the API and local database for word data.
          
   - **`features:[other_feature]`:** (Add more features as needed, following the same structure)

This modular structure promotes separation of concerns, making the codebase easier to understand, test, and maintain as the project grows.

## Getting Started

1. **Clone the repository:**
 ```bash

git clone https://github.com/yaseerfarah/WordDictionary.git

```
 2. **Open the project in Android Studio:**
   - Import the project into Android Studio.
   - Build and run the app on an emulator or physical device.

## Running Tests

- **Unit Tests:**
   - Navigate to the `app/src/test` directory.
   - Run the tests using the Android Studio test runner.
 

 # Screens:
 
 * Search Screen

  <img src="images/search.jpeg" width="250" height="580">
  
   * Details Screen
  
  <img src="images/details.jpeg" width="250" height="580">
  


## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
 

  
  
  
  
  
