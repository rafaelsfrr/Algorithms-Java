### [Array List](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/ArrayList.java)

An Array List is a simple array with a default size that is dynamically refreshed when items are inserted.

|      Operation       |            Time bound             |
| :------------------: | :-------------------------------: |
|        Insert        |               O(1)                |
| Insert  (worst case) | O(N)<sup>[1](#insert_al_ft)</sup> |
|         Get          |               O(1)                |
|        Search        |               O(N)                |
|        Remove        | O(N)<sup>[2](#remove_al_ft)</sup> |

<a name="insert_al_ft">1</a>: We have to create another array with a bigger size, for example, 2N and copy element by element to the new array.

<a name="remove_al_ft">2</a>: We have to create another array and copy all items less the item that will be removed.

### [Linked List](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/LinkedList.java)

An Linked List is a structure of data elements that each element has a link to its successor. This implementation is a Singly-Linked List, so each element has only a link to its successor. There is a Doubly-Linked List that each element has a link to its predecessor too.

| Operation  |            Time bound             |
| :--------: | :-------------------------------: |
|   Insert   | O(1)<sup>[1](#insert_ll_ft)</sup> |
| Get First  |               O(1)                |
| GetByIndex |               O(N)                |
|   Search   |               O(N)                |
|   Remove   | O(1)<sup>[2](#remove_ll_ft)</sup> |

<a name="insert_ll_ft">1</a>: It is O(1) because we insert an element on the first position utilizing a LIFO scheme.

<a name="remove_ll_ft">2</a>:  It is O(1) because we remove an element on the first position utilizing a LIFO scheme.

### [Hash Map](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/HashMap.java)

A Hash Map is a data structure that maps keys to values. In this implementation, the hash function is a simple `element.key % array.size` operation. The conflict is managed by a Singly-Linked List.

| Operation |                Time bound                |
| :-------: | :--------------------------------------: |
|  Insert   |                   O(1)                   |
|    Get    | O(1), O(list.size)<sup>[1](#get_hm_ft)</sup> |
|  Remove   | O(1), O(list.size)<sup>[1](#remove_hm_ft)</sup> |

<a name="get_hm_ft">1</a>: It is O(1) when we haven't a conflict. But when we have, we need to search on a Singly-Linked List getting a O(list.size) operation.

<a name="remove_hm_ft">2</a>:  It is O(1) when we haven't a conflict, resulting in a array element excluded. But, when we have, we need to search on a Singly-Linked List getting a O(list.size) operation. 

### [String Builder](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/StringBuilder.java)

A String Builder is a ArrayList that is used as a container to strings characters, thus creating a dynamically string. With this implementation, we can avoid creating a new string each time we want to append a character.

### [Queue](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/Queue.java)

A Queue is a FIFO(first-in, first-out) data structure.

| Operation | Time bound                               |
| :-------: | :--------------------------------------: |
| Insert    |              O(1)                        |
| Search    |              O(N)                        |
| Access    |              O(N)                        |
| Remove    |              O(1)                        |

### [Stack](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/Stack.java)


A Stack is a LIFO(last-in, first-out) data structure.

| Operation | Time bound                               |
| :-------: | :--------------------------------------: |
| Insert    |              O(1)                        |
| Search    |              O(N)                        |
| Access    |              O(N)                        |
| Remove    |              O(1)                        |

### [Binary Search Tree](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/BST.java)

A Binary Search Tree is a data structure that keeps keys in sorted order. Therefore, every operation on the tree - i.e., search, insert, remove, needs to traverse the tree from root to leaf. In this implementation, the left childs of a parent node have keys that are less or equal than the parent node key and the right childs have keys that are greater than the parent node key.

| Operation | Time bound <sup>[1](#tree_ft)</sup>      |
| :-------: | :--------------------------------------: |
| Insert    |              O(log(N)), O(N)             |
| Search    |              O(log(N)), O(N)             |
| Access    |              O(log(N)), O(N)             |
| Remove    |              O(log(N)), O(N)             |

<a name="tree_ft">1</a>: It is O(log(N)) when the tree is balanced.

### [Trie](https://github.com/rafaelsfrr/Algorithms-Java/blob/master/src/local/algorithms/Trie.java)

A Trie is a kind of search tree that all the descendants of a node have a common prefix of the key associated with that node. This structure is usually used to find common prefix. For example, using a trie to store all the english words, you can check if a given word is a valid english word. 
