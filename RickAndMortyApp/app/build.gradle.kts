plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {
    namespace = "com.example.pokeapi"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.pokeapi"
        minSdk = 30
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    buildToolsVersion = "35.0.0"
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Hilt Dependencies
    implementation ("com.google.dagger:hilt-android:2.56.1")
    kapt ("com.google.dagger:hilt-compiler:2.56.1")
    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.56.1")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.56.1")
    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.56.1")
    kaptTest ("com.google.dagger:hilt-compiler:2.56.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.51.1")
    // Other dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("androidx.compose.material:material-icons-extended-android:1.3.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
}
kapt {
    correctErrorTypes = true
}