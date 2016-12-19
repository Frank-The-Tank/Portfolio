// File: BiTreeCSV/BiTCSVinOrderVis.hpp

#ifndef BITINORDERVIS_HPP_
#define BITINORDERVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
using namespace std;

// ========= BiTCSVinOrderVis =========
template<class T>
class BiTCSVinOrderVis : public ABiTreeCSVVis<T> {
private:
    ostream &_os; // Input paramter.

public:
    // ========= Constructor =========
    BiTCSVinOrderVis(ostream &os):
        _os(os) {
    }

    // ========= visit =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: A inOrder representation of this tree is sent to os.
    void emptyCase(BiTreeCSV<T> &host) {
        
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        host.left().accept(*this);
_os << host.root() << " ";
host.right().accept(*this);
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        host.left().accept(*this);
_os << host.root() << " ";
host.right().accept(*this);
    }
};

// Global function for convenience
template<class T>
void inOrder(ostream &os, const BiTreeCSV<T> &tree) {
    BiTCSVinOrderVis<T> inOrderVis(os);
tree.accept(inOrderVis);
}

#endif
