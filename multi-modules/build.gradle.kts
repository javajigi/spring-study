import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.21"
	id("org.springframework.boot") version "2.1.4.RELEASE" apply false
}

allprojects {
	group = "nextstep"
	version = "1.0.0"

	repositories {
		jcenter()
	}
}

subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	dependencies {
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	tasks.withType<KotlinCompile>().configureEach {
		println("Configuring $name in project ${project.name}...")
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}
