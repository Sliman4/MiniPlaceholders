plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

dependencies {
    compileOnly(project(":miniplaceholders-common"))
    compileOnly(project(":miniplaceholders-api"))
    compileOnly(project(":miniplaceholders-connect"))
    paperDevBundle("1.18.2-R0.1-SNAPSHOT")
}

val pluginVersion: String = version as String

bukkit {
    name = "MiniPlaceholders"
    main = "me.dreamerzero.miniplaceholders.paper.PaperPlugin"
    apiVersion = "1.18"
    website = "https://github.com/4drian3d/MiniPlaceholders"
    authors = listOf("4drian3d")
    version = pluginVersion
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()

        options.release.set(17)
    }
}

