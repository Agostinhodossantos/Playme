plugins {
    id("java-library")
    kotlin("jvm")
    id("kotlin-kapt")
}

dependencies {
    implementation(libs.moshi)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
