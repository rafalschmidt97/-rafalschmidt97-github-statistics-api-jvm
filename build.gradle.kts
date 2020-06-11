import com.github.spotbugs.snom.SpotBugsExtension

plugins {
  java
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  id("com.github.spotbugs") version "4.3.0" apply false
}

subprojects {
  // Basics
  group = "com.rafalschmidt.github"
  version = "1.0.0"

  apply(plugin = "java")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "java-library")

  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    compileOnly("org.projectlombok:lombok:1.18.10")
    annotationProcessor("org.projectlombok:lombok:1.18.10")
  }

  // Spring boot DI context
  dependencyManagement {
    dependencies {
      dependency("org.springframework.boot:spring-boot-dependencies:2.3.0.RELEASE")
    }
  }

  // Linting
  apply(plugin = "checkstyle")
  apply(plugin = "com.github.spotbugs")
  apply(plugin = "pmd")

  configure<CheckstyleExtension> {
    toolVersion = "8.33"
    configFile = file("${rootDir}/tools/lint/checkstyle.xml")
  }

  tasks.withType<Checkstyle> {
    reports {
      xml.isEnabled = false
      html.isEnabled = true
    }
  }

  configure<SpotBugsExtension> {
    toolVersion.set("4.0.4")
    excludeFilter.set(file("${rootDir}/tools/lint/spotbugs-exclude.xml"))
  }

//  tasks.withType<SpotBugsTask> { TODO: enable html reports
//    reports {
//      this {
//        "xml" {
//          enabled = true
//        }
//        "html" {
//          enabled = true
//        }
//      }
//    }
//  }

  configure<PmdExtension> {
    toolVersion = "6.24.0"
    ruleSets = listOf()
    incrementalAnalysis.set(true)
    ruleSetFiles = files("${rootDir}/tools/lint/pmd.xml")
  }

  tasks.withType<Pmd> {
    reports {
      xml.isEnabled = false
      html.isEnabled = true
    }
  }
}
