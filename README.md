# Interesting Code
This is a repository of implementations of interesting algorithms.

## Algorithms
| Algorithm                                                                              | Language        | Runtime Complexity              | Description                                                                                                                                                                                   |
| -------------------------------------------------------------------------------------- | :-------------: | :-----------------------------: | ------------------                                                                                                                                                                            |
| [Karatsuba’s Algorithm](http://en.wikipedia.org/wiki/Karatsuba_algorithm)              | Java            | O(n<sup>log<sub>2</sub>3</sup>) | A divide and conquer algorithm for fast integer multiplication. The algorithm reduces the number of recursive calls from 4 in the naive grade school algorithm to 3.                          |
| [Mergesort](http://en.wikipedia.org/wiki/Merge_sort)                                   | Java            | O(n log n)                      | A divide and conquer algorithm for fast sorting.                                                                                                                                              |
| [Inversion](http://en.wikipedia.org/wiki/Inversion_%28discrete_mathematics%29) Counter | Java            | O(n log n)                      | A fast algorithm for for counting the occurrences that an element is outside of its natural order. The algorithm builds on mergesort, adding the count proceedure to the merge subroutine.    |
| [Strassen’s Algorithm](http://en.wikipedia.org/wiki/Strassen_algorithm)                | Java            | O(n<sup>log<sub>2</sub>7</sup>) | A divide and conquer algorithm for fast matrix multiplication. The algorithm cleverly reduces the reduces the number of recursive calls from 8 in the naive approach to 7.                    |
| [Closest Pair](http://en.wikipedia.org/wiki/Closest_pair_of_points_problem) Algorithm  | Java            | O(n log n)                      | An algorithm for finding the shortest Euclidean distance between a set of points. Uses sorting a preprocessing step and a divide and conquer approach.                                        |
| [Quicksort](http://en.wikipedia.org/wiki/Quicksort)                                    | Java            | O(n log n)                      | A randomized divide and conquer algorithm for fast sorting. Runs in constant space.                                                                                                           |
| [Quickselect](http://en.wikipedia.org/wiki/Quickselect)                                | Java            | O(n)                            | A divide and conquer algorithm for selecting a element in an unsorted collection. Resembles quicksort with one fewer recursive calls.                                                         |
| [Heapsort](http://en.wikipedia.org/wiki/Heapsort)                                      | Java            | O(n log n)                      | Implemented as a min heap priority queue. Enqueues and dequeues maintain a heap meaning that repeated dequeues will sort the input. This generic implmentation is built using a storage arary |

## Data Structures
| Data Structure | Language | Supported Operation | Runtime Complexity |
| -------------- | :-----:  | :-----------------: | ------------------ |

### TODO
| TODO                                                                                   | Description                                                         |
| -------------------------------------------------------------------------------------- | -------------------------------                                     |
| [Karger’s Algorithm](http://en.wikipedia.org/wiki/Karger%27s_algorithm)                | An algorithm for finding minimum cuts in a graph.                   |
| [Kosaraju’s Algorithm](http://en.wikipedia.org/wiki/Kosaraju%27s_algorithm)            | An algorithm for finding strongly connected components in a graph.  |
| [Dijkstra’s Algorithm](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)            | An algorithm for finding the shortest paths between nodes in graph. |
| [Kruskal’s Algorithm](http://en.wikipedia.org/wiki/Kruskal%27s_algorithm)              | A greedy algorithm for finding minimum spanning trees.              |

