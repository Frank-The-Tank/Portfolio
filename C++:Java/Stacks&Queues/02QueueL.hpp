// File: QueueL/QueueL.hpp
// Frank Garcia 
// Assignment 13
// 10/23/15

#ifndef QUEUEL_HPP_
#define QUEUEL_HPP_

#include <iostream> // ostream.
#include "ListL.hpp"
using namespace std;

template<class T>
class QueueL {
private:
    // Attribute is exercise for the student.
    ListL<T>* listL;

public:
    QueueL();
    // This queue is allocated and initialized to be empty.

    ~QueueL();
    // Post: This queue is deallocated.

    bool isEmpty() const;
    // Post: true is returned if this queue is empty; otherwise, false is returned.

    void enqueue(const T &val);
    // Post: val is stored at the tail of this queue.

    T dequeue();
    // Pre: This queue is not empty.
    // Post: The head value in this queue is removed and returned.

    const T &headOf() const;
    // Pre: This queue is not empty.
    // Post: The head value from this queue is returned.

    void toStream(ostream &os) const;
    // Post: All the items on this queue from tail to head are written to os.
};

template<class T>
QueueL<T>::QueueL() {
    listL = new ListL<T>();
}

template<class T>
QueueL<T>::~QueueL() {
    delete listL;
}

template<class T>
bool QueueL<T>::isEmpty() const {
    return listL->isEmpty();
}

template<class T>
void QueueL<T>::enqueue(const T &val) {
    listL->prepend(val);
}

template<class T>
T QueueL<T>::dequeue() {
    if (listL->isEmpty()) {
        cerr << "Can't dequeue from an empty queue!" << endl;
        throw -1;
    }
    return listL->remLast();
}

template<class T>
const T &QueueL<T>::headOf() const {
    if (listL->isEmpty()) {
        cerr << "There is no head of an empty queue!" << endl;
        throw -1;
    }
    return listL->first();
}

template<class T>
ostream &operator<<(ostream &os, const QueueL<T> &rhs) {
    rhs.toStream(os);
    return os;
}

template<class T>
void QueueL<T>::toStream(ostream &os) const {
    listL->toStream(os);
}

#endif

