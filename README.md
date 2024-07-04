# Find Weather

Find Weather is an Android application designed to provide accurate and up-to-date weather information. The app fetches weather data using the OpenWeather API and displays it in a user-friendly interface. It includes a search option that allows users to find weather conditions for different locations. 

## Features

- **Weather Information**: Displays current weather conditions, including temperature, wind speed, humidity, sea level, and more.
- **Search Functionality**: Users can search for weather information by entering a city name.
- **User-friendly Interface**: Simple and intuitive design for ease of use.
- **Retrofit API Integration**: Utilizes the Retrofit library to handle API requests and responses efficiently.

## Screenshots

![Find Weather](https://github.com/Garv1Gyanani/FindWeather/assets/130121347/c0aa6a59-72aa-403a-a4d3-7dde315ab12a)


## Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/Garv1Gyanani/findweather.git
    ```

2. **Open the project in Android Studio:**

    - Go to `File -> Open` and select the project directory.

3. **Build and run the app:**

    - Connect your Android device or start an emulator.
    - Click on the `Run` button in Android Studio.

## Usage

1. **Launch the app:**

    - Open the Find Weather app on your Android device.

2. **Search for a location:**

    - Enter the name of the city in the search bar and tap the search icon.

3. **View weather details:**

    - The app will display the current weather conditions, including temperature, wind speed, humidity, and sea level for the searched location.

## Dependencies

- **Retrofit**: For making network requests to the OpenWeather API.
- **Gson**: For JSON parsing.
- **Material Design Components**: For UI components.

## API Key

To use the Find Weather app, you need an API key from OpenWeather. Follow these steps to get your API key:

1. **Sign up at [OpenWeather](https://home.openweathermap.org/users/sign_up)**.
2. **Create an API key**.
3. **Add your API key to the project**:
    - Open `gradle.properties` file in the project.
    - Add the following line with your API key:
        ```properties
        OPENWEATHER_API_KEY=your_api_key_here
        ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- **OpenWeather**: For providing the weather data API.
- **Retrofit**: For making API integration simple and efficient.
- **Gson**: For JSON parsing.
- **Android Studio**: For providing a powerful development environment.

---

Developed by [Garv Gyanani](https://github.com/Garv1Gyanani).
