package algo.expert.solutions.veryhard;

import java.util.HashMap;

public class LRUCacheProgram {
    public static class LRUCache {
        HashMap<String, DLLNode> cache = new HashMap<>();
        DLLNode tail = null;
        DLLNode head = null;
        int maxSize;

        public LRUCache(int maxSize) {
            System.out.println(maxSize);
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            System.out.println(String.format("insert: %s", key));
            DLLNode node = new DLLNode(key, value);

            if (cache.size() >= maxSize) {

                // evict
                this.print();
                cache.remove(tail.key);

                if (cache.isEmpty()) {
                    tail = null;
                    head = null;
                } else {
                    tail = tail.next;
                    tail.prev = null;
                }

            }

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.prev = head;
                head.next = node;
                head = node;
            }

            cache.put(key, node);
        }

        public LRUResult getValueFromKey(String key) {
            System.out.println(String.format("get: %s", key));

            DLLNode node = cache.get(key);
            if (node != null) {
                if (node.prev == null && node.next == null) {
                    // only 1 node

                    // do nothing
                } else if (node.prev == null) {
                    // tail node

                    // new tail node
                    tail = node.next;
                    tail.prev = null;

                    // move node to head
                    head.next = node;
                    node.prev = head;
                    node.next = null;
                    head = node;
                } else if (node.next == null) {
                    // head node
                    // do nothing for head node
                } else {
                    // middle node
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                    // move node to head
                    head.next = node;
                    node.prev = head;
                    node.next = null;
                    head = node;
                }

                return new LRUResult(true, node.value);
            } else {
                return new LRUResult(false, -1);
            }
        }

        public String getMostRecentKey() {
            if (head != null) {
                return head.key;
            } else {
                return null;
            }
        }

        public void print() {
            System.out.println(String.format("tail: %s", tail));
            System.out.println(String.format("head: %s", head));
            System.out.println(String.format("cache: %s", cache));

            DLLNode next = tail;
            while (next != null) {
                System.out.print(String.format(" %s ->", next.key));
                next = next.next;
            }
            System.out.println("");
            System.out.println("---------------");
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    static class DLLNode {
        DLLNode next;
        DLLNode prev;
        int value;
        String key;

        DLLNode(String key, int value) {
            this.value = value;
            this.key = key;
        }

        public String toString() {
            return String.format("DLLNode(key=%s)", key);
        }
    }
}
