// File: BiTreeCSV/BiTCSVclearVis.hpp

#ifndef BITCSVCLEARVIS_HPP_
#define BITCSVCLEARVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
using namespace std;

// ========= BiTCSVclearVis =========
template<class T>
class BiTCSVclearVis : public ABiTreeCSVVis<T> {
public:
    // ========= Constructor =========
    BiTCSVclearVis() {
    }

    // ========= visit =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: This tree is cleared to the empty tree.
    void emptyCase(BiTreeCSV<T> &host) {
        
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        host.left().accept(*this);
        host.right().accept(*this);
        host.remRoot();
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        cerr << "BiTCSVclearVis precondition violated: "
             << "Cannot clear a const tree." << endl;
        throw -1;
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        cerr << "BiTCSVclearVis precondition violated: "
             << "Cannot clear a const tree." << endl;
        throw -1;
    }
};

// Global function for convenience
template<class T>
void clear(BiTreeCSV<T> &tree) {
    BiTCSVclearVis<T> clearVis;
    tree.accept(clearVis);
}

#endif