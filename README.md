
#The Assignment

#####Purpose 

Learn to set up technical infrastructure to support agile development. The main challenge is
to glue together the bits and pieces through the latter half of this class, into a coherent
infrastructure.


#####Description

Each team should implement the game **TicTacToe**. The main focus is on the infrastructure
and best coding practices described below but not on implemented features.

**The project and infrastructure should tackle the following.**

1.  The code base is stored in source control system on GitHub from early start of the project (the teacher should be able to track the history of the project from the creation of the very first file).

2.  The system is setup with automatic build that must run all unit tests.
    
3.  The output is a deployable or executable artifact, such as a jar/war or equivalent. 
    
4.  The build script has deploy/install target that deploys the executable outside of the working directory or on external server.
    
5.  The business logic should be coded using Test Driven Development.
    
6.  The code should be loosely coupled and follow good object oriented design practices.
    
7.  It is possible to get extra points for the following
    
    1.  More build targets (0,5 point per item, never more than 1 for this part)
		
		* Code coverages
		* Code inspection
		* Integrate database



    2.  Run focused integration or End-to-end tests (e.g. Selenium). It is necessary to run this on external staging server (e.g. Heroku). To run integration test the application needs to connect to external system e.g. database. To run end-toend test the system needs to have GUI (e.g. webUI). (1 point)
    
    3.  Use Automated Continuous Integration Server (e.g. Travis). (1 point)
    
    4.  Continuous Delivery. For each code change the CI server runs these steps:
    		* Run build script (all targets)
		* Run unit and integration tests (if you have integration tests)
		* Deploy on staging and run End-to-end tests.
		* Deploy to production server.
		* Only continue next step if previuous step is success
		* Generate feedback to developer

    5.  **Something else ... Surprise me !!!**
    


#####Grade

Solving parts 1-6 perfectly will together give a grade of 6, it's ok to have all targets in build script manual. In order to get a 10, you'll need to solve at least 4 extra points.


#####Return form

1.  - [ ] URL of root of the project in the source control system
2.  - [ ] Development manual, that is, what is needed and how to get the project to build on a fresh machine :
	- [ ] Source control client and access to source control
	- [ ] Build environment
	- [ ] Other necessary dependencies
3.  - [ ] Administration manual, how to set it up and get it to run, also on a fresh machine.
	- [ ] How to install and run the program on clients machine (in case of simple desktop program)
	- [ ] How to deploy, run and maintain in case of client/server or web application.
4.  - [ ] Design report
	- [ ] Document describing initial design



#####Demonstration

The team will have a 15 minutes demonstration of the technical infrastructure and the simple
functionality developed. The demonstrations will be held in the last week, the detailed
schedule will be published later. The distributed groups will demonstrate using shared
desktop. The demonstration is part of the grade for this assignment. If you can not able to
show some part of the build process (if it is broken) in the demonstration if will not
count in the grade.


##Getting started


#####Requirements


#####Create project


#####Project content



#####Project Test


##Tools & methods



#####Trello

*"Trello is an online tool for managing projects and personal tasks. That may sounds rather prosaic. But this increasingly popular app often inspires the sort of passion usually reserved for consumer apps like Pinterest or Instagram. It’s the kind of business software that slips into businesses through the backdoor, just because individual employees like how it works."*
[Reference](http://www.trello.com)

#####Scrum

*"Scrum is an iterative and incremental [agile software development](http://en.wikipedia.org/wiki/Agile_software_development) framework for managing product development. It defines "a flexible, holistic product development strategy where a development team works as a unit to reach a common goal", challenges assumptions of the "traditional, sequential approach" to product development, and enables teams to self-organize by encouraging physical co-location or close online collaboration of all team members, as well as daily face-to-face communication among all team members and disciplines in the project."*
[Reference](http://en.wikipedia.org/wiki/Scrum_(software_development))


#Git & Github



[For Windows](https://windows.github.com) | [For Mac](https://mac.github.com) | [All platforms](http://git-scm.com)
------------ | ------------- | -------------


Command | Information
------------ | -------------
(`$ git config --global user.name "[name]"`) | Sets the name you want, to your commit transactions
(`$ git config --global user.email "[email]"`) | Sets the email you want, to your commit transactions
(`$ git config --global color.ui auto`) | Enables helpful colorization of command line output
(`$ git init [project-name]`) | Creates a new local repository with the specified name
(`$ git clone [url] `) | Downloads a project & its entire version history
(`$ git status`) | Lists all new or modified files to be commited
(`$ git add [file]`) | Snapshots the file in preparation for versioning
(`$ git reset [file]`) | Unstages the file, but preserve its contents
(`$ git diff`) | Shows file differences not yet staged
(`$ git diff --staged`) | Shows file differences - staging vs last version
(`$ git commit -m "[descriptive message]"`) | Records file snapshots permanently in version history
(`$ git branch`) | Lists all local branches in the current repository
(`$ git branch [branch-name]`) | Creates a new branch
(`$ git checkout [branch-name]`) | Switches to the specified branch & updates the directory
(`$ git merge [branch]`) | Combines the specified branch history to current branch
(`$ git branch -d [branch-name]`) | Deletes the specified branch
(`$ git rm [file]`) | Deletes the file from the directory & stages the deletion
(`$ git rm --cached [file]`) | Removes the file from version control but preserves
(`$ git mv [file-original] [file-renamed]`) | Changes the file name and prepares it for commit
(`$ git ls-files --other --ignored --exclude-standard`) | Lists all ignored files in this project
(`$ git stash`) | Temporarily stores all modified tracked files
(`$ git stash list`) | Lists all stashed changesets
(`$ git stash pop`) | Restores the most recently stashed files
(`$ git stash drop`) | Discards the most recently stashed changeset
(`$ git log`) | Lists version history for the current branch
(`$ git log --follow [file]`) | Lists version history for a file, including renames
(`$ git diff [1st-branch]...[2nd-branch]`) | Shows content differences between two branches
(`$ git show [commit]`) | Outputs metadata & content changes of the commit
(`$ git reset [commit]`) | Undoes all commits, preserving changes locally
(`$ git reset --hard [commit]`) | Discards all history and changes back to the commit
(`$ git fetch [bookmark]`) | Downloads all history from the repository bookmark
(`$ git merge [bookmark]/[branch]`) | Combines bookmark’s branch into current local branch
(`$ git push [alias] [branch]`) | Uploads all local branch commits to GitHub
(`$ git pull`) | Downloads bookmark history & incorporates changes
 |
[Resolving a merge conflict from the command line](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line) | [Using Git blame to trace changes in a file](https://help.github.com/articles/using-git-blame-to-trace-changes-in-a-file/)
[Understanding the GitHub Flow](https://guides.github.com/introduction/flow/index.html)|[Associating text editors with Git](https://help.github.com/articles/associating-text-editors-with-git)
[Ignoring files](https://help.github.com/articles/ignoring-files) | [GitHub Glossary](https://help.github.com/articles/github-glossary)
[Git Reference](http://git-scm.com/docs) | [Trello](http://www.trello.com)
 | 


---

Hugbúnaðarfræði - Team Amarok!

