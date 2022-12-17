package deliveryteaminkotlin

import deliveryteaminkotlin.member.TeamMember

class DeliveryTeam(var name: String,
                   var members: Set<TeamMember> = mutableSetOf(),
                   var stories: Set<Story> = mutableSetOf()) {
    fun assign(member: TeamMember) {
        members += member
    }
    fun assign(story: Story) {
        stories += story
    }

    fun getMembers(predicate: (TeamMember) -> Boolean): List<TeamMember> {
        return members.filter(predicate)
    }
}