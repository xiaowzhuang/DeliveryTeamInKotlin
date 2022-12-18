package deliveryteaminkotlin.member

import deliveryteaminkotlin.Story
import deliveryteaminkotlin.StoryStatus
import deliveryteaminkotlin.exception.DeveloperUnavailableException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeveloperTest {
    @Test
    @Throws(DeveloperUnavailableException::class)
    fun shouldThrowExceptionWhenAssignedASecondStory() {
        val story = Story("dev story")
        val story2 = Story("dev story2")
        val dev = Developer("dev1")
        dev.story = story

        Assertions.assertThrows(DeveloperUnavailableException::class.java) {
            dev.story = story2
        }
    }

    @Test
    @Throws(DeveloperUnavailableException::class)
    fun shouldBeAbleWorkOnStory() {
        val story = Story("dev story")
        val dev = Developer("dev1")
        dev.story = story
        dev.work()

        assertEquals(null, dev.story)
        assertEquals(StoryStatus.READY_FOR_QA, story.status)
    }
}