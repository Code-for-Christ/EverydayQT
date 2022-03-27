// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(KotlinConfig.GRADLE_PLUGIN)
        classpath(AndroidConfig.BUILD_TOOLS)
        classpath(DaggerHiltConfig.ANDROID_GRADLE_PLUGIN)
        classpath(AuthConfig.GOOGLE_SERVICES)
        classpath(EtcConfig.LINT)
        classpath(TestConfig.ANDROID_JUNIT5)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
