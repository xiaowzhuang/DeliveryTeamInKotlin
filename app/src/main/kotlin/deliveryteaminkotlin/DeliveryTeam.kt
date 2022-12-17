package deliveryteaminkotlin

import deliveryteaminkotlin.member.TeamMember

class DeliveryTeam(var name: String,
                   var members: Set<TeamMember> = mutableSetOf()) {
    fun assign(member: TeamMember) {
        members += member
    }
}