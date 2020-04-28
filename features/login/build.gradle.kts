plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "$rootDir/buildSrc/android.kts")

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
