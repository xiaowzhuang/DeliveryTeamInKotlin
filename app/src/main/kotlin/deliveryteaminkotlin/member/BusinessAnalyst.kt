package deliveryteaminkotlin.member

import deliveryteaminkotlin.Story
import deliveryteaminkotlin.StoryStatus

class BusinessAnalyst(name: String): TeamMember(name) {
    private val MAX_STORIES_NUM = 3
    override fun work() {
        val stories = team?.getStories { it.status == StoryStatus.BACKLOG }
        val members = team?.getMembers { it is Developer && it.isAvailable() } as List<Developer>
        if (stories == null || members == null) return
        (0 until minOf(stories.size, members.size)).forEach {
            members[it].story = stories[it]
            stories[it].status = StoryStatus.IN_DEV
        }
    }
    fun work(stories: List<String>) {
        stories.take(MAX_STORIES_NUM).forEach{ team?.assign(Story(it)) }
    }
}