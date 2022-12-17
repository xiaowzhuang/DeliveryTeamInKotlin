package deliveryteaminkotlin.member

import deliveryteaminkotlin.DeliveryTeam

abstract class TeamMember(var name: String, var team: DeliveryTeam? = null) {
    abstract fun work()
}