// File ASorter/InsertSorter.hpp
// Frank Garcia
// 9/29/15

#ifndef INSERTSORTER_HPP_
#define INSERTSORTER_HPP_

#include "ASorter.hpp"

template<class T>
class InsertSorter : public ASorter<T> {
public:
    ~InsertSorter() {
    }

protected:
    virtual void split(ASeq<T>&, int lo, int &mid, int hi);
    virtual void join(ASeq<T>&, int lo, int mid, int hi);
};

template<class T>
void InsertSorter<T>::split(ASeq<T> &, int, int &mid, int hi) {
    // Post: mid == hi.
    mid = hi;
}

template<class T>
void InsertSorter<T>::join(ASeq<T> &a, int lo, int mid, int hi) {
    // Pre: mid == hi && sorted(a[lo..hi - 1]).
    // Post: sorted(a[lo..hi]).
    int j = mid;
    T key = a[mid];
    while (lo < j && key < a[j - 1]) {
        a[j] = a[j - 1];
        j--;
    }
    a[j] = key;
}

#endif
