#include "util.h"
#include <cstdlib>

std::string swap(const std::string board,
        const int size,
        const int move) {
    if (board == "") return "";
    int length = board.size();
    if (move > length - 1 || move < 0) return board;
    const size_t idx0 = board.find_first_of('0');
    if (idx0 == std::string::npos) return board;
    if (! (abs(move - idx0) == 1 || abs(move - idx0) == size)) {
        return board;
    }
    if (idx0 % size == 0 && move == idx0 - 1) return board;
    if (idx0 % size == size - 1 && move == idx0 + 1) return board;
    std::string ret = board;
    const char temp = ret[idx0];
    ret[idx0] = ret[move];
    ret[move] = temp;
    return ret;
}
