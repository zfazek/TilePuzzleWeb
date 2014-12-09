
public class Util {

    public static String swap(String board, int size, int move) {
        if (board == null) return null;
        int length = board.length();
        if (move > length - 1 || move < 0) return board;
        int idx0 = board.indexOf('0');
        if (idx0 < 0) return board;
        if (! (Math.abs(move - idx0) == 1 || Math.abs(move - idx0) == size)) {
            return board;
        }
        if (idx0 % size == 0 && move == idx0 - 1) return board;
        if (idx0 % size == size - 1 && move == idx0 + 1) return board;
        StringBuilder sb = new StringBuilder(board);
        char temp = sb.charAt(idx0);
        sb.setCharAt(idx0, sb.charAt(move));
        sb.setCharAt(move, temp);
        return sb.toString();
    }
}
