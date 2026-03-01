
Keep AccessibilityService

-keep class * extends android.accessibilityservice.AccessibilityService
-keep class com.haunted421.clipbubdeep.** { *; }

Room

-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

Gson

-keepattributes Signature
-keepattributes Annotation
-dontwarn sun.misc.**
-keep class com.google.gson.** { *; }
