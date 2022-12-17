package deliveryteaminkotlin

data class Story(val title: String, var status: StoryStatus = StoryStatus.BACKLOG)
