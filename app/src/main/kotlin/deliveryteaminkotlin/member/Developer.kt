package deliveryteaminkotlin.member

import deliveryteaminkotlin.Story
import deliveryteaminkotlin.StoryStatus
import deliveryteaminkotlin.exception.DeveloperUnavailableException

class Developer(name: String): TeamMember(name) {
    var story: Story? = null
        set(value) {
            if (story != null && value != null) {
                throw DeveloperUnavailableException()
            }
            field = value
        }
    override fun work() {
        story?.status = StoryStatus.READY_FOR_QA
        story = null
    }

    fun isAvailable(): Boolean {
        return story == null;
    }
}