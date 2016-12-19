// File: ASorter/Heapifier.hpp

#ifndef HEAPIFIER_HPP_
#define HEAPIFIER_HPP_

#include "ASeq.hpp"

template<class T>
void siftUp(ASeq<T> &a, int lo, int i) {
    // Pre: maxHeap(a[lo..i - 1]).
    // Post: maxHeap(a[lo..i]).
    T temp = a[i];
    int parent = (i + lo - 1) / 2;
    while (lo < i && a[parent] < temp) {
        a[i] = a[parent];
        i = parent;
        parent = (i + lo - 1) / 2;
    }
    a[i] = temp;
}

template<class T>
void siftDown(ASeq<T> &a, int lo, int i, int hi) {
    // Pre: maxHeap(a[i + 1..hi]).
    // Pre: lo <= i <= hi.
    // Post: maxHeap(a[i..hi]).
    int child = 2 * i - lo + 1; // Index of left child.
    bool done = hi < child;
    T valueStored = a[lo];
    T comparingValue = valueStored;
    while (!done) {
        if (child < hi && a[child] < a[child + 1]) {
            child++; 
        }
        if (comparingValue < a[child]) {
            a[i] = a[child];
            i = child; 
            child = 2 * i - lo + 1; // Index of the left child
            done = hi < child; 
        } else {
            done = true; 
        }
    }
    a[i] = valueStored; 
}

#endif
