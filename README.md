
Text Command Overlay – Improved Version

This folder contains the complete source code for the Text Command Overlay Android app, revised according to the product requirements.

Build Instructions

1. Open the project in Android Studio (Ladybug or later recommended).
2. Sync Gradle (AGP 8.7.2, Gradle 8.10.2).
3. Build and run on a device/emulator with API 26+.

What’s New / Improved

· Modular architecture: Separated concerns into SelectionDetector, FloatingMenuManager, ActionHandler.
· Settings activity: Users can customise auto‑hide timeout, menu radius, container size, enable/disable actions, and set a custom Tasker broadcast action.
· Smarter selection detection: Debounced to avoid flicker, with better node recycling.
· Enhanced radial menu:
  · Position adjusts to stay on screen.
  · Dragging constrained to screen edges.
  · Overshoot interpolator for smoother expansion.
  · Buttons are tappable only when fully expanded.
· Preferences are used throughout (radius, size, timeout).
· Vector drawables for all icons (no missing PNGs).
· ProGuard rules keep the AccessibilityService class.
· Removed obsolete backup files (gradlew.bak, etc.).

Files Not Included (But Required)

· App icon – You must provide your own launcher icons in res/mipmap-* folders (ic_launcher.png / ic_launcher_round.png). The manifest references these.
· Signed release keystore – For generating a signed APK, you need a keystore.

Nuances & Notes

· The service must be enabled in Accessibility settings (the main activity guides the user).
· The radial menu auto‑hides after the configured timeout (default 15s). Set to 0 to disable auto‑hide.
· Tasker integration: by default, broadcasts an intent with action com.haunted421.textcommandoverlay.TEXT_SELECTED and extras text, source_package, timestamp. You can change the action in settings.
· If you disable an action in settings, the corresponding button will still appear (for now) – future enhancement could hide it entirely.
· The SelectionDetector uses a simple debounce; if you encounter missed selections in some apps, you may need to adjust debounceMs or add more event types.
· Tested on Android 8.0–15; if you find issues on specific devices, please report.

Building the APK

To generate a release APK:

```bash
./gradlew assembleRelease
```

The APK will be at app/build/outputs/apk/release/app-release.apk. Remember to sign it with your own keystore before distribution.

---

Enjoy the enhanced Text Command Overlay!
