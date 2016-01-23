function drawTable() {
    ctx.clearRect (0, 0, canvas.width, canvas.height);
    drawGrid();
    drawTiles();
}

function drawGrid() {
    var width = canvas.width;
    var tileWidth = width / SIZE;
    for (var i = 1; i < SIZE; i++) {
        ctx.beginPath();
        ctx.moveTo(tileWidth * i, 0);
        ctx.lineTo(tileWidth * i, width);
        ctx.stroke();
        ctx.beginPath();
        ctx.moveTo(0, tileWidth * i);
        ctx.lineTo(width, tileWidth * i);
        ctx.stroke();
    }
}

function drawTiles() {
    var width = canvas.width;
    var tileWidth = width / SIZE;
    var yOffset = tileWidth / 5;
    ctx.font = tileWidth / 2 + "px Arial";
    for (var i = 0; i < SIZE * SIZE; i++) {
        if (table[i] > 0) {
            if (table[i] < 10) {
                var xOffset = tileWidth / 7;
            } else {
                var xOffset = tileWidth / 4;
            }
            ctx.fillText(table[i],
                tileWidth * (i % SIZE) + tileWidth / 2 - xOffset,
                tileWidth * (Math.floor(i / SIZE)) + tileWidth / 2 + yOffset);
        }
    }
}
