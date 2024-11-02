package me.ibrahim.datastructure_problemsolving.algorithms


fun main() {
    val cache = LRUCache<Int, String>(5)

    cache.put(1, "A")
    cache.put(2, "B")
    cache.put(3, "c")
    cache.put(4, "d")
    cache.put(5, "e")
    cache.put(6, "f")

    cache.get(2)
    cache.get(3)
    cache.get(5)
    cache.get(5)
    cache.get(5)
    cache.get(6)
    cache.printCache()
    cache.printLinkedList()
}

class LRUCache<K, V>(private val maxSize: Int) {

    private data class Node<K, V>(var key: K?, var value: V?, var next: Node<K, V>?, var previous: Node<K, V>?)

    private val head: Node<K, V> = Node(null, null, null, null)
    private val tail: Node<K, V> = Node(null, null, null, null)

    private val cache = mutableMapOf<K, Node<K, V>>()


    init {
        head.next = tail
        tail.previous = head
    }

    fun get(key: K): V? {
        val node = cache[key] ?: return null
        //move the node to head
        moveToHead(node)
        return node.value
    }

    fun put(key: K, value: V) {
        val node = cache[key]
        if (node != null) {
            node.value = value
            //move the node to head
            moveToHead(node)
        } else {
            val newNode = Node(key = key, value = value, next = null, previous = null)
            cache[key] = newNode
            addNode(newNode)

            if (cache.size > maxSize) {
                val tail = popTail()
                tail?.key?.let {
                    cache.remove(it)
                }
            }
        }
    }

    private fun moveToHead(node: Node<K, V>) {
        node.previous = head
        node.next = head.next
        head.next?.previous = node
        head.next = node
    }

    private fun popTail(): Node<K, V>? {
        val res = tail.previous
        if (res != head) {
            removeNode(res)
        }
        return res
    }

    private fun removeNode(node: Node<K, V>?) {
        val previous = node?.previous
        val next = node?.next
        previous?.next = next
        next?.previous = previous
    }

    private fun addNode(newNode: Node<K, V>) {
        newNode.next = head.next
        newNode.previous = head
        head.next?.previous = newNode
        head.next = newNode
    }

    fun printCache() {
        val printableCache = cache.map { Pair(it.key, it.value.value) }
        println(printableCache)
    }

    fun printLinkedList() {
        var current = head.next

        while (current != null) {
            print("${current.value} => ")
            current = current.next
        }
    }
}