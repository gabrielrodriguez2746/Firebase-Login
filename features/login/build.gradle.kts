plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Android.ktxCore)
    implementation(Libraries.Android.appCompat)
    implementation(Libraries.Android.constraintLayout)
    implementation(Libraries.Android.viewModelLifecycle)
    implementation(Libraries.Firebase.firebaseAuth)
    implementation(Libraries.Firebase.playServiceAuth)
    implementation(Libraries.Coroutines.core)
    implementation(Libraries.Externals.timber)

    testImplementation(Libraries.Test.junit4)

    androidTestImplementation(Libraries.Test.testRunner)
    androidTestImplementation(Libraries.Test.espresso)

}
