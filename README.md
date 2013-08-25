# Programming Contests

I went to [Cal Poly Pomona](http://www.csupomona.edu/) from 2006 to 2012 as an undergrad, graduate, and lecturer in computer science.  Each quarter (more or less), the student Computer Science Society would host programming contests run by the club's long-time advisor, [Dr.  Rich](http://www.csupomona.edu/~carich/).

This repo is a historical archive of my performance at all of those contests: the good, the bad, and the ugly.  I'm retroactively organizing and assembling as much data as I can about the contests, just because I think it'll be interesting to look at it all and share it with others.  To keep this project self-contained, and in case the original site ever goes down, I'm including copies of a lot of Dr. Rich's material from his [programming contest site](http://www.csupomona.edu/~carich/programming_contests/).

## Directory Structure

* `instructions.pdf` - At each contest, Dr. Rich would post a set of instructions.  Aside from some minor phrase reworking and version bumps to the languages used, these instructions did not really change quarter to quarter.  For simplicity, I've only included the latest copy of the instructions I got from Spring 2012 and placed them at the top level.

* `acm/` - One year, I was frustrated by a programming contest problem at the [ACM ICPC](http://icpc.baylor.edu/) that I thought I could've solved in Python much more easily than the Java my team had to use at the contest.  So afterwards, I drummed up a Python solution to show my friends.

* `nordic/` - When practicing for the [ACM ICPC](http://icpc.baylor.edu/), a friend came across this set of problems.  They were simple enough that I spent the practice session knocking out a bunch of golfed solutions.

* `year/quarter/` - The files associated with a particular programming contest (e.g., `06/fall/` corresponds to the Fall 2006 contest).

  * `rankings.pdf` - When available, I include the spreadsheet of student rankings released after the contests.

  * `problem_name.pdf` - The problem statement supplied by Dr. Rich.

  * `problem_name.*` - The final code I had written, generally in Python.  This is not necessarily code I submitted; it might just be how far I happened to get with the problem.

  * `problem_name.in` - The sample input file for the particular problem.

  * `problem_name.out` - The sample output file for the particular problem.

  * `problem_name.tst_in` - The acid input file for the particular problem.  Hidden from contestants until after the competition.  Used to judge whether a submission was ultimately correct.

  * `problem_name.tst_out` - The acid output file for the particular problem.  Hidden from the contestants until after the competition.  Used to judge whether a submission was ultimately correct..

  * `extra/` - Whatever miscellaneous extra material I might have for that contest.

  * `failed/problem_name/n.*` - The _n_<sup>th</sup> incorrect version of the indicated problem that I submitted to Dr. Rich.

  * `p0/` - Beginning in Fall 2011, Dr. Rich started giving a "Problem 0" some time before the main contest started.  These were easier problems meant to attract new contestants.  To keep veterans entertained, there was a competition to produce the shortest program (in bytes) that solved Problem 0.  I won all three code golf challenges that I attempted.  These are my (various) solutions, arranged in a similar fashion to the main contest material.

## Running The Programs

The program submissions were deemed correct if they produced the specified acid output when given the corresponding acid input.  For example, the following `diff` command should have no output (assuming the program was written in Python, which is generally a safe assumption for my programming contest solutions).

```
$ diff <(python problem_name.py < problem_name.tst_in) problem_name.tst_out
```
