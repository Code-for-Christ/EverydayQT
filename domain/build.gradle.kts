plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(CoroutinesConfig.CORE)

    DaggerHiltConfig.run {
        implementation(CORE)
        kapt(COMPILER)
    }

    TestConfig.run {
        testRuntimeOnly(ENGINE)
        testImplementation(JUPITER)
        testImplementation(ASSERTJ)
        testImplementation(MOCKK)
    }
}

tasks.test {
    useJUnitPlatform()
}
