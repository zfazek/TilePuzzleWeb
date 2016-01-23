var nofMoves = 0;
var SIZE = 3;
var MAX_SIZE = 10;
var MIN_SIZE = 1;
var table = new Array(MAX_SIZE * MAX_SIZE);

function readyFn() {
    canvas = document.getElementById("canvas");
    ctx = canvas.getContext("2d");
    $("#button_start").click(startGame);
    $("#canvas").mousedown({canvas: canvas, ctx: ctx}, handleMouseDown);
    startGame();
}

function handleMouseDown(e) {
    var width = canvas.width;
    var tileWidth = width / SIZE;
    var canvasOffset = $("#canvas").offset();
    var offsetX = canvasOffset.left;
    var offsetY = canvasOffset.top;
    var mouseX = parseInt(e.pageX - offsetX);
    var mouseY = parseInt(e.pageY - offsetY);
    var index = Math.floor(mouseY / tileWidth) * SIZE + Math.floor(mouseX / tileWidth);
    swap(index);
    drawTable();
    nofMoves++;
    checkEnd();
}

function log(line) {
    $("#tmp").html(line);
}

function logTable() {
    var line = "";
    for (var i = 0; i < SIZE * SIZE; i++) {
        line += table[i] + " ";
    }
    log(line);
}

function startGame() {
    nofMoves = 0;
    setSize();
    shuffle();
    // logTable();
    drawTable();
}

function checkEnd() {
    if (isDone()) {
        alert("You make it in " + nofMoves + " moves!");
    }
}

function setSize() {
    var size = ($("#select_size").val());
    if (size < MIN_SIZE || size > MAX_SIZE) return;
    SIZE = size;
    resetTable();
}

function resetTable() {
    for (var i = 0; i < SIZE * SIZE; i++) {
        table[i] = i + 1;
    }
    table[SIZE * SIZE - 1] = 0;
}

function getHoleIdx() {
    return getTileIdx(0);
}

function getTileIdx(x) {
    for (var i = 0; i < SIZE * SIZE; i++) {
        if (table[i] == x) {
            return i;
        }
    }
    return -1;
}

function swap(coord) {
    if (isLegalMove(coord) == false) return;
    var holeIdx = getHoleIdx();
    if (holeIdx == -1) return;
    table[holeIdx] = table[coord];
    table[coord] = 0;
}

function shuffle() {
    var coord;
    var n = 10000;
    for (var i = 0; i < n; i++) {
        coord = Math.floor((Math.random() * SIZE * SIZE));
        if (isLegalMove(coord)) {
            swap(coord);
        }
    }
}

function isLegalMove(coord) {
    if (coord > SIZE * SIZE - 1) return false;
    var holeIdx = getHoleIdx();
    if (holeIdx == -1) return false;
    if (Math.abs(holeIdx - coord) == SIZE) return true;
    if (holeIdx % SIZE == 0 && coord - holeIdx == 1) return true;
    if (holeIdx % SIZE == SIZE - 1 && coord - holeIdx == -1) return true;
    if (holeIdx % SIZE > 0 && holeIdx % SIZE < SIZE - 1 && Math.abs(holeIdx - coord) == 1) return true;
    return false;
}

function isDone() {
    for (var i = 0; i < SIZE * SIZE - 1; i++) {
        if (table[i] != i + 1) {
            return false;
        }
    }
    if (table[SIZE * SIZE - 1] != 0) {
        return false;
    }
    return true;
}
