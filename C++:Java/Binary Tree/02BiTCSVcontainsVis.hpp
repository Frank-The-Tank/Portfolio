// File: BiTreeCSV/BiTCSVcontainsVis.hpp

#ifndef BITCSVCONTAINSVIS_HPP_
#define BITCSVCONTAINSVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
using namespace std;

// ========= BiTCSVcontainsVis =========
template<class T>
class BiTCSVcontainsVis : public ABiTreeCSVVis<T> {
private:
    T _data; // Input parameter.
    bool _result; // Output result.

public:
    // ========= Constructor =========
    BiTCSVcontainsVis(T data):
        _data(data) {
    }

    // ========= visit =========
    void emptyCase(BiTreeCSV<T> &host) {
        _result = false;
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        _result = host.root()==_data || contains(_data, host.left()) || contains(_data,
host.right());
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        _result = false; 
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        _result = host.root()==_data || contains(_data, host.left()) || contains(_data,
host.right());
    }

    // ========= result =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: true is returned if val is contained in this tree;
    // otherwise, false is returned.
    bool result() const {
        return _result; 
    }
};

// Global function for convenience
template<class T>
bool contains(T data, const BiTreeCSV<T> &tree) {
    BiTCSVcontainsVis<T> containsVis(tree);
    tree.accept(containsVis);
    return containsVis.result();
}

#endif
