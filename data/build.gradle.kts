plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 24
        targetSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(":domain"))

    implementation(CoroutinesConfig.CORE)

    DaggerHiltConfig.run {
        implementation(ANDROID)
        kapt(COMPILER)
    }

    NetworkConfig.run {
        api(RETROFIT)
        api(CONVERTER_MOSHI)
        implementation(LOGGING_INTERCEPTOR)
    }

    RoomConfig.run {
        implementation(KTX)
        implementation(RUNTIME)
        kapt(COMPILER)
        testImplementation(TESTING)
    }

    ConverterConfig.run {
        api(MOSHI_KOTLIN)
        kapt(MOSHI_KOTLIN_CODEGEN)
    }

    TestConfig.run {
        testRuntimeOnly(ENGINE)
        testImplementation(JUPITER)
        testImplementation(ASSERTJ)
        testImplementation(MOCKK)
        testImplementation(MOCK_WEB_SERVER)
    }
}