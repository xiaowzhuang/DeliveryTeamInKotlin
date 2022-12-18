package deliveryteaminkotlin

import deliveryteaminkotlin.exception.MemberRoleExceedException
import deliveryteaminkotlin.member.TeamMember

class DeliveryTeam(private var name: String ) {
    var members: Set<TeamMember> = mutableSetOf()
    var stories: Set<Story> = mutableSetOf()
    var forbiddenRules: List<(DeliveryTeam) -> Boolean> = mutableListOf()

    private fun isOperationForbidden(): Boolean {
        return forbiddenRules.isNotEmpty() && forbiddenRules.any { r -> r.invoke(this)}
    }

    fun assign(member: TeamMember) {
        if (isOperationForbidden()) {
            throw MemberRoleExceedException("Assign member failed!")
        }
        members += member
    }
    fun assign(story: Story) {
        stories += story
    }

    fun assign(rule: (DeliveryTeam) -> Boolean) {
        forbiddenRules += rule
    }

    fun getMembers(predicate: (TeamMember) -> Boolean): List<TeamMember> {
        return members.filter(predicate)
    }
}