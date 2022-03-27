object KotlinConfig {
    private const val KOTLIN_VERSION = "1.5.31"

    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
    const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
}

object CoroutinesConfig {
    private const val COROUTINES_VERSION = "1.5.1"

    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
}

object DaggerHiltConfig {
    private const val HILT_VERSION = "2.38.1"

    const val ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
    const val ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val COMPILER = "com.google.dagger:hilt-compiler:$HILT_VERSION"
    const val CORE = "com.google.dagger:hilt-core:$HILT_VERSION"
}

object RoomConfig {
    private const val ROOM_VERSION = "2.4.1"

    const val RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
    const val COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    const val KTX = "androidx.room:room-ktx:$ROOM_VERSION"
    const val TESTING = "androidx.room:room-testing:$ROOM_VERSION"
}

object NetworkConfig {
    private const val RETROFIT_VERSION = "2.9.0"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.3"
}

object ConverterConfig {
    private const val MOSHI_VERSION = "1.12.0"

    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"
}

object TestConfig {
    private const val JUNIT5_VERSION = "5.8.2"

    const val JUPITER = "org.junit.jupiter:junit-jupiter:$JUNIT5_VERSION"
    const val ENGINE = "org.junit.vintage:junit-vintage-engine:$JUNIT5_VERSION" // junit4 지원
    const val API = "org.junit.jupiter:junit-jupiter-api:$JUNIT5_VERSION"
    const val JUNIT4 = "junit:junit:4.13.2"
    const val TRUTH = "com.google.truth:truth:1.1.3"
    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val ANDROID_JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
    const val ANDROID_TEST_CORE = "de.mannodermaus.junit5:android-test-core:1.2.2"
    const val ANDROID_TEST_RUNNER = "de.mannodermaus.junit5:android-test-runner:1.2.2"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.3"
    const val ASSERTJ = "org.assertj:assertj-core:3.22.0"
    const val MOCKK = "io.mockk:mockk:1.12.3"
}

object AndroidConfig {
    const val BUILD_TOOLS = "com.android.tools.build:gradle:7.1.2"
    const val CORE = "androidx.core:core-ktx:1.7.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.1"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:1.4.1"
    const val ACTIVITY = "androidx.activity:activity-compose:1.4.0"
    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:1.0.0"
    const val VIEW_PAGER = "androidx.viewpager2:viewpager2:1.0.0"
    const val CARD_VIEW = "androidx.cardview:cardview:1.0.0"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.2.1"
}

object ComposeConfig {
    const val COMPOSE_VERSION = "1.0.5"

    const val UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
    const val ACTIVITY = "androidx.activity:activity-compose:1.3.1"
}

object HiltLifecycleConfig {
    private const val HILT_LIFECYCLE_VERSION = "1.0.0-alpha03"

    const val VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:$HILT_LIFECYCLE_VERSION"
    const val COMPILER = "androidx.hilt:hilt-compiler:$HILT_LIFECYCLE_VERSION"
}

object LifecycleConfig {
    private const val LIFECYCLE_VERSION = "2.4.1"

    const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
    const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$LIFECYCLE_VERSION"
}

object NavigationConfig {
    private const val NAVIGATION_VERSION = "2.3.5"

    const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val UI = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
    const val RUNTIME = "androidx.navigation:navigation-runtime:$NAVIGATION_VERSION"
}

object GoogleConfig {
    const val MATERIAL = "com.google.android.material:material:1.5.0"
    const val FLEXBOX = "com.google.android.flexbox:flexbox:3.0.0"
    const val PLAY_CORE = "com.google.android.play:core:1.10.3"
    const val PLAY_CORE_KTX = "com.google.android.play:core-ktx:1.8.1"
}

object AuthConfig {
    const val GOOGLE_SERVICES = "com.google.gms:google-services:4.3.10"
    const val GOOGLE_SERVICES_AUTH = "com.google.android.gms:play-services-auth:20.1.0"
}

object GlideConfig {
    private const val GLIDE_VERSION = "4.13.0"

    const val GLIDE = "com.github.bumptech.glide:glide:$GLIDE_VERSION"
    const val COMPILER = "com.github.bumptech.glide:compiler:$GLIDE_VERSION"
}

object IntuitConfig {
    private const val INTUIT_VERSION = "1.0.6"
    const val SDP = "com.intuit.sdp:sdp-android:$INTUIT_VERSION"
    const val SSP = "com.intuit.ssp:ssp-android:$INTUIT_VERSION"
}

object WorkConfig{
    private const val WORK_VERSION ="2.7.1"
    const val RUNTIME = "androidx.work:work-runtime:$WORK_VERSION"
    const val RUNTIME_KTX = "androidx.work:work-runtime-ktx:$WORK_VERSION"
    const val HILT = "androidx.hilt:hilt-work:1.0.0-alpha01"
}

object EtcConfig {
    const val LINT = "org.jlleitschuh.gradle:ktlint-gradle:10.0.0"
    const val EVENTBUS = "org.greenrobot:eventbus:3.2.0"
    const val CIRCLE_IMAGE_VIEW = "de.hdodenhof:circleimageview:3.1.0"
    const val CIRCLE_PROGRESS = "com.github.lzyzsd:CircleProgress:v1.2.4"
    const val LOTTIE = "com.airbnb.android:lottie:3.0.7"
    const val MP_ANDROID_CHART = "com.github.PhilJay:MPAndroidChart:v3.1.0"
    const val SHIMMER = "com.facebook.shimmer:shimmer:0.5.0"
}
