# USE CASE: Produce a report of population statistics in cities

## CHARACTERISTIC INFORMATION

### Goal in Context

As an employee I want to produce a report of cities so I can find out the statistics of the populations.
### Scope

Organisation

### Level

Primary task.

### Preconditions

We know the role.  Database contains current cities data.

### Success End Condition

A report is available for the organisation to find the statistics of the population on cities

### Failed End Condition

No report is produced.

### Primary Actor

Employee

### Trigger

A request for statistics of populations on cities is sent to the employee

## MAIN SUCCESS SCENARIO

1. Organisation request population statistics for given cities.
2. Employee captures names of the cities to get population statistics for.
3. Employee extracts current population statistics of all cities from the database.
4. Employee provides report to Organisation


## EXTENSIONS

3. **City does not exist in the database**:
    1. employee informs organisation no city exists in the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0