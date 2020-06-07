plugins {
  java
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

subprojects {
  group = "com.rafalschmidt.github"
  version = "1.0.0"

  apply(plugin= "java")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "java-library")

  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
  }

  dependencyManagement {
    dependencies {
      dependency("org.springframework.boot:spring-boot-dependencies:${property("springVersion")}")
    }
  }
}
