// leetcode 706 Design HashMap

/*
time: O(1)
space: O()
*/

/*
原理是需要用array来实现random access，保证平均情况下hashmap的put和get是O（1）的，如果出现了collision，
那么可以选择使用linkedlist来处理collision的情况，所以在put get 和remove的时候，需要一个while loop
来查找所有collision的元素，导致worst case是O（n）因此我在这里把listnode改变了一下结构，使其能够同时存储key和value，
便于查找，同时需要保证key是final无法被改变。
*/

class MyHashMap {
    class Node {
        final int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final int SIZE = 10001;
    Node[] array;
    public MyHashMap() {
         array = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key); 
        Node head = array[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
    }


    public int get(int key) {
        int index = hash(key);
        Node node = array[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node node = array[index];
        while (node != null) {
            if (node.key == key) {
                node.value = -1;
                return;
            }
            node = node.next;
        }

    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
}