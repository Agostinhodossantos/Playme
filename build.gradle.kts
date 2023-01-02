
buildscript {
    repositories {
        google()
        mavenCentral()

//        if (!libs.versions.compose.snapshot.get().endsWith("SNAPSHOT")) {
//            maven { url = uri("https://androidx.dev/snapshots/builds/${libs.versions.compose.snapshot.get()}/artifacts/repository/") }
//        }
    }
    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
    }
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.43.0"
    id("nl.littlerobots.version-catalog-update") version "0.7.0"
}
//
//task installGitHook(type: Copy) {
//    def suffix = "windows" //macos
////    if (Os.isFamily(Os.FAMILY_WINDOWS)) {
////        suffix = "windows"
////    }
//    from new File(rootProject.rootDir, "scripts/pre-commit-$suffix")
//    into { new File(rootProject.rootDir, '.git/hooks') }
//    rename("pre-commit-$suffix", 'pre-commit')
//    fileMode 0775
//}


//task("installGitHook") {
//    var suffix = "windows"
//    val target = File(rootProject.rootDir, '.git/hooks')
//
//}

//apply("${project.rootDir}/buildscripts/toml-updater-config.gradle")

//tasks.getByPath(':app:preBuild').dependsOn installGitHook