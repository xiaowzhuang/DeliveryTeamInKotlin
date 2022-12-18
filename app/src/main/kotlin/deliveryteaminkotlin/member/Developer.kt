package deliveryteaminkotlin.member

import deliveryteaminkotlin.Story

class Developer(name: String): TeamMember(name) {
    var story: Story? = null
    override fun work() {
        TODO("Not yet implemented")
    }

    fun isAvailable(): Boolean {
        return story == null;
    }
}