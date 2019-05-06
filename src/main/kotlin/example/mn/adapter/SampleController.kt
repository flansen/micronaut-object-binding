package example.mn.adapter

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/helloworld")
class SampleController {


    @Get("/working{?data*}")
    fun getWorking(data: DataClass1): String {
        println(data)
        return "Ok"
    }

    @Get("/notworking{?data*}")
    fun getShouldWork(data: DataClass): String {
        println(data)
        return "Ok"
    }


    data class DataClass(
        val str: String
    )

    data class DataClass1(
        val str: String = ""
    )
}