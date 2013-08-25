# Programming Contests

I went to [Cal Poly Pomona](http://www.csupomona.edu/) from 2006 to 2012 as an undergrad, graduate, and lecturer in computer science.  Each quarter (more or less), the student Computer Science Society would host programming contests run by the club's long-time advisor, [Dr. Rich](http://www.csupomona.edu/~carich/).  These contests were 4 hours of solving 4 problems, coding against the clock.

This repo is a historical archive of my performance at all of those contests: the good, the bad, and the ugly.  I'm retroactively organizing and assembling as much data as I can about the contests, just because I think it'll be interesting to look at it all and share it with others.  To keep this project self-contained, and in case the original site ever goes down, I'm including copies of a lot of Dr. Rich's material from his [programming contest site](http://www.csupomona.edu/~carich/programming_contests/).

To summarize my performance,

* F06 - didn't place
* W07 - 7th place
* F07 - 8th place
* W08 - 2nd place
* S08 - 1st place
* F08 - 4th place
* W09 - 2nd place
* S09 - 2nd place
* F09 - 3rd place
* S10 - 3rd place
* F10 - 3rd place
* W11 - 2nd place
* S11 - 5th place
* F11 - 1st place (alumnus)

## Directory Structure

* `instructions.pdf` - At each contest, Dr. Rich would post a set of instructions.  Aside from some minor phrase reworking and version bumps to the languages used, these instructions did not really change quarter to quarter.  For simplicity, I've only included the latest copy of the instructions I got from Spring 2012 and placed them at the top level.

* `acm/` - One year, I was frustrated by a programming contest problem at the [ACM ICPC](http://icpc.baylor.edu/) that I thought I could've solved in Python much more easily than the Java my team had to use at the contest.  So afterwards, I drummed up a Python solution to show my friends.

* `nordic/` - When practicing for the [ACM ICPC](http://icpc.baylor.edu/), a friend came across this set of problems.  They were simple enough that I spent the practice session knocking out a bunch of golfed solutions.

* `year/quarter/` - The files associated with a particular programming contest (e.g., `06/fall/` corresponds to the Fall 2006 contest).

  * `rankings.pdf` - When available, I include the spreadsheet of student rankings released after the contests.

  * `problem_name.pdf` - The problem statement supplied by Dr. Rich.

  * `problem_name.*` - If present, the final version of the code I wrote, generally in Python.  This is not necessarily code I submitted.  It might just be how far I happened to get with the problem.

  * `problem_name.in` - The sample input file for the particular problem.

  * `problem_name.out` - The sample output file for the particular problem.

  * `problem_name.tst_in` - The acid input file for the particular problem.  Hidden from contestants until after the competition.  Used to judge whether a submission was ultimately correct.

  * `problem_name.tst_out` - The acid output file for the particular problem.  Hidden from the contestants until after the competition.  Used to judge whether a submission was ultimately correct..

  * `extra/` - Whatever miscellaneous extra material I might have for that contest.

  * `failed/problem_name/n.*` - The _n_<sup>th</sup> incorrect version of the indicated problem that I submitted to Dr. Rich.

  * `p0/` - Beginning in Fall 2011, Dr. Rich started giving a "Problem 0" the week before the main contest took place.  These were easier problems meant to attract new contestants.  To keep veterans entertained, there was a competition to produce the shortest program (measured in source code bytes) that solved Problem 0.  I won all three code golf challenges that I attempted.  These are my (various) solutions for the given year/quarter's Problem 0, arranged in a similar fashion to the main contest material.

## Running The Programs

The program submissions were deemed correct if they produced the specified acid output when given the corresponding acid input.  For example, the following `diff` command should have no output (assuming the program was written in Python, which is generally a safe assumption for my programming contest solutions).

```
$ diff -q <(python problem_name.py < problem_name.tst_in) problem_name.tst_out
```

## Missing Data

This project has been somewhat archaeological.  Much of the data was spread across random emails that I managed to download from my school's email servers before my account was revoked.  I was able to track down most of the content, but I'm still missing the following `rankings.pdf` attachments:

* `06/fall/rankings.pdf`
* `07/winter/rankings.pdf`
* `07/fall/rankings.pdf`
* `08/spring/rankings.pdf`
* `09/winter/rankings.pdf`

However, I do have some notes that indicate my personal rank at each of those contests, as well as the bodies of Dr. Rich's emails (via Thunderbird's search index).  I've included the email announcements in each contest's respective `extra/email` files.  Between the notes & emails, it seems that:

* I didn't place in Fall 2006, to the surprise of no one.
* I placed 7th in Winter 2007.  I did get a shout-out in Dr. Rich's email for solving the `poker` problem, though.
* I placed 8th in Fall 2007.
* I placed 1st in Spring 2008.  I remember being excited that I managed to beat the previous champ, Jonathan Dautrich.  Little did I know, I'd be trounced by Stephen Crane for years to come.  :-)
* I placed 2nd in Winter 2009.
