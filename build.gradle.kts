plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("dev.detekt") version "2.0.0-alpha.2"
}

kotlin {
    jvmToolchain(25)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")
}

tasks.test {
    useJUnitPlatform()
}

detekt {
    config.from("$projectDir/detekt.yml")
    autoCorrect = true
}
