package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MinHeapConstruction {
    public static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        private Optional<Integer> leftChild(int i, List<Integer> heap) {
            int leftIdx = 2 * i + 1;
            if (leftIdx > heap.size() - 1) {
                return Optional.empty();
            } else {
                return Optional.of(leftIdx);
            }
        }

        private Optional<Integer> rightChild(int i, List<Integer> heap) {
            int rightIdx = 2 * i + 2;
            if (rightIdx > heap.size() - 1) {
                return Optional.empty();
            } else {
                return Optional.of(rightIdx);
            }
        }

        private Optional<Integer> parent(int i) {
            if (i == 0) {
                return Optional.empty();
            } else {
                return Optional.of((int) Math.floor((double) (i - 1) / 2));
            }

        }

        private void swap(int i, int j, List<Integer> heap) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            Optional<Integer> lastParentNodeIdx = parent(array.size() - 1);
            if (lastParentNodeIdx.isPresent()) {
                for (int i = lastParentNodeIdx.get(); i >= 0; i--) {
                    siftDown(i, array.size() - 1, array);
                }
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            while (currentIdx < endIdx) {
                Optional<Integer> leftIdx = leftChild(currentIdx, heap);
                Optional<Integer> rightIdx = rightChild(currentIdx, heap);

                if (leftIdx.isPresent() && rightIdx.isPresent()) {

                    int lesserIdx;
                    if (heap.get(leftIdx.get()) < heap.get(rightIdx.get())) {
                        lesserIdx = leftIdx.get();
                    } else {
                        lesserIdx = rightIdx.get();
                    }

                    if (heap.get(lesserIdx) < heap.get(currentIdx)) {
                        swap(lesserIdx, currentIdx, heap);
                        currentIdx = lesserIdx;
                    } else {
                        return;
                    }
                } else if (leftIdx.isPresent() && heap.get(leftIdx.get()) < heap.get(currentIdx)) {
                    swap(leftIdx.get(), currentIdx, heap);
                    currentIdx = leftIdx.get();
                } else if (rightIdx.isPresent() && heap.get(rightIdx.get()) < heap.get(currentIdx)) {
                    swap(rightIdx.get(), currentIdx,heap);
                    currentIdx = rightIdx.get();
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            Optional<Integer> parentIdx = parent(currentIdx);
            while (parentIdx.isPresent() && heap.get(currentIdx) > heap.get(parentIdx.get())) {
                swap(parentIdx.get(), currentIdx, heap);
                parentIdx = parent(parentIdx.get());
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int val = heap.get(0);
            heap.set(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return val;
        }

        public void insert(int value) {
            // Add to end of array
            heap.add(value);

            // Sift up
            siftUp(heap.size() - 1, heap);
        }
    }
}
