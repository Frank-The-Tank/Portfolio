// File: BiTreeCSV/BiTCSVnumLeavesVis.hpp

#ifndef BITCSVNUMLEAVESVIS_HPP_
#define BITCSVNUMLEAVESVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
#include "BiTCSVisEmptyVis.hpp"
using namespace std;

// ========= BiTCSVnumLeavesVis =========
template<class T>
class BiTCSVnumLeavesVis : public ABiTreeCSVVis<T> {
private:
    int _result; // Output result.

public:
    // ========= Constructor =========
    BiTCSVnumLeavesVis():
        _result(0) {
    }

    // ========= visit =========
    void emptyCase(BiTreeCSV<T> &host) {
        _result = 0;
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        result = (isEmpty(host.left()) && isEmpty(host.right()) ? 1 :
        numLeaves(host.left())+numLeaves(host.right()));
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        _result = 0;
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        _result = (isEmpty(host.left()) && isEmpty(host.right()) ? 1 :
numLeaves(host.left())+numLeaves(host.right()));
    }

    // ========= result =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: The number of leaves of the host tree is returned.
    int result() const {
        return _result; 
    }
};

// Global function for convenience
template<class T>
int numLeaves(const BiTreeCSV<T> &tree) {
    BiTCSVnumLeavesVis<T> numLeavesVis;
    tree.accept(numLeavesVis);
    return numLeavesVis.result();
}

#endif
