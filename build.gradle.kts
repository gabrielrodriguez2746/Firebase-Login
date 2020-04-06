// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra("1.3.71")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Build.androidGradle)
        classpath(Build.kotlinGradle)
        classpath(Build.googleServices)
        "classpath"("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}