# My CPSC 210 Project

## Simple Tierlist Maker

What will the application do?

The application will be a simple tierlist maker with the
following functions and attributes
- UI will display a roster of anime characters and tiers 
from S to D
- User will be allowed to add/remove characters to tiers
- Users will be allowed to look into tiers to see the
characters currently added
- Users will be allowed to check features/traits of each
character
- Users will be allowed to view a 'presentation display' of 
the tierlist, which will show each tier and all characters
within it (like a normal tierlist)
- Users will be allowed to add tiers

Who will use it?

Anime fans


Why is this project of interest to you?

A tierlist is a creative format that lets
people share their opinions on a topic in a clear and 
concise way. Due to this, tierlists have become a popular
source of content for entertainers such as youtubers and
streamers, they're also something that I've found enjoyable
to create and discuss with friends. Due to the relevancy
of tierlists, and the personal interest I have in the subject,
I've decided to model my CPSC210 project after a tierlist
maker.

## User Stories
- I want to be able to add characters to tier lists
- I want to be able to remove characters from tier lists
- I want to be able to add characters
- I want to be able to add tiers
- I want to be able to save my Tierlist to file
- I want to be able to load my Tierlists from file
  

## Phase 4: Task 2

Thu Dec 01 21:24:15 PST 2022
Character added to tier
Thu Dec 01 21:24:19 PST 2022
Character created
Thu Dec 01 21:24:19 PST 2022
Character removed from tier
Thu Dec 01 21:24:33 PST 2022
Character created

## Phase 4: Task 3
There is a lot of duplicate code in my programme between classes Tier, CharacterList, and TierList.
Ideally I would want two superclasses, and have Tier and CharacterList extend one, and CharacterList and TierList
extend the other. However since one class cannot extend multiple other classes, I would refactor
this code using an interface
- CharacterList and Tier have lots of duplicate code, so I would create a superclass and extend that class
- CharacterList and TierList have duplicate code as well, I would refactor this by using an interface, and
  implementing this interface in those classes.