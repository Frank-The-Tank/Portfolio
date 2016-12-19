// File: StackA/StackA.hpp
// Git test 2
// Frank Garcia 
// Assignment 13
// 10/23/15

#ifndef STACKA_HPP_
#define STACKA_HPP_

#include "ArrayT.hpp"

template<class T>
class StackA {
private:
    ArrayT<T> _data;
    int _top;

public:
    StackA(int cap);
    // Post: This stack is allocated with a capacity of cap
    // and initialized to be empty.

    bool isEmpty() const;
    // Post: true is returned if this stack is empty; otherwise, false is returned.

    bool isFull() const;
    // Post: true is returned if this stack is full; otherwise, false is returned.

    void push(const T &val);
    // Pre: This stack is not full.
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
StackA<T>::StackA(int cap):
    _data(cap),
    _top(-1) {
}

template<class T>
bool StackA<T>::isEmpty() const {
    return _top == -1;
}

template<class T>
bool StackA<T>::isFull() const {
    return _top + 1 == _data.cap();
}

template<class T>
void StackA<T>::push(const T &val) {
    _data[++_top] = val;
}

template<class T>
T StackA<T>::pop() {
    if (isEmpty()) {
        cerr << "pop precondition violated: Cannot pop from an empty stack." << endl;
        throw -1;
    }
    return _data[_top--];
}

template<class T>
const T &StackA<T>::topOf() const {
    if (isEmpty()) {
        cerr << "topOf precondition violated: An empty stack has no top." << endl;
        throw -1;
    }
    return _data[_top];
}

template<class T>
ostream &operator<<(ostream &os, const StackA<T> &rhs) {
    rhs.toStream(os);
    return os;
}

template<class T>
void StackA<T>::toStream(ostream &os) const {
    os << "(";
    for (int i = _top; i > 0; i--) {
        os << _data[i] << ", ";
    }
    if (_top == -1) {
        os << ")";
    }
    else {
        os << _data[0] << ")";
    }
}

#endif
