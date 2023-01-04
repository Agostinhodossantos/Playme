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
//    ":data",
//    ":model",
//    ":base",
//    ":domain",
//    ":data",
//    ":common:imageloading",
    ":common:compose",
    ":common:resources",
    ":ui:onboarding",
//    ":ui:discover",
//    ":ui:search",
//    ":ui:bookmark",
//    ":ui:details",
//    ":ui:settings"
)

include(":domain")
include(":data")
include(":model")
include(":base")
