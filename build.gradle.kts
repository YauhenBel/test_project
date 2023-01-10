plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.3"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

var kotlinVersion = "1.6.21"


dependencies {
    kapt(platform("io.micronaut:micronaut-bom:3.7.4"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.serde:micronaut-serde-processor")
    kapt("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("io.micronaut.mongodb:micronaut-mongo-reactive")
    implementation("io.micronaut.mongodb:micronaut-mongo-sync")
    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.projectreactor:reactor-core:3.5.1")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    implementation("io.micronaut.serde:micronaut-serde-bson")
    implementation("io.micronaut.security:micronaut-security-session")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")


}


application {
    mainClass.set("com.example.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}


tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

tasks {
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

micronaut {
    version.set("3.7.4")
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations.add("com.example.*")
    }
}



