pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = ("Playme")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    ":app",
    ":data",
    ":model",
    ":base",
    ":domain",
    ":common:compose",
    ":common:resources",
    ":ui:onboarding",
)
include(":ui:songs")
include(":common:imageloading")
