package example.mn

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.mn")
                .mainClass(Application.javaClass)
                .start()
    }
}