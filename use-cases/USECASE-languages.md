# USE CASE 4: Produce a report of population statistics in the world who speak different languages

## CHARACTERISTIC INFORMATION

### Goal in Context

As an employee I want to produce a report of languages spoken so I can find out the statistics of the world population that speaks foreign languages.
### Scope

Organisation

### Level

Primary task.

### Preconditions

We know the role.  Database contains languages such as Chinese, English, Hindi, Spanish and Arabic.

### Success End Condition

A report is available for the organisation to find the population statistics on spoken languages in the world

### Failed End Condition

No report is produced.

### Primary Actor

Employee

### Trigger

A request for statistics of population in the world who speak different lanagues is sent to the employee

## MAIN SUCCESS SCENARIO

1. Organisation request population statistics for spoken languages in the world.
2. Employee captures names of the languages to get population statistics for the world.
3. Employee extracts current population statistics of all languages in the world from the database.
4. Employee provides report to Organisation


## EXTENSIONS

3. **Language does not exist in the database**:
    1. employee informs organisation no language exists in the database.

## SUB-VARIATIONS

The organisation has asked if it is possible to provide the number of people who speak the following languages from greatest number to smallest, including the percentage of the world population:

- Chinese.
- English.
- Hindi.
- Spanish.
- Arabic.

## SCHEDULE

**DUE DATE**: Release 1.0