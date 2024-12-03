# Weekly Reflection

### Weeks 2-3 (9/2 - 9/13)
With this being the last project for before graduation, I really want to choose something different that what was 
built in previous semesters. My instructor suggested https://rapidapi.com/hub and finally i found some inspiration! We 
will be exploring the use of API's this semester so choosing to combine the use of sports and AI options for my project
was a no-brainer! Using sports and A.I., i want to predict the outcome of a game!  Belieive it or not, that was my 
biggest struggle and set me back a bit but i'm excited to move on now. I worry that the scope is a little more than
i expected and hope i'm not in over my head with the given timeframe and my skill level.

Completed - (4 hours)
 * Choose project idea
 * Create repo
 * Tomcat configured
 * Favorite the API's i'd like to use from https://rapidapi.com/hub and other sites like it
 * Name, repo link, and project topic added to student directory

### Week 4 (9/16)
Played a bit of catch up this week with the project and course work. Our first checkpoint is due this week so 
that will be my priority before looking into this week's topic. After my project plan was done, i really wanted to get
the index page and some other placeholder's started and pick one of the easier user stories to start with. Ended up 
choosing Bootsrap as the framework for my project since that is what i'm most familiar with. Imported a theme from
w3schools.com from last semester that i liked as well. I struggled a little with the project plan trying to predict
what i'd be working but i had to keep in mind things change so it does not have to perfect.

Completed - 3 hours
 * Project Plan 
 * MVP user stories
 * README.md updated
 * Imported Bootstrap
 * Index.jsp page started
 * Theme included 
 * Renamed Repo

### Week 5 (9/23) Hibernate
Mainly focused on getting this week's finished and watching the videos. Not quite to the point where I want to start
putting this in my personal project, but I now have at least two working examples to compare with when the time comes. 
Having a good understanding on how hibernate functions with the annotations/relationships will make my life so much 
easier when it comes time to populate my tables with data. More importantly, the unit testing and ensuring things go 
smoothly is what I mainly want to pay attention to. Creating the generic dao to eliminate duplicate code was pretty 
slick also!

## Week 6 (9/30) AWS Elastic Beanstalk
This week we worked with Elastic beanstalk and RDS. Configuring our application and database to be deployed through
AWS. I feel like this will be more of something i would do towards the end of my project, so I will revisit this later.

completed - 1 hour
* ApplicationStartup
* PropertiesLoader interface imported
* GenericDao imported
* SessionFactoryProvider imported

## Week 7 (10/7) AWS Cognito
Finally felt comfortable enough to begin adding some of the new material into my project this week which also prepares
me for checkpoint #2. First I built my 6 entities needed to represent each table in my database then added the proper 
annotations configured through hibernate (Relationships included). Although it was tedious at first, everything came
out as expected except I may have been testing in my main database vs a test database so i will need to correct that.
I went ahead and added Cognito into my application while it was still fresh and the topic for this week. I'll be using 
the email used for each user during sign up to be stored into the database for later use with their favorite teams.

Completed - 7 hours
* Hibernate imported and configured
* log4J imported and configured
* Cognito imported and configured
* Database created with relationships
* 6 entities (POJO) built with annotations
* Database file imported and configured
* Unit Testing for Sport finished??? (CRUD)
* Checkpoint #2 complete

## Week 8 (10/14)
Being able to have a list of favorite teams for faster viewing is a big portion of my project so i wanted to unit test
this first then move on to the rest. I ran into some relationship issues but thankfully i was able to debug with the
help of the hibernate log4j logs. After successfully creating the full CRUD for my favorite teams dao, i went ahead and created the outline/skeleton for both the jsp and servlet for the user dashboard where the viewing, and editing of 
their favorite teams will exist. Checkpoint #2 is also due this week!

Completed - 3 hours
* FavoriteTeam Dao Created and Unit tested
* Outline for the user dashboard created
* Checkpoint #2

## Weeks 10 - 12 (10/28, 11/4, 11/11)
Unfortunately I wasn't able to get much done on my project during weeks 9 and 10 due to the personal life and the team
project, but I did notice that my database did not need to be as big and robust as it was. It made more sense to just 
generate most of the data dynamically since I am going to be consuming a Restful API that will have changing data. If
not my database would eventually be enormous and probably slow my application down so i decided for my database to only
save the user and user's favorite teams. New database will hold four tables/entities and have multiple database 
relationships (many-to-one and one-to-many). To make my life easier i went ahead and implemented restraints so that 
certain data would and would not be deleted. Due to time restraints, i've decided to change up the scope of my project
and remove the integration of AI. Instead, I will just show the probability/odds of whom the winner will be. I have
a good bit of work and hours ahead of me if i want to make this happen before the deadline, but it is achievable!!! The
plan was to have a few different sports but NBA is the focus for now. I have chosen Tank01 as my restful api for all my
NBA information. Checkpoint #3 is around the corner and i should be set up for success now.


completed - 10 hours
- Recreated database with constraints
- User dashboard servlet created with it's jsp landing page
- Create new entities for new database
- Begin Unit testing entities and client service
- Update read.me with and project name
- Created Aws database

## Weeks 13 - 14 (11/18, 11/25)
More catchup for these two weeks but I am getting close to my end goal! I was able to finish my unit testing for all 
four entities, and am ready to start building out some servlets and jsps. So that I am able to complete checkpoint #3,
getting the user dashboard to function was top priority. I ran into an issue where I could not access my user and team
objects which was very frustrating. After hours of debugging and internet searching, I found that I need to use Integer 
to return the user or team ID because since it wraps the primitive int into an object. And vice versa, i have to parse
the Integer object to get my int. After building out the user dashboard and making sure it works as it should, my next
goal is to start on the team schedules and consuming my restful api. While it was on my mind, i included a link to the 
dashboard, log in and log out links for cognito and logic for these links to show if a user is signed in. This isn't 
quite working as it should but for now it will have to suffice. Roughly a week left but the goal is definitely in sight!

** NOTE: My team link to dashboard still appears on index page although no one is logged in which leads to a blank page
need to take a look at the logic and why that and sign out are still showing. I suspect it is the session **

completed - 9 hours
- Finished unit testing
- Dashboard servlets for full CRUD created with direction and redirection.
- Deployed updated app to AWS
- Double check checkpoint #3 is ready to turn in
- Configured logic for index and dashboard page links (partially working)

