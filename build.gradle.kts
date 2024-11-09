plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.0" // Use the latest version
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0")
}

tasks.test {
    useJUnitPlatform()
}

detekt {
    config.from("$projectDir/detekt.yml")
    autoCorrect = true
}