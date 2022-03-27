plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.jinyeob.eqt"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeConfig.COMPOSE_VERSION
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(KotlinConfig.STDLIB)

    CoroutinesConfig.run {
        implementation(CORE)
        implementation(ANDROID)
    }

    DaggerHiltConfig.run {
        implementation(ANDROID)
        kapt(COMPILER)
    }

    ComposeConfig.run {
        implementation(UI)
        implementation(MATERIAL)
        implementation(UI_TOOLING)
        implementation(RUNTIME_LIVEDATA)
        implementation(ACTIVITY)
    }

    AndroidConfig.run {
        implementation(CORE)
        implementation(APPCOMPAT)
        implementation(CONSTRAINTLAYOUT)
        implementation(ACTIVITY)
        implementation(FRAGMENT)
        implementation(LEGACY_SUPPORT)
        implementation(CARD_VIEW)
        implementation(RECYCLER_VIEW)
        implementation(VIEW_PAGER)
    }

    GoogleConfig.run {
        implementation(MATERIAL)
        implementation(FLEXBOX)
        implementation(PLAY_CORE)
        implementation(PLAY_CORE_KTX)
    }

    AuthConfig.run {
        implementation(GOOGLE_SERVICES_AUTH)
    }

    GlideConfig.run {
        implementation(GLIDE)
        kapt(COMPILER)
    }

    NavigationConfig.run {
        implementation(FRAGMENT)
        implementation(UI)
        implementation(RUNTIME)
    }

    HiltLifecycleConfig.run {
        implementation(VIEW_MODEL)
        kapt(COMPILER)
    }

    LifecycleConfig.run {
        implementation(RUNTIME)
        implementation(LIVEDATA)
        implementation(VIEW_MODEL)
        implementation(SAVED_STATE)
    }

    IntuitConfig.run {
        implementation(SDP)
        implementation(SSP)
    }
}
