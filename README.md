# Given Sample Work

# Truss Software Engineering Interview

## Introduction and expectations

Hi there! Please complete the problem described below to the best of
your ability, using the tools you're most comfortable with. Assume
you're sending your submission in for code review from peers;
we'll be talking about your submission in your interview in that
context.

We expect this to take less than 4 hours of actual coding time. Please
submit a working but incomplete solution instead of spending more time
on it. We're also aware that getting after-hours coding time can be
challenging; we'd like a submission within a week and if you need more
time please let us know.


## The problem: CSV normalization

Please write a tool that reads a CSV formatted file on `stdin` and
emits a normalized CSV formatted file on `stdout`. For example, if
your program was named `normalizer` we would test your code on the
command line like this:

```sh
./normalizer < sample.csv > output.csv
```

Normalized, in this case, means:

* The entire CSV is in the UTF-8 character set.
* The `Timestamp` column should be formatted in ISO-8601 format.
* The `Timestamp` column should be assumed to be in US/Pacific time;
  please convert it to US/Eastern.
* All `ZIP` codes should be formatted as 5 digits. If there are less
  than 5 digits, assume 0 as the prefix.
* The `FullName` column should be converted to uppercase. There will be
  non-English names.
* The `Address` column should be passed through as is, except for
  Unicode validation. Please note there are commas in the Address
  field; your CSV parsing will need to take that into account. Commas
  will only be present inside a quoted string.
* The `FooDuration` and `BarDuration` columns are in HH:MM:SS.MS
  format (where MS is milliseconds); please convert them to the
  total number of seconds expressed in floating point format.
  You should not round the result.
* The `TotalDuration` column is filled with garbage data. For each
  row, please replace the value of `TotalDuration` with the sum of
  `FooDuration` and `BarDuration`.
* The `Notes` column is free form text input by end-users; please do
  not perform any transformations on this column. If there are invalid
  UTF-8 characters, please replace them with the Unicode Replacement
  Character.

You can assume that the input document is in UTF-8 and that any times
that are missing timezone information are in US/Pacific. If a
character is invalid, please replace it with the Unicode Replacement
Character. If that replacement makes data invalid (for example,
because it turns a date field into something unparseable), print a
warning to `stderr` and drop the row from your output.

You can assume that the sample data we provide will contain all date
and time format variants you will need to handle.

# My Comments:

* I've wrote and build this project using Java 8. I use Java API without using any other third party API.

# How to build and run
* Need to use JDK 1.8 to edit and compile the code
* Need to install jre ver 1.8 to run on your computer
* command line to run the code within this folder:
----
  java Normalize <input.csv> <output.csv>
----

## Assumtion:
 1. The csv file will always be in the given format.
 2. Input document is in UTF-8 and Time zone is US/Pacific
 
## Tasks to do:
1. Need to work on TODO items in the project to complete the functions of the tool
2. Change to using third party API if I can because it will save more time.
3. There will some improvement on some functionalities.

## Final Thoughts:
This is very interesting project from Truss team. I wish I could do better and complete the project. It has been a busy week for me. However, I managed to put effort on this project and I am very happy. 
