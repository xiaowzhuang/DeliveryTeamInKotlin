package deliveryteaminkotlin.member

import com.google.common.collect.ImmutableList
import deliveryteaminkotlin.DeliveryTeam
import deliveryteaminkotlin.StoryStatus
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BusinessAnalystTest {
    @Test
    fun shouldBeAbleToProduceStory() {
        val team = DeliveryTeam("Tiangong")
        val ba = BusinessAnalyst("BA1")
        ba.team = team
        ba.work(ImmutableList.of("Story title1"))
        assertEquals(1, team.stories.size)
        assertEquals(true, team.stories.any { it.title == "Story title1" })
    }

    @Test
    fun shouldBeAbleToProduceStories() {
        val team = DeliveryTeam("Tiangong")
        val ba = BusinessAnalyst("BA1")
        ba.team = team
        ba.work(ImmutableList.of("Story title1", "Story title2", "Story title3", "Story title4"))
        assertEquals(3, team.stories.size)
        assertEquals(true, team.stories.any { it.title == "Story title1" })
        assertEquals(true, team.stories.any { it.title == "Story title2" })
        assertEquals(true, team.stories.any { it.title == "Story title3" })
    }

    @Test
    @Throws(Exception::class)
    fun shouldBeAbleToAssignStoriesToAvailableDevs() {
        val team = DeliveryTeam("Tiangong")
        val ba = BusinessAnalyst("BA1")
        val dev1 = Developer("dev")
        ba.team = team
        dev1.team = team

        team.assign(ba)
        team.assign(dev1)
        ba.work(ImmutableList.of("Story title1", "Story title2", "Story title3", "Story title4"))
        ba.work()
        assertEquals(1, team.stories
            .filter { it.status == StoryStatus.IN_DEV }
            .size)
        assertEquals(2, team.stories
            .filter { it.status == StoryStatus.BACKLOG }
            .size)
    }
}