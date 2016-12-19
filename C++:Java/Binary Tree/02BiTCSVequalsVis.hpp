// File: BiTreeCSV/BiTCSVequalsVis.hpp

#ifndef BITCSVEQUALSVIS_HPP_
#define BITCSVEQUALSVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
#include "BiTCSVisEmptyVis.hpp"
using namespace std;

template<class T> class BiTCSVequalsHelperVis; // Forward declaration.

// ========= BiTCSVequalsVis =========
template<class T>
class BiTCSVequalsVis : public ABiTreeCSVVis<T> {
private:
    const BiTreeCSV<T> &_rhs; // Input parameter.
    bool _result; // Output result.

public:
    // ========= Constructor =========
    BiTCSVequalsVis(const BiTreeCSV<T> &rhs):
        _rhs(rhs) {
    }

    // ========= visit =========
    void emptyCase(BiTreeCSV<T> &host) {
        _result = isEmpty(_rhs);
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        BiTCSVequalsHelperVis<T> equalsHelperVis(host.root(),host.left(),host.right());
_rhs.accept(equalsHelperVis);
_result = equalsHelperVis.result();
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
         _result = isEmpty(_rhs);
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        BiTCSVequalsHelperVis<T> equalsHelperVis(host.root(),host.left(),host.right());
_rhs.accept(equalsHelperVis);
_result = equalsHelperVis.result();
    }

    // ========= result =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: true is returned if the host tree is equal to rhs;
    // otherwise, false is returned.
    // Two trees are equal if they contain the same number of equal elements
    // with the same shape.
    bool result() const {
        return _result;
    }
};

// ========= BiTCSVequalsHelperVis =========
template<class T>
class BiTCSVequalsHelperVis : public ABiTreeCSVVis<T> {
private:
    T const &_data; // Input parameter.
    const BiTreeCSV<T> &_left; // Input parameter.
    const BiTreeCSV<T> &_right; // Input parameter.
    bool _result; // Output result.

public:
    // ========= Constructor =========
    BiTCSVequalsHelperVis
    (T const &data, const BiTreeCSV<T> &left, const BiTreeCSV<T> &right):
        _data(data), _left(left), _right(right) {
    }

    // ========= visit =========
    void emptyCase(BiTreeCSV<T> &host) {
        _result = false;
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        if(host.root() == _data){
_result = host.left() == _left && host.right() == _right;
}else _result = false;
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
         _result = isEmpty(_rhs);
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        if(host.root() == _data){
_result = host.left() == _left && host.right() == _right;
}else _result = false;
    }

    // ========= result =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: true is returned if root equals host.root(),
    // left equals host.left(), and right equals host.right();
    // otherwise, false is returned.
    bool result() const {
        return _result;
    }
};

// Global function for convenience.
// ========= operator== =========
template<class T>
bool operator==(const BiTreeCSV<T> &lhs, const BiTreeCSV<T> &rhs) {
    BiTCSVequalsVis<T> equalsVis(rhs);
lhs.accept(equalsVis);
return equalsVis.result();
}

#endif
