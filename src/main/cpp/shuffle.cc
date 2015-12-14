#include <iostream>
#include <cstdlib>
#include <ctime>
#include "cgicc/Cgicc.h"
#include "cgicc/HTTPPlainHeader.h"
#include "cgicc/HTMLClasses.h"
#include "util.h"

using namespace std;
using namespace cgicc;

static const int N_SHUFFLE = 1000;

int main(int argc, char **argv) {
    string board = "";
    int size;
    int move;
    if (argc == 2) {
        size = stoi(argv[1]);
    } else {
        Cgicc cgi;
        cout << HTTPPlainHeader();
        form_iterator p_size = cgi.getElement("size");
        if ( p_size != cgi.getElements().end()) {
            size = stoi(cgi("size"));
        }
    }
    for (size_t i = 0; i < size * size - 1; ++i) {
        board += to_string(i + 1);
    }
    board += "0";
    srand(time(nullptr));
    for (size_t i = 0; i < N_SHUFFLE; ++i) {
        const int r = rand() % (size * size);
        board = swap(board, size, r);
    }
    cout << board << endl;
    return 0;
}
