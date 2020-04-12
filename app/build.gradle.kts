plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = "com.firebase.login"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding {
        isEnabled = true
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":login"))
    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Android.ktxCore)
    implementation(Libraries.Android.appCompat)
    implementation(Libraries.Android.activity)
    implementation(Libraries.Android.constraintLayout)
    implementation(Libraries.Firebase.firebaseAuth)
    implementation(Libraries.Firebase.playServiceAuth)

    testImplementation(Libraries.Test.junit4)

    androidTestImplementation(Libraries.Test.testRunner)
    androidTestImplementation(Libraries.Test.espresso)

}