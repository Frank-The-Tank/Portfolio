// File: BiTreeCSV/BiTCSVheightVis.hpp

#ifndef BITCSVHEIGHTVIS_HPP_
#define BITCSVHEIGHTVIS_HPP_

#include <iostream>
#include "BiTreeCSV.hpp"
#include "ABiTreeCSVVis.hpp"
using namespace std;

// ========= BiTCSVheightVis =========
template<class T>
class BiTCSVheightVis : public ABiTreeCSVVis<T> {
private:
    int _result; // Output result.

public:
    // ========= Constructor =========
    BiTCSVheightVis() {
    }

    // ========= visit =========
    void emptyCase(BiTreeCSV<T> &host) {
        _result = 0;
    }

    void nonEmptyCase(BiTreeCSV<T> &host) {
        host.left().accept(*this);
int leftHeight = _result;
host.right().accept(*this);
int rightHeight = _result;
if( leftHeight > rightHeight){
_result = 1 + leftHeight;
}else _result = 1 + rightHeight;
    }

    // ========= visit const =========
    void emptyCase(const BiTreeCSV<T> &host) {
        _result = 0;
    }

    void nonEmptyCase(const BiTreeCSV<T> &host) {
        host.left().accept(*this);
int leftHeight = _result;
host.right().accept(*this);
int rightHeight = _result;
if( leftHeight > rightHeight){
_result = 1 + leftHeight;
}else _result = 1 + rightHeight;
    }

    // ========= result =========
    // Pre: This visitor has been accepted by a host tree.
    // Post: The height of the host tree is returned.
    int result() const {
        return _result; 
    }
};

// Global function for convenience
template<class T>
int height(const BiTreeCSV<T> &tree) {
    BiTCSVheightVis<T> heightVis;
tree.accept(heightVis);
return heightVis.result();
}

#endif
