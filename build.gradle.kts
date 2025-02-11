import protokt.v1.gradle.protokt

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.toasttab.protokt:protokt-gradle-plugin:1.0.0-beta.3")
    }
}

plugins {
    kotlin("jvm") version "2.0.0"
}

apply(plugin = "com.toasttab.protokt")

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

protokt {
    generate {
        all()
    }
}

tasks.withType<JavaCompile> {
    enabled = false
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:4.29.1")
//    implementation("com.toasttab.protokt:protokt-runtime-grpc-jvm:1.0.0-beta.3")
    implementation("io.grpc:grpc-protobuf:1.64.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}
