plugins {
    id("com.android.application")
    kotlin("android")
}

apply(from = "$rootDir/buildSrc/android.kts")

android {

    defaultConfig {
        applicationId = "com.firebase.login"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":features:login"))
    implementation(project(":modules:core"))
    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Android.ktxCore)
    implementation(Libraries.Android.appCompat)
    implementation(Libraries.Android.activity)
    implementation(Libraries.Android.constraintLayout)
    implementation(Libraries.Firebase.firebaseAuth)
    implementation(Libraries.Firebase.playServiceAuth)
    implementation(Libraries.Externals.timber)

    testImplementation(Libraries.Test.junit4)

    androidTestImplementation(Libraries.Test.testRunner)
    androidTestImplementation(Libraries.Test.espresso)

}