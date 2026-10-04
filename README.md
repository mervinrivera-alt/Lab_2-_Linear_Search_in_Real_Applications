# Lab 2: Linear Search in Real Applications

## Table of Contents

* [Project Overview](#project-overview)
* [Learning Objectives](#learning-objectives)
* [Data Structure Used](#data-structure-used)
* [Algorithm Explanation](#algorithm-explanation)

  * [findFirst Method](#findfirst-method)
  * [countMatches Method](#countmatches-method)
* [Console Trace](#console-trace)
* [Manual Tracing](#manual-tracing)

  * [Manual Trace: Java](#manual-trace-java)
  * [Manual Trace: Python](#manual-trace-python)
  * [Edge-Case Trace Summary](#edge-case-trace-summary)
* [Test Evidence Table](#test-evidence-table)
* [Time Complexity](#time-complexity)
* [AI-Use Declaration](#ai-use-declaration)

  * [AI Model Used](#ai-model-used)
  * [Prompts Used](#prompts-used)
  * [AI Suggestions Adopted and Rejected](#ai-suggestions-adopted-and-rejected)
  * [Verification](#verification)
* [How to Run](#how-to-run)
* [Viva Question and Answer](#viva-question-and-answer)

---

## Project Overview

This project implements **Linear Search** in Java using a fixed array of five book titles:

```java
String[] books = {"C", "Java", "DSA", "Java", "SQL"};
```

The program provides the two required methods:

```java
findFirst(String[] items, String target)
countMatches(String[] items, String target)
```

`findFirst()` searches the array from index `0` toward the end and returns the index of the first matching title. If the target is not found, it returns `-1`.

`countMatches()` searches the entire array and counts how many times the target title occurs.

The program also accepts the search target from the user through `Scanner` and displays a trace of the comparisons made by each method.

---

## Learning Objectives

This laboratory focuses on:

* Implementing Linear Search for strings.
* Tracing the indexes inspected during a search.
* Finding the first occurrence of a target.
* Counting duplicate occurrences of a target.
* Understanding best-case and worst-case search behavior.
* Testing normal and edge cases.
* Explaining and verifying AI-assisted development decisions.

---

## Data Structure Used

The program uses a **fixed-size String array** containing five book titles.

| Index | Book Title |
| ----: | ---------- |
|     0 | `C`        |
|     1 | `Java`     |
|     2 | `DSA`      |
|     3 | `Java`     |
|     4 | `SQL`      |

The array is **unsorted**, which makes it suitable for demonstrating Linear Search.

---

# Algorithm Explanation

## `findFirst` Method

The `findFirst()` method performs a sequential search from the beginning of the array.

1. Start at index `0`.
2. Compare the current element with the target using `equals()`.
3. If the current element does not match, continue to the next index.
4. If the current element matches, return that index immediately.
5. If the loop reaches the end without finding a match, return `-1`.

For example, when searching for `Java`:

```text
Index:  0      1       2       3      4
        C     Java     DSA    Java    SQL
        ↑      ↑
        |      |
 comparison  match -> stops
```

The first `Java` is at index `1`, so `findFirst()` returns `1`.

## `countMatches` Method

The `countMatches()` method also uses Linear Search, but it must inspect the entire array.

1. Start a counter at `0`.
2. Start at index `0`.
3. Compare each element with the target.
4. Increase the counter whenever a match is found.
5. Continue until the last index.
6. Return the final count.

For `Java`, the array contains two occurrences, so `countMatches()` returns `2`.

---

# Console Trace

The console output identifies which method is being executed and shows what happens at each inspected index.

For `Java`:

```text
findFirst("Java"):
index 0 -> comparison
index 1 -> match -> stops

countMatches("Java"):
index 0 -> comparison
index 1 -> match
index 2 -> comparison
index 3 -> match
index 4 -> comparison

findFirst -> index: 1
countMatches -> occurrences: 2
```

For `Python`:

```text
findFirst("Python"):
index 0 -> comparison
index 1 -> comparison
index 2 -> comparison
index 3 -> comparison
index 4 -> comparison

countMatches("Python"):
index 0 -> comparison
index 1 -> comparison
index 2 -> comparison
index 3 -> comparison
index 4 -> comparison

findFirst -> no index found
countMatches -> occurrences: 0
```

The output uses `->` instead of the Unicode arrow `→` so that the terminal displays the tracing symbols correctly.

---

# Manual Tracing

The laboratory requires a manual trace for searches for `Java` and `Python`, including the number of comparisons performed.

## Manual Trace: Java

### `findFirst("Java")`

Array:

```text
[C, Java, DSA, Java, SQL]
```

| Step | Index | Value  | Comparison Result | Action                  |
| ---: | ----: | ------ | ----------------- | ----------------------- |
|    1 |     0 | `C`    | `C` != `Java`     | Continue                |
|    2 |     1 | `Java` | `Java` == `Java`  | Match, return `1`, stop |

**Total comparisons:** `2`

**Final result:** `index 1`

### `countMatches("Java")`

| Step | Index | Value  | Comparison Result | Action    |
| ---: | ----: | ------ | ----------------- | --------- |
|    1 |     0 | `C`    | `C` != `Java`     | Continue  |
|    2 |     1 | `Java` | `Java` == `Java`  | Count = 1 |
|    3 |     2 | `DSA`  | `DSA` != `Java`   | Continue  |
|    4 |     3 | `Java` | `Java` == `Java`  | Count = 2 |
|    5 |     4 | `SQL`  | `SQL` != `Java`   | Continue  |

**Total comparisons:** `5`

**Final result:** `2 occurrences`

---

## Manual Trace: Python

`Python` does not appear in the array:

```text
[C, Java, DSA, Java, SQL]
```

### `findFirst("Python")`

| Step | Index | Value  | Comparison Result  | Action    |
| ---: | ----: | ------ | ------------------ | --------- |
|    1 |     0 | `C`    | `C` != `Python`    | Continue  |
|    2 |     1 | `Java` | `Java` != `Python` | Continue  |
|    3 |     2 | `DSA`  | `DSA` != `Python`  | Continue  |
|    4 |     3 | `Java` | `Java` != `Python` | Continue  |
|    5 |     4 | `SQL`  | `SQL` != `Python`  | Reach end |

**Total comparisons:** `5`

**Final result:** `no index found`

**Internal method return:** `-1`

### `countMatches("Python")`

| Step | Index | Value  | Comparison Result  | Action       |
| ---: | ----: | ------ | ------------------ | ------------ |
|    1 |     0 | `C`    | `C` != `Python`    | Continue     |
|    2 |     1 | `Java` | `Java` != `Python` | Continue     |
|    3 |     2 | `DSA`  | `DSA` != `Python`  | Continue     |
|    4 |     3 | `Java` | `Java` != `Python` | Continue     |
|    5 |     4 | `SQL`  | `SQL` != `Python`  | End of array |

**Total comparisons:** `5`

**Final result:** `0 occurrences`

---

## Edge-Case Trace Summary

The laboratory identifies the following cases for testing.

| Edge Case                | Test Input                            | Expected Behavior                                                                                    |
| ------------------------ | ------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| Target at first position | `C`                                   | `findFirst()` should stop after the first comparison and return index `0`.                           |
| Target at last position  | `SQL`                                 | `findFirst()` should inspect all five positions and return index `4`.                                |
| Target missing           | `Python`                              | `findFirst()` should inspect all five positions and return `-1`; `countMatches()` should return `0`. |
| Repeated title           | `Java`                                | `findFirst()` should stop at index `1`; `countMatches()` should continue and return `2`.             |
| Adjacent duplicates      | `{"C", "Java", "Java", "DSA", "SQL"}` | `findFirst()` should return index `1`; `countMatches()` should return `2`.                           |

---

# Test Evidence Table

The lab requires a test-evidence table and testing of normal and edge cases.

| Test Case                | Input / Action                                              | Expected `findFirst()` | Expected `countMatches()` | Comparisons                       |
| ------------------------ | ----------------------------------------------------------- | ---------------------- | ------------------------- | --------------------------------- |
| Target at first position | Target: `C`                                                 | Index `0`              | `1` occurrence            | `findFirst`: 1, `countMatches`: 5 |
| Target at last position  | Target: `SQL`                                               | Index `4`              | `1` occurrence            | `findFirst`: 5, `countMatches`: 5 |
| Target missing           | Target: `Python`                                            | No index found         | `0` occurrences           | `findFirst`: 5, `countMatches`: 5 |
| Repeated title           | Target: `Java`                                              | Index `1`              | `2` occurrences           | `findFirst`: 2, `countMatches`: 5 |
| Adjacent duplicates      | Array: `{"C", "Java", "Java", "DSA", "SQL"}`, target `Java` | Index `1`              | `2` occurrences           | `findFirst`: 2, `countMatches`: 5 |

### Required Console Evidence

For the required `Java` test:

```text
findFirst -> index: 1
countMatches -> occurrences: 2
```

For the required `Python` test:

```text
findFirst -> no index found
countMatches -> occurrences: 0
```

**Submission:** Attach screenshots or a console log of the actual successful runs to provide the required test evidence.

---

# Time Complexity

Linear Search does not require the array to be sorted.

### `findFirst()`

* **Best case:** `O(1)` when the target is at the first index.
* **Worst case:** `O(n)` when the target is at the last index or is missing.
* The method can stop early when the first match is found.

### `countMatches()`

* **Best case:** `O(n)` because every element must be inspected to determine the total number of matches.
* **Worst case:** `O(n)`.
* The method cannot stop after the first match because additional duplicates may appear later.

---

# AI-Use Declaration

## AI Model Used

**Model used in OpenCode:** `Nemotron 3.5 Lightning Free`

The OpenCode session export identifies this model in the recorded assistant responses.

---

## Prompts Used

The following are the important prompts from the OpenCode session that directly contributed to this project.

### Prompt 1: Initial Algorithm Planning

> “Act as a Java tutor. Help me design pseudocode for Linear Search in Real Applications. Do not write full code until I explain the algorithm back to you.”

This was used before asking for a complete implementation.

### Prompt 2: Algorithm Explanation

I explained that the data would be stored in the fixed array:

```text
{C, Java, DSA, Java, SQL}
```

and that the required methods were:

```text
findFirst(String[] items, String target)
countMatches(String[] items, String target)
```

I explained that `findFirst()` should stop at the first match and return `-1` if the target was missing, while `countMatches()` should continue through the entire array and count every match.

### Prompt 3: Java Skeleton

I asked OpenCode for a simple Java skeleton implementing the two required methods after explaining the algorithms.

### Prompt 4: User Input and Project Naming

I requested the addition of `Scanner` so the user could enter a search target instead of using a hard-coded value.

I also changed the class name from `LinearSearch` to `LibraryFinder` so the source file would be:

```text
LibraryFinder.java
```

### Prompt 5: Single-Traversal Investigation

I asked OpenCode to make the array checked only once while keeping both required methods.

The request required:

* Keeping `findFirst()` and `countMatches()`.
* Keeping their names, parameters, return types, and purposes.
* Performing one traversal that obtains both the first index and total count.
* Avoiding a second traversal in `countMatches()`.

OpenCode suggested using shared `static` fields so `findFirst()` could calculate both values while `countMatches()` reused the stored count.

### Prompt 6: Rejecting the Shared-State Design

I rejected the shared-state/single-traversal design because I wanted to preserve the original separate method implementations and their own loops.

I then requested an output-only change while keeping the existing method structure and search/counting logic.

### Prompt 7: Final Console Trace Display

I instructed OpenCode to display the search process separately for both methods.

The requested format was:

```text
findFirst("Java"):
index 0 -> comparison
index 1 -> match -> stops

countMatches("Java"):
index 0 -> comparison
index 1 -> match
index 2 -> comparison
index 3 -> match
index 4 -> comparison

findFirst -> index: 1
countMatches -> occurrences: 2
```

For a missing target:

```text
findFirst("Python"):
index 0 -> comparison
index 1 -> comparison
index 2 -> comparison
index 3 -> comparison
index 4 -> comparison

countMatches("Python"):
index 0 -> comparison
index 1 -> comparison
index 2 -> comparison
index 3 -> comparison
index 4 -> comparison

findFirst -> no index found
countMatches -> occurrences: 0
```

The Unicode arrow `→` was replaced with `->` because it was appearing as `?` in the terminal.

---

## AI Suggestions Adopted and Rejected

### Adopted

AI assistance was adopted for:

* Developing the initial pseudocode.
* Explaining the two linear-search methods.
* Creating the initial Java skeleton.
* Adding `Scanner` user input.
* Changing the class name to `LibraryFinder`.
* Improving the console trace so each method's behavior is visible.
* Changing the missing-result display from `-1` to `no index found`.
* Replacing the Unicode arrow with `->`.

### Rejected

I rejected the AI's **shared-state single-traversal design**.

The proposed design used:

```java
private static int firstMatchIndex = -1;
private static int totalMatches = 0;
```

and changed `findFirst()` so it calculated both the first index and the total number of matches, while `countMatches()` returned the stored count.

I rejected this design because I wanted to preserve the original two-method structure and keep the methods performing their own separate operations.

The final design therefore keeps:

```text
findFirst()     -> finds the first occurrence
countMatches()  -> counts every occurrence
```

as separate methods.

---

# Verification

I reviewed the AI-generated code against the required algorithm and tested the program behavior.

### `Java` Verification

For the array:

```text
[C, Java, DSA, Java, SQL]
```

`findFirst("Java")` finds the first match at index `1` and stops.

`countMatches("Java")` continues through the array and finds two occurrences.

The expected final result is:

```text
findFirst -> index: 1
countMatches -> occurrences: 2
```

### `Python` Verification

`Python` does not occur in the array.

`findFirst("Python")` checks all five elements and returns `-1` internally. The user-facing output is:

```text
findFirst -> no index found
```

`countMatches("Python")` checks all five elements and returns:

```text
countMatches -> occurrences: 0
```

### Independent Checking

I compared the program behavior with the required linear-search steps and checked that:

* `findFirst()` stops at the first matching element.
* `findFirst()` returns `-1` internally when no match exists.
* `countMatches()` continues through the entire array.
* Duplicate titles are counted correctly.
* Every inspected index is represented in the trace.
* The final displayed results match the search performed.

---

# How to Run

Compile the Java source file:

```bash
javac LibraryFinder.java
```

Run the program:

```bash
java LibraryFinder
```

When prompted, enter a book title such as:

```text
Enter the book title to find: Java
```

or:

```text
Enter the book title to find: Python
```

---

# Viva Question and Answer

## Why does Linear Search work on unsorted data, and when should it be avoided?

Linear Search works on unsorted data because it checks each element one by one without requiring the data to be arranged in a specific order. It should be avoided for very large datasets or frequent searches because it may need to check many elements and has a worst-case time complexity of O(n). For sorted data, Binary Search can be more efficient because it reduces the search area much faster.

I also reviewed and tested the resulting program behavior and can explain the purpose of the array, loops, conditions, indexes, `equals()`, return values, and counting logic used in the submitted code.

I am prepared to explain and defend the submitted code during the individual viva.

I should be able to explain and defend every submitted line of code during the individual viva.
