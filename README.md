# Algorithms

This is a repository with some algorithms resources like notes and some implementations in Java.

## Data Structures

### [Array List](src/local/algorithms/ArrayList.java)

An Array List is a simple array with a default size that is dynamically refreshed when items are inserted.

|      Operation       |           Time bound           |
| :------------------: | :----------------------------: |
|        Insert        |              O(1)              |
| Insert  (worst case) | O(N)<sup>[1](#insert_al_ft)</sup> |
|         Get          |              O(1)              |
|        Search        |              O(N)              |
|        Remove        | O(N)<sup>[2](#remove_al_ft)</sup> |

<a name="insert_al_ft">1</a>: We have to create another array with a bigger size, for example, 2N and copy element by element to the new array.

<a name="remove_al_ft">2</a>: We have to create another array and copy all items less the item that will be removed.

### [Linked List](src/local/algorithms/LinkedList.java)

An Linked List is a structure of data elements that each element has a link to its successor. This implementation is a Singly-Linked List, so each element has only a link to its successor. There is a Doubly-Linked List that each element has a link to its predecessor too.

|      Operation       |           Time bound           |
| :------------------: | :----------------------------: |
|        Insert        | O(1)<sup>[1](#insert_ll_ft)</sup>  |
|        Get First     |               O(1)             |
|        GetByIndex    |              O(N)              |
|        Search        |              O(N)              |
|        Remove        | O(1)<sup>[2](#remove_ll_ft)</sup> |

<a name="insert_ll_ft">1</a>: It is O(1) because we insert an element on the first position utilizing a LIFO scheme.

<a name="remove_ll_ft">2</a>:  It is O(1) because we remove an element on the first position utilizing a LIFO scheme.
