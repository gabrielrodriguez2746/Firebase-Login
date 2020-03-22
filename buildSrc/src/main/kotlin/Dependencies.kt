const val kotlin = "1.3.21"

object Build {

    private object Versions {
        const val buildTools = "4.0.0-beta03"
        const val googleServices = "4.3.3"
    }

    const val androidGradle = "com.android.tools.build:gradle:${Versions.buildTools}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Libraries {

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin"
    }

    object Android {
        private object Versions {
            const val ktx = "1.2.0"
            const val jetPack = "1.1.0"
            const val constraintLayout = "1.1.3"
        }

        const val appCompat = "androidx.appcompat:appcompat:${Versions.jetPack}"
        const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    object Test {
        private object Versions {
            const val junit4 = "1.1.1"
            const val testRunner = "1.1.01"
            const val espresso = "3.2.0"
        }

        const val junit4 = "androidx.test.ext:junit:${Versions.junit4}"
        const val testRunner = "androidx.test:runner:${Versions.testRunner}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }


}

