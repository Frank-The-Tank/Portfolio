// File: QueueA/QueueA.hpp
// Frank Garcia 
// Assignment 13
// 10/23/15

#ifndef QUEUEA_HPP_
#define QUEUEA_HPP_

#include "ArrayT.hpp"

template<class T>
class QueueA {
private:
    ArrayT<T> _data;
    int _head, _tail;

public:
    QueueA(int cap);
    // Post: This queue is allocated with a capacity of iCap
    // and initialized to be empty.

    bool isEmpty() const;
    // Post: true is returned if this queue is empty; otherwise, false is returned.

    bool isFull() const;
    // Post: true is returned if this queue is full; otherwise, false is returned.

    void enqueue(const T &val);
    // Pre: This queue is not full.
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
QueueA<T>::QueueA(int cap) :
    _data(cap + 1),
    _head(0),
    _tail(0) {
}

template<class T>
bool QueueA<T>::isEmpty() const {
    return _head == _tail;
}

template<class T>
bool QueueA<T>::isFull() const {
    return _tail + 1 == _head;
}

template<class T>
void QueueA<T>::enqueue(const T &val) {
    _tail = _tail % _data.cap();
    _data[_tail++] = val;
}

template<class T>
T QueueA<T>::dequeue() {
    T temp = _data[_head];
    _head == _data.cap() ? (_head % _data.cap()) : _head++;
    return temp;
}

template<class T>
const T &QueueA<T>::headOf() const {
    return _data[_head];
}

template<class T>
ostream &operator<<(ostream &os, const QueueA<T> &rhs) {
    rhs.toStream(os);
    return os;
}

template<class T>
void QueueA<T>::toStream(ostream &os) const {
    os << "("; 
    int i = _head; 
    while (i != _tail) { 
        if (i == _data.cap() && (_tail < _head)) { 
            i =  i % _data.cap(); 
        } 
        if (i == _tail - 1) { 
            os << _data[i++]; 
        } else { 
            os << _data[i++] << ","; 
        } 
    } 
    os << ")";
}


#endif
