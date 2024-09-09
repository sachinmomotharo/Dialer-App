Dialer Application
Overview
This project is a simple dialer application developed for Android devices, created as part of Assignment 1 for the course 159.336 - Mobile Application Development . The app allows users to dial a phone number and place a call using the device's phone functionality.

Features
Number Display: A text display to show the phone number being dialed.
Keypad: A keypad with 12 keys (0-9, *, and #), allowing the user to input a phone number.
Delete Button: Removes the last digit or character from the phone number.
Call Button: Places a phone call using the entered number.
Screen Rotation Handling: The app maintains its state when the device is rotated.
Multiple Screen Sizes: The layout is compatible with different screen sizes and resolutions.
Dial Intents: The app accepts ACTION_DIAL intents, allowing users to dial phone numbers from other applications.
Technologies Used
Programming Language: Java
Android API Level: 24 and above
Development Environment: Android Studio
Permissions
The app requests the following permission at runtime:

Manifest.permission.CALL_PHONE: Required to place phone calls from the application.
Instructions to Run
Clone this repository to your local machine:
bash
Copy code
git clone https://github.com/yourusername/dialerapp.git
Open the project in Android Studio.
Ensure that the necessary dependencies are installed and synced in the project.
Run the app on an Android device or emulator with API level 24 or above.
Testing the Application
To test the app's ACTION_DIAL intent functionality, run the following command in an adb shell:

bash
Copy code
adb shell am start -a android.intent.action.DIAL -d "tel:094140800"
This will launch the dialer with the provided number.

Project Structure
MainActivity.java: The main activity that handles the UI and call functionality.
activity_main.xml: Defines the layout of the dialer UI.
AndroidManifest.xml: Contains the app's permissions and intent filters.
License
This project is licensed under the MIT License - see the LICENSE file for details.

