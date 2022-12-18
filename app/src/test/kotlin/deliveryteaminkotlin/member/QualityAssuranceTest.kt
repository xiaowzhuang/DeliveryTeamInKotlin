package deliveryteaminkotlin.member

import deliveryteaminkotlin.DeliveryTeam
import deliveryteaminkotlin.Story
import deliveryteaminkotlin.StoryStatus
import org.junit.jupiter.api.Test
import java.util.stream.Collectors
import kotlin.test.assertEquals

class QualityAssuranceTest {
    @Test
    fun shouldBeAbleToMoveStories() {
        val team = DeliveryTeam("Tiangong")
        val story = Story("dev story")
        story.status = StoryStatus.READY_FOR_QA
        val story2 = Story("dev story2")
        story2.status = StoryStatus.READY_FOR_QA
        val story3 = Story("dev story3")
        story3.status = StoryStatus.READY_FOR_QA
        team.assign(story)
        team.assign(story2)
        team.assign(story3)
        val qa = QualityAssurance("qa")
        qa.team = team
        qa.work()
        assertEquals(2, team.stories
            .filter { it.status == StoryStatus.DONE }
            .size)
    }
}