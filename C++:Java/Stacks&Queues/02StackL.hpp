// File: StackL/StackL.hpp
// Frank Garcia 
// Assignment 13
// 10/23/15

#ifndef STACKL_HPP_
#define STACKL_HPP_

#include <iostream> // ostream.
#include "ListL.hpp"
using namespace std;

template<class T>
class StackL {
private:
    ListL<T>* listL;

public:
    StackL();
    // This stack is initialized to be empty.

    ~StackL();
    // Post: This stack is deallocated.

    bool isEmpty() const ;
    // Post: true is returned if this stack is empty; otherwise, false is returned.

    void push(const T &val);
    // Post: val is stored on top of this stack.

    T pop();
    // Pre: This stack is not empty.
    // Post: The top value in this stack is removed and returned.

    const T &topOf() const;
    // Pre: This stack is not empty.
    // Post: The top value from this stack is returned.

    void toStream(ostream &os) const;
    // Post: All the items on this stack from top to bottom are written to os.
};

template<class T>
StackL<T>::StackL() {
    listL = new ListL<T>();
}

template<class T>
StackL<T>::~StackL() {
    delete listL;
}

template<class T>
bool StackL<T>::isEmpty() const {
    return listL->isEmpty();
}

template<class T>
void StackL<T>::push(const T &val) {
    listL->prepend(val);
}

template<class T>
T StackL<T>::pop() {
    if (listL->isEmpty()) {
        cerr << "Can't pop from an empty list!" << endl;
        throw -1;
    }
    return listL->remFirst();
}

template<class T>
const T &StackL<T>::topOf() const {
    if (listL->isEmpty()) {
        cerr << "Can't topOf from an empty list!" << endl;
        throw -1;
    }
    return listL->first();
}

template<class T>
ostream &operator<<(ostream &os, const StackL<T> &rhs) {
    rhs.toStream(os);
    return os;
}

template<class T>
void StackL<T>::toStream(ostream &os) const {
    listL->toStream(os);
}

#endif
