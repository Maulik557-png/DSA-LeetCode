# DSA-LeetCode

A personal Java repository for practicing **Data Structures and Algorithms** through
structured DSA courses, LeetCode problems, daily challenge work, and repeated
implementation patterns.

The repo now contains **405 Java files** across DSA fundamentals, topic-wise
practice, LeetCode solutions, and POTD folders.

## Table of Contents

- [Repository Structure](#repository-structure)
- [Current Progress](#current-progress)
- [Content Overview](#content-overview)
- [Getting Started](#getting-started)
- [Problem Categories](#problem-categories)
- [Notes](#notes)

## Repository Structure

```text
DSA-LeetCode/
|-- DSA/
|   |-- Patterns/                         # Pattern printing and loop practice
|   |-- pepcoding/                        # Pepcoding DSA course practice
|   |   |-- Arrays/                       # Array basics and arithmetic
|   |   |-- Basic/                        # Number systems, digits, prime/GCD basics
|   |   |-- Linked_List/                  # Linked list implementation and patterns
|   |   |-- Queue/                        # Queue implementations and adapters
|   |   |-- Stack/                        # Stack implementations and classic stack problems
|   |   `-- Tries/
|   |       `-- Generic_Tree/             # Generic tree data members, display, size
|   `-- TUF/                              # Take U Forward / Striver-style practice
|       |-- Binary_Search/                # Binary search fundamentals and bounds
|       |-- Binary_Search_Tries/          # BST search, insert, floor, and ceil
|       `-- Binary_Tries/                 # Binary tree problems and traversals
|           |-- Iterative_Traversal/      # Iterative inorder/preorder/postorder
|           `-- Recursive_Traversal/      # Recursive inorder/preorder/postorder
`-- LeetCode/
    |-- Basic/                            # Starter problems with multiple approaches
    |-- 0426POTDs/                        # April 2026 POTD solutions
    |-- 0926POTDs/                        # September 2026 POTD solutions
    `-- LeetCode*.java                    # Main problem-numbered solutions
```

## Current Progress

| Area | Java files | Progress |
| --- | ---: | --- |
| LeetCode main solutions | 233 | Problem-numbered solution files such as `LeetCode100.java`, `LeetCode239.java`, and `LeetCode4039.java` |
| LeetCode Basic | 22 | Multiple approaches for starter array/string problems |
| April POTDs | 30 | Daily problem files from April challenge practice |
| September 2026 POTDs | 4 | `Sep01P3568.java` through `Sep04P3903.java` |
| DSA / Pepcoding | 62 | Basic math, arrays, linked lists, queues, stacks, and generic tree practice |
| DSA / TUF | 53 | Binary search, BST, binary tree traversals, views, construction, and path problems |
| DSA / Patterns | 1 | Core pattern-printing practice |

**Total:** 405 Java files.

## Content Overview

### DSA Folder

- **Patterns**: Foundational pattern-printing practice for loops and conditionals.
- **Pepcoding**: Structured DSA basics including arrays, number systems,
  linked lists, queues, stacks, and generic trees.
- **TUF**: Topic-wise implementations for binary search, binary search trees,
  binary trees, recursive traversal, iterative traversal, BFS/DFS, tree views,
  LCA, diameter, balance checks, construction, serialization, and tree paths.

### LeetCode Folder

- **Main solutions**: Problem-numbered Java files kept directly under
  `LeetCode/`.
- **Basic**: Early practice problems with multiple solution styles for the same
  concept, useful for comparing brute force and optimized approaches.
- **POTDs**: Monthly daily challenge folders, currently including April practice
  and September 2026 progress.

## Getting Started

### Prerequisites

- Java 8 or higher
- A Java IDE or editor such as IntelliJ IDEA, Eclipse, or VS Code

### Running Solutions

1. Clone or download the repository.
2. Open the target `.java` file in your preferred Java IDE.
3. Compile and run the file independently.
4. Review alternate files when a problem has multiple approaches.

Example:

```bash
javac LeetCode/LeetCode100.java
```

Many LeetCode files are solution classes intended for LeetCode or IDE-driven
testing. Files without a `main` method may need a small local test harness before
running from the command line.

## Problem Categories

- **Arrays and Strings**: traversal, prefix/suffix logic, sorting, reversing,
  string matching, and frequency counting.
- **Sliding Window**: fixed-size windows, variable-size windows, subarray counts,
  and character replacement patterns.
- **Two Pointers**: pair searching, partitioning, palindrome checks, and sorted
  array techniques.
- **Hashing**: maps, sets, frequency tables, grouping, and duplicate detection.
- **Stacks and Queues**: custom implementations, monotonic stacks, expression
  evaluation/conversion, brackets, and adapters.
- **Linked Lists**: add/get/remove operations, reversal, merge, sort, middle,
  kth-from-end, and cycle-related LeetCode practice.
- **Binary Search**: iterative/recursive search, lower bound, upper bound,
  floor, ceil, and search insert position.
- **Trees and BSTs**: traversals, views, depth, balance, diameter, LCA, paths,
  serialization/deserialization, construction, infection time, and BST
  operations.
- **Math and Number Systems**: GCD/LCM, primes, digit operations, base
  conversion, and base arithmetic.

## Notes

- This repository is organized for learning and revision rather than as a single
  buildable application.
- Folder names reflect the current repository layout. A few tree-related folders
  use the word `Tries`, but their contents include binary tree, BST, and generic
  tree practice.
- New progress is easiest to add by creating one Java file per problem or
  approach and then updating the progress table above.

---

**Last Updated:** September 2026
**Language:** Java
**Total Progress:** 405 Java files, including 289 LeetCode/POTD files and 116 DSA practice files
