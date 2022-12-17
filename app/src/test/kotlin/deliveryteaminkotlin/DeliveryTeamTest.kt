package deliveryteaminkotlin

import deliveryteaminkotlin.member.BusinessAnalyst
import deliveryteaminkotlin.member.Developer
import deliveryteaminkotlin.member.QualityAssurance
import deliveryteaminkotlin.member.TeamMember
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeliveryTeamTest {
    @Test
    fun shouldBeAbleToAssignMember() {
        var team = DeliveryTeam("Tiangong")
        val ba: TeamMember = BusinessAnalyst("MemberBA1")
        val dev: TeamMember = Developer("MemberDev1")
        val qa: TeamMember = QualityAssurance("MemberQA1")
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
        var team = DeliveryTeam("Tiangong")
        val story: Story = Story("Story title")

        team.assign(story);

        assertEquals(1, team.stories.size);
        assertEquals(true, team.stories.contains(story));
    }

    @Test
    fun shouldBeAbleToGetDevelopers() {
        var team = DeliveryTeam("Tiangong")
        val ba: TeamMember = BusinessAnalyst("MemberBA1")
        val dev1: TeamMember = Developer("MemberDev1")
        val dev2: TeamMember = Developer("MemberDev1")
        val qa: TeamMember = QualityAssurance("MemberQA1")
        team.assign(ba);
        team.assign(dev1);
        team.assign(dev2);
        team.assign(qa);

        val devs: List<TeamMember>  = team.getMembers{ m -> m is Developer};
        assertEquals(2, devs.size);
    }

    @Test
    fun shouldBeAbleToGetMemebersWhoHaveAInName() {
        var team = DeliveryTeam("Tiangong")
        val alice: TeamMember = BusinessAnalyst("Alice")
        val mia: TeamMember = Developer("Mia")
        val bob: TeamMember = Developer("Bob")
        val cathy: TeamMember = QualityAssurance("Cathy")
        team.assign(alice);
        team.assign(mia);
        team.assign(bob);
        team.assign(cathy);

        val devs: List<TeamMember>  = team.getMembers{ m -> m.name.lowercase().contains("a")};
        assertEquals(3, devs.size);
        assertEquals(true, devs.contains(alice));
        assertEquals(true, devs.contains(mia));
        assertEquals(true, devs.contains(cathy));
    }
}