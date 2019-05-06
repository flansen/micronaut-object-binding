package example.mn.adapter

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class SampleControllerTest : Spek({
    describe("PrometheusController Suite") {
        val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: RxStreamingHttpClient = embeddedServer.applicationContext.createBean(
            RxStreamingHttpClient::class.java,
            embeddedServer.url
        )

        it("working endpoint works as expected") {
            val req = HttpRequest.GET<Any>("/helloworld/working?str=1")
            val res = client.retrieve(req).blockingFirst()
            assert(res == "Ok")
        }

        it("not working endpoint should work") {
            val req = HttpRequest.GET<Any>("/helloworld/notworking?str=1")
            val res = client.retrieve(req).blockingFirst()
            assert(res == "Ok")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})