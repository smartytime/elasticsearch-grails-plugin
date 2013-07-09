grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.plugin.location."elasticsearch" = "../../../"

//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime "org.hamcrest:hamcrest-core:1.3"
        runtime "org.elasticsearch:elasticsearch:0.90.1"
        runtime "org.elasticsearch:elasticsearch-lang-groovy:1.2.0"
        runtime 'com.spatial4j:spatial4j:0.3'
        test("org.spockframework:spock-grails-support:0.7-groovy-2.0"){
//            export = false
        }

    }
    plugins {
        runtime ":hibernate:$grailsVersion"
        build (":release:2.2.1", ":rest-client-builder:1.0.3") {
            export = false
        }
        test(":spock:0.7") {
//            export = false
            exclude "spock-grails-support"
        }
    }
}
