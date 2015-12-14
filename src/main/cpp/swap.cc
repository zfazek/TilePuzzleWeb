#include <iostream>
#include "cgicc/Cgicc.h"
#include "cgicc/HTTPPlainHeader.h"
#include "cgicc/HTMLClasses.h"
#include "util.h"

using namespace std;
using namespace cgicc;

int main(int argc, char **argv) {
    string board;
    int size;
    int move;
    if (argc == 4) {
        board = argv[1];
        size = stoi(argv[2]);
        move = stoi(argv[3]);
    } else {
        Cgicc cgi;
        cout << HTTPPlainHeader();
        form_iterator p_board = cgi.getElement("board");
        form_iterator p_size = cgi.getElement("size");
        form_iterator p_move = cgi.getElement("move");
        if (p_board != cgi.getElements().end() &&
                p_size != cgi.getElements().end() &&
                p_move != cgi.getElements().end()) {
            board = cgi("board");
            size = stoi(cgi("size"));
            move = stoi(cgi("move"));
        }
    }
    string new_board = swap(board, size, move);
    if (new_board != "") {
        cout << new_board << endl;
    }
    return 0;
}
