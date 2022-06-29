# WeatherAPP utilizing OpenWeatherMap API

To use OpenWeatherMap API, you need to obtain an API key. 
Sign up here: https://home.openweathermap.org/users/sign_up

Once you obtain your key, create an environment variable called OWM_API_KEY, assigning it that key you got.

## Features
* Retrieve the weather condition for a certain day
* Access to condition Codes and Icons
** Thunderstorms, Rain, Snow, Drizzle, Clouds, etc.
* The user can change between Imperial, Metric, and Kelvin temperature units.
* This application shows the user weather data by connected to OpenWeatherMap using an API key.
* Implements 'ViewModel' architecture to gracefully deal with transitions in the activity lifecycle.
* This allows the user to rotate the device when viewing the main activity and have that activity recreated, resulting in a new network call to fetch the same weather forecast data. AsyncTask is fetching forecast data again from OpenWeatherMap.
* Hooks up to an HTTP API to fetch forecast data over the internet and using Intents to start new activities.
* It displays a list of forecast data fetched from an HTTP API
* If the user opens a new activity to display the details when a forecast in the list is clicked.
* Adds sharing and mapping actions via implicit intents.
* Saves user preferences with SettingsActivity that implements a users preferences screen u sing PreferenceFragment. 
* The user can change their weather location to display different results.


## Limitations
Currently, the program does not allow you to change current location by longitude and latitude
