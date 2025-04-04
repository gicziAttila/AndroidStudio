plugins {
    alias(libs.plugins.android.application)
    kotlin("kapt")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.kotlinbasics"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlinbasics"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //hálózat kezelés
    implementation(libs.retrofit)
    //json convert
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    //lista nezet
    implementation(libs.androidx.recyclerview)

    implementation(libs.glide)
    kapt(libs.glide.compiler)
}