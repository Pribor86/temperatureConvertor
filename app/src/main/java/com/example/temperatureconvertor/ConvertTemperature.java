package com.example.temperatureconvertor;

public class ConvertTemperature {
    // converts to celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    // converts to fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
