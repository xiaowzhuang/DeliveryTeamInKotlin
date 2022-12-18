package deliveryteaminkotlin.member

import deliveryteaminkotlin.StoryStatus

class QualityAssurance(name: String): TeamMember(name)  {
    val MAX_STORIES_NUM = 2
    override fun work() {
        team?.getStories{ it.status == StoryStatus.READY_FOR_QA }
            ?.take(MAX_STORIES_NUM)
            ?.forEach {it.status = StoryStatus.DONE}
    }
}