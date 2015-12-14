<!DOCTYPE html>
<html lang="en">
    <style>
        h1 {
            text-align: center;
        }
        button {
            font-size: 3em;
            height: 100px;
            width: 100px;
        }
        #buttons, #result_move {
            text-align: center;
        }
    </style>
    <head>
        <title>Tile Puzzle</title>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script>
            var board = "";
            var size = 3;
            var n_move = 0;

            function printBoardButtons() {
                $('#b0').text(board.charAt(0));
                $('#b1').text(board.charAt(1));
                $('#b2').text(board.charAt(2));
                $('#b3').text(board.charAt(3));
                $('#b4').text(board.charAt(4));
                $('#b5').text(board.charAt(5));
                $('#b6').text(board.charAt(6));
                $('#b7').text(board.charAt(7));
                $('#b8').text(board.charAt(8));
                $('button').css('visibility', 'visible');
                if ($('#b0').text() === "0") {
                    $("#b0").css('visibility', 'hidden');
                }
                if ($('#b1').text() === "0") {
                    $("#b1").css('visibility', 'hidden');
                }
                if ($('#b2').text() === "0") {
                    $("#b2").css('visibility', 'hidden');
                }
                if ($('#b3').text() === "0") {
                    $("#b3").css('visibility', 'hidden');
                }
                if ($('#b4').text() === "0") {
                    $("#b4").css('visibility', 'hidden');
                }
                if ($('#b5').text() === "0") {
                    $("#b5").css('visibility', 'hidden');
                }
                if ($('#b6').text() === "0") {
                    $("#b6").css('visibility', 'hidden');
                }
                if ($('#b7').text() === "0") {
                    $("#b7").css('visibility', 'hidden');
                }
                if ($('#b8').text() === "0") {
                    $("#b8").css('visibility', 'hidden');
                }
            }

            function isDone() {
                for (i = 0; i < size * size - 1; i++) {
                    if (board.charAt(i) != (i + 1)) {
                        return false;
                    }
                }
                return true;
            }

            function clickFunction(move) {
                $.ajax({
                        url: "/cgi-bin/swap.cgi",
                        type: "post",
                        data:"board=" + board +
                            "&size=" + size +
                            "&move=" + move,
                        success: function(data) {
                            if (data !== board) {
                                n_move++;
                            }
                            board = data;
                            printBoardButtons();
                            if (n_move === 1) {
                                $('#result_move').text(n_move + " move");
                            } else {
                                $('#result_move').text(n_move + " moves");
                            }
                            if (isDone()) {
                                if (n_move === 1) {
                                    $('#result_move').text("You solved it in 1 move!");
                                    alert("You solved it in 1 move!");
                                } else {
                                    $('#result_move').text("You solved it in " + n_move + " moves!");
                                    alert("You solved it in " + n_move + " moves!");
                                }
                            }
                        }
                });
            }

            function readyFunction() {
                $.ajax({
                        url: "/cgi-bin/shuffle.cgi",
                        type: "post",
                        data: "size=3",
                        success: function(data) {
                            board = data;
                            printBoardButtons();
                        }
                });

                 $('#b0').click(function() {
                     clickFunction(0);
                 });
                 $('#b1').click(function() {
                     clickFunction(1);
                 });
                 $('#b2').click(function() {
                     clickFunction(2);
                 });
                 $('#b3').click(function() {
                     clickFunction(3);
                 });
                 $('#b4').click(function() {
                     clickFunction(4);
                 });
                 $('#b5').click(function() {
                     clickFunction(5);
                 });
                 $('#b6').click(function() {
                     clickFunction(6);
                 });
                 $('#b7').click(function() {
                     clickFunction(7);
                 });
                 $('#b8').click(function() {
                     clickFunction(8);
                 });
            }

            $(document).ready(readyFunction);
        </script>
    </head>
    <body>
        <h1>Tile Puzzle</h1>
        <div id="buttons">
            <button id="b0"></button>
            <button id="b1"></button>
            <button id="b2"></button>
            <br>
            <button id="b3"></button>
            <button id="b4"></button>
            <button id="b5"></button>
            <br>
            <button id="b6"></button>
            <button id="b7"></button>
            <button id="b8"></button>
        </div>
        <br>
        <br>
        <div id="result_move"></div>
        <br>
        <br>
        <div id="table"></div>
    </body>
</html>
