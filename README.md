# Algorithms

This is a repository with some algorithms resources like notes and some implementations in Java.

## Data Structures

### [Array List](data-structures/src/local/algorithms/ArrayList.java)

An Array List is a simple array with a default size that is dynamically refreshed when items are inserted.

|      Operation       |           Time bound           |
| :------------------: | :----------------------------: |
|        Insert        |              O(1)              |
| Insert  (worst case) | O(N)<sup>[1](#insert_ft)</sup> |
|         Get          |              O(1)              |
|        Search        |              O(N)              |
|        Remove        | O(N)<sup>[2](#remove_ft)</sup> |

<a name="insert_ft">1</a>: We have to create another array with a bigger size, for example, 2N and copy element by element to the new array.

<a name="remove_ft">2</a>: We have to create another array and copy all items less the item that will be removed.
