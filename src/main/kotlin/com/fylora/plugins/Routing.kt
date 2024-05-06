package com.fylora.plugins

import com.fylora.auth.routes.authenticate
import com.fylora.auth.routes.getUserInfo
import com.fylora.auth.routes.login
import com.fylora.auth.routes.signUp
import com.fylora.auth.security.hashing.HashingService
import com.fylora.auth.security.token.TokenConfig
import com.fylora.auth.security.token.TokenService
import com.fylora.core.user.UserDataSource
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    routing {
        login(hashingService, userDataSource, tokenService, tokenConfig)
        signUp(hashingService, userDataSource)
        authenticate()
        getUserInfo()
    }
}
