// File: BiTreeCSV/BiTCSVpostOrderVis.hpp

#ifndef BITCSVPOSTORDERVIS_HPP_
#define BITCSVPOSTORDERVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
using namespace std;

// ========= BiTCSVpostOrderVis =========
template<class T>
class BiTCSVpostOrderVis : public ABiTreeCSVVis<T> {
private:
    ostream &_os; // Input paramter.

public:
    // ========= Constructor =========
    BiTCSVpostOrderVis(ostream &os):
        _os(os) {
    }

    // ========= visit =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: A postOrder representation of this tree is sent to os.
    void emptyCase(BiTreeCSV<T> &host) {
        
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        host.left().accept(*this);
host.right().accept(*this);
_os << host.root() << " ";
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        host.left().accept(*this);
host.right().accept(*this);
_os << host.root() << " ";
    }
};

// Global function for convenience
template<class T>
void postOrder(ostream &os, const BiTreeCSV<T> &tree) {
    BiTCSVpostOrderVis<T> postOrderVis(os);
tree.accept(postOrderVis);
}

#endif
