# WiFiDirect

A SJSU CS Systems Group Disconnected Data Distribution project under Prof. Ben Reed.

## About:
- Wi-Fi Direct is a Wi-Fi standard for peer-to-peer connections that allows two devices to directly connect with one another. All Android devices have this feature natively but it has to be enabled under Settings. IOS devices currently do not implement Wi-Fi Direct :(.

- This repository contains code cloned from /samples/WiFiDirectDemo folder from https://android.googlesource.com/platform/
The above repository is outdated and would requires tweaking to get it running. Thankfully this person was kind enough to update the dead dependency links to work on current Android devices. https://github.com/yinghuihong/WiFiDirectDemo


## Timeline:
- For Fall 2021 our goal is to get modify this sample and get Wi-Fi Direct working with Signal to allow two Android devices to directly send messages to each other.

## Requirements:
- Either Android Studio or Gradle and JDK installed (Android Studio comes with both automatically)
- Android Smart Phone

## Installation and Running this code :
- Download and install Android Studio https://developer.android.com/studio 
- Clone this repository
```
git clone 
```
- Open up Android Studio. If it is your first time opening up Android Studio once you have finished configuring any settings that pop up when you get to a screen with a button that has an option to create a new project click the Open button next to it instead and open up the repository you just cloned.

- If you already have a project opened up in Android Studio go to the top left under File > New > Import Project and click on the folder containing this repository.

- A window containing the project should pop up and android studio should run the Gradle Sync to build the project automatically. At the top of the window go there should an option Build > Run Generate Sources Gradle Tasks. NOTE: SJSU Wi-Fi as of 9-15-2021 apparently blocks Gradle from syncing and downloading needed dependencies. Recommend doing this part on a non SJSU Wi-Fi network.

- After the Gradle Sync is finished, connect your Android smartphone directly to your computer. On your Android device go to Settings > Developer options and then click to enable USB debugging. If every is working correctly somewhere to the top right of your screen in Android Studio should display your phone name.

- Click the run button next to your phone name and the program should run and display on your phone.

- The app should display but will not display other devices until you give the app location permissions. Swipe out of the app on hold click onto the app and click app info. Give the app location and file permissions.

- Enter the app again and click on the search icon and you should see some Wi-Fi Direct enabled devices around you.

- Congratulations you have have the basic app running!

## Additional Notes :

- Join the Facebook Group for additional documentation about this project https://www.facebook.com/groups/sjsu.cs.ddd
Ask Ben for permission :)

- Android Studio likes to change it's UI every couple of years, so try to find Android Studio tutorials at most 1 -2 years before the time you are currently reading this.


