package algo.expert.solutions.easy

import algo.expert.utils.SinglyLinkedList as LinkedList

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    var curr: LinkedList? = linkedList
    var next: LinkedList? = curr!!.next

    while (next != null) {
        if (curr!!.value != next.value) {
            curr.next = next
            curr = next
        } else {
            curr.next = null
        }
        next = next.next
    }

    return linkedList
}
