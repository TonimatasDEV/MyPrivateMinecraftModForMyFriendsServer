plugins {
    id("java-library")
    id("maven-publish")
    id("idea")
    id("net.neoforged.moddev") version "2.0.116"
}

val modVersion: String by extra
val neoVersion: String by extra
val parchmentMappingsVersion: String by extra
val parchmentMinecraftVersion: String by extra
val minecraftVersion: String by extra
val neoVersionRange: String by extra

version = modVersion
group = "dev.tonimatas"

repositories {
    mavenLocal()
}

base {
    archivesName = "MyFriendsMod"
}

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

neoForge {
    version = neoVersion

    parchment {
        mappingsVersion = parchmentMappingsVersion
        minecraftVersion = parchmentMinecraftVersion
    }

    // accessTransformers.add("src/main/resources/META-INF/accesstransformer.cfg")

    runs {
        create("client") {
            client()
            systemProperty("neoforge.enabledGameTestNamespaces", "myfriendsmod")
        }

        create("server") {
            server()
            programArgument("--nogui")
            systemProperty("neoforge.enabledGameTestNamespaces", "myfriendsmod")
        }

        create("gameTestServer") {
            type = "gameTestServer"
            systemProperty("neoforge.enabledGameTestNamespaces", "myfriendsmod")
        }

        create("data") {
            data()
            programArguments.addAll("--mod", "myfriendsmod", "--all", "--output", file("src/generated/resources/").absolutePath, "--existing", file("src/main/resources/").absolutePath)
        }

        configureEach {
            systemProperty("forge.logging.markers", "REGISTRIES")
            logLevel = org.slf4j.event.Level.INFO
        }
    }

    mods {
        create("myfriendsmod") {
            sourceSet(sourceSets.main.get())
        }
    }
}

sourceSets.main.get().resources.srcDir("src/generated/resources")

dependencies {
    
}

tasks.processResources {
    var replaceProperties = mapOf("minecraftVersion" to minecraftVersion, "neoVersionRange" to neoVersionRange, "modVersion" to modVersion)
    inputs.properties(replaceProperties)
    
    filesMatching("META-INF/neoforge.mods.toml") {
        expand(replaceProperties)
    }
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
