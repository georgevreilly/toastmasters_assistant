# Toastmasters Assistant Android App

Final project for [Android Study Jam](http://www.meetup.com/seattle-gdg/events/228796846/)

## Topic

Toastmasters 101 app: Introduce users to [Toastmasters](http://www.toastmasters.org)
by showing them the ten speeches of a Competent Communicator (CC)
and the structure of a typical Toastmasters' meeting.

## Scenarios

- First-time visitor to a Toastmasters club trying to understand meetings and CCs
- New club member working out themes of each CC speech project
- Timekeeper trying to remember the prescribed duration of CC speeches

## Features

- Agenda of typical meeting
- Meeting roles (e.g., Topicsmaster, General Evaluator)
- The 10 Competent Communicator Projects (e.g., Ice Breaker, Get Comfortable With Visual Aids)

This example goes beyond spelling everything out with an endless series of XML `TextView`s.
Instead it uses an `ExpandableListView` to provide a two-level presentation.
Initially, all you see are the three main areas, Meeting Agenda, Meeting Roles,
and Competent Communicator Speeches.
If you click any of these, they expand to show their children.
This is adapted from [Java Code Geeks ExpandableListView Example](https://examples.javacodegeeks.com/android/core/ui/expandablelistview/android-expandablelistview-example/)

I wanted to further expand each child area,
so that tapping, say, Topicsmaster would expand into a more detailed explanation
of what a Topicsmaster does.
Yenchi suggested to me that I should handle each one of these
with two views, one the summary, the other the detail,
with only one visible at a time.
However, I lacked the time to pursue this suggestion.

# Instructions

* `git clone https://github.com/georgevreilly/toastmasters_assistant.git`
* Open project in Android Studio
* Run in an Android Emulator
* ??
* Profit!
