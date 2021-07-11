package com.currenttime.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.acceptItems
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Application.configureRouting() {
    routing {
        get("/current-time") {
            val timezone = call.request.queryParameters["timezone"].let {
                when (it) {
                    "CET" -> ZoneId.of("CET")
                    null -> {
                        call.respond(HttpStatusCode.BadRequest, "Query param 'timezone' is required")
                        return@get
                    }
                    else -> {
                        call.respond(HttpStatusCode.BadRequest, "Query param 'timezone' is not supported")
                        return@get
                    }
                }
            }

            val responseFormat = call.request.queryParameters["format"].let {
                when (it) {
                    "ISO" -> DateTimeFormatter.ISO_DATE_TIME
                    "timestamp" -> "timestamp"
                    null -> {
                        call.respond(HttpStatusCode.BadRequest, "Query param 'format' is required")
                        return@get
                    }
                    else -> {
                        call.respond(HttpStatusCode.BadRequest, "Query param 'format' is not supported")
                        return@get
                    }
                }
            }

            val formattedCurrentTime = LocalDateTime.now().atZone(timezone).let {
                when (responseFormat) {
                    is String -> it.toEpochSecond() * 1000
                    is DateTimeFormatter -> it.format(responseFormat)
                    else -> throw Error("Not reached")
                }
            }

            val foo = call.request.acceptItems().firstOrNull()?.value
            println(foo)
            when (call.request.acceptItems().firstOrNull()?.value) {
                "application/json" -> call.respond("{time:\"${formattedCurrentTime}\"}")
                "text/html",
                "text/plain",
                null -> call.respond(formattedCurrentTime.toString())

                else -> throw Error("Not reached")
            }
        }
    }

}
