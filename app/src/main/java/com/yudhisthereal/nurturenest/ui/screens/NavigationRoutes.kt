package com.yudhisthereal.nurturenest.ui.screens

sealed class NavigationRoutes {

    // Unauthenticated (not logged in) Routes
    sealed class Unauthenticated(val route: String) : NavigationRoutes() {
        data object NavigationRoute : Unauthenticated(route = "unauthenticated")
        data object Login : Unauthenticated(route = "login")
        data object Registration : Unauthenticated(route = "registration")
    }

    // Authenticated (logged in) Routes
    sealed class Authenticated(val route: String) : NavigationRoutes() {
        data object NavigationRoute : Authenticated(route = "authenticated")
        data object Dashboard : Authenticated(route = "Dashboard")
    }
}