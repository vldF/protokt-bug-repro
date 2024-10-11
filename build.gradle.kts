plugins {
    kotlin("jvm") version "2.0.0"
    id("com.toasttab.protokt") version "1.0.0-beta.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

protokt {
    generate {
        types = true
        descriptors = true
        grpcDescriptors = true
        grpcKotlinStubs = true
    }
}

tasks.withType<JavaCompile> {
    enabled = false
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.21.7")
    //implementation("com.toasttab.protokt:protokt-runtime-grpc-jvm:1.0.0-beta.2")
    implementation("io.grpc:grpc-protobuf:1.64.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
}
