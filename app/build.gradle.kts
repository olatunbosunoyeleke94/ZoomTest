plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.zoomtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.zoomtest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Add sourceSets to point to the correct path
    sourceSets {
        getByName("main") {
            manifest.srcFile("C:\\Users\\olatunbosun.oyeleke\\AndroidStudioProjects\\ZoomTest\\app\\src\\main\\AndroidManifest.xml") // Correct path to the AndroidManifest.xml file
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Add jPOS dependency
    implementation(libs.jpos) // Regular implementation for both debug and release builds
}
