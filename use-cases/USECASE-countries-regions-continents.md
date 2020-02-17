# USE CASE: Produce a report of population statistics in continents, regions and countries

## CHARACTERISTIC INFORMATION

### Goal in Context

As an employee I want to produce a report of continents, regions and countries so I can find
out the statistics of the populations.
### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the role. Database contains current continents, regions and countries data.

### Success End Condition

A report is available for the organisation to find the statistics of the populations in continents, regions and countries.
### Failed End Condition

No report is produced.

### Primary Actor

Employee

### Trigger

A request for statistics of populations in continents, regions and countries is sent to the employee

## MAIN SUCCESS SCENARIO

1. Organisation request population statistics for continents, regions and countries .
2. Employee captures names of the continents, regions and countries to get population statistics for.
3. Employee extracts current population statistics of all continents, regions and countries
from the database.
4. Employee provides report to Organisation


## EXTENSIONS

3. **City, region or continent does not exist in the database**:
    1. employee informs organisation no city exists in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0