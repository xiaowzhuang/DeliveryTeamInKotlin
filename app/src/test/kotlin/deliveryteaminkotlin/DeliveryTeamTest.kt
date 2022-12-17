package deliveryteaminkotlin

import deliveryteaminkotlin.member.BusinessAnalyst
import deliveryteaminkotlin.member.Developer
import deliveryteaminkotlin.member.QualityAssurance
import deliveryteaminkotlin.member.TeamMember
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeliveryTeamTest {
    @Test
    fun shouldBeAbleToAssignMember() {
        var team: DeliveryTeam = DeliveryTeam("Tiangong")
        val ba: TeamMember = BusinessAnalyst("Member1")
        val dev: TeamMember = Developer("Member1")
        val qa: TeamMember = QualityAssurance("Member1")
        team.assign(ba);
        team.assign(dev);
        team.assign(qa);

        assertEquals(3, team.members.size);
        assertEquals(true, team.members.contains(ba));
        assertEquals(true, team.members.contains(dev));
        assertEquals(true, team.members.contains(qa));
    }

    @Test
    fun shouldBeAbleToAssignStory() {
        var team: DeliveryTeam = DeliveryTeam("Tiangong")
        val story: Story = Story("Story title")

        team.assign(story);

        assertEquals(1, team.stories.size);
        assertEquals(true, team.stories.contains(story));
    }
}